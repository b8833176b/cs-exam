package com.ares.exam.web;
import java.util.Enumeration;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ares.exam.dto.Result;
import com.ares.exam.dto.UserDto;
import com.ares.exam.entity.PoliceInfo;
import com.ares.exam.exception.ParameterNullException;
import com.ares.exam.service.PoliceInfoService;
import com.ares.exam.util.Constants;
@Controller
@RequestMapping("/home")
public class LoginController extends BaseController{
	@Autowired
	private PoliceInfoService policeInfoService;
	@RequestMapping(value="/login",method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<String> login(@RequestParam String user,@RequestParam String pwd,@RequestParam String loginType){
		try {
			String username=user;
			PoliceInfo policeInfo=new PoliceInfo();
			policeInfo.setJh(username);
			policeInfo.setPwd(pwd);
			PoliceInfo p2=policeInfoService.getByUserAndPwd(policeInfo);
			if(p2!=null) {
				if(loginType== null ) return new Result<>(false,"参数缺失!");
				if(loginType.equals("admin")) {
					Integer ia=p2.getIsAdmin();
					if(ia!=null&&(ia!=0&&ia!=4)) {
						HttpSession session=getSession();
						session.setAttribute(Constants.JH_KEY, p2.getJh());
						session.setAttribute(Constants.USERNAME_KEY, p2.getXm());
						session.setAttribute(Constants.ADMIN_KEY, p2.getIsAdmin());
						session.setAttribute(Constants.USERID_KEY, p2.getUserID());
						return new Result<>(true,"登陆成功!");
					}else {
						return new Result<>(false,"您不是管理员!");
					}
				}else {
					if(p2.getIsAdmin()!=null&&!p2.getIsAdmin().equals(0))
						return new Result<>(false,"管理员不能登陆考生系统!");
					HttpSession session=getSession();
					session.setAttribute(Constants.JH_KEY, p2.getJh());
					session.setAttribute(Constants.USERNAME_KEY, p2.getXm());
					session.setAttribute(Constants.ADMIN_KEY, p2.getIsAdmin());
					session.setAttribute(Constants.USERID_KEY, p2.getUserID());
				//	request.getRequestDispatcher("admin.html").forward(request, response);
					return new Result<>(true,"登陆成功!");
					
				}
				
				
			}else {
				return new Result<>(false,"用户名或密码错误!");
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return new Result<>(false,"用户名或密码错误!");
		} catch (ParameterNullException e) {
			// TODO Auto-generated catch block
			return new Result<>(false,"请填写完整用户名或密码!");
		} 
		
	}
	
	@RequestMapping(value="/toAdmin", method= {RequestMethod.GET,RequestMethod.POST}) 
	public String toAdmin() {
		return "redirect:/admin.html";
	}
	
	@RequestMapping(value="/toHome", method= {RequestMethod.GET,RequestMethod.POST})
	public String toHome() {
		return "redirect:/home.html";
	}
	@RequestMapping(value="/toTrain", method= {RequestMethod.GET,RequestMethod.POST})
	public String toTrain() {
		return "redirect:/train.html";
	}
	
	@RequestMapping(value="/toExam", method= {RequestMethod.GET,RequestMethod.POST})
	public String toExam() {
		return "redirect:/Exam.html";
	}
	
	@RequestMapping(value="/toLogin", method= {RequestMethod.GET,RequestMethod.POST})
	public String toLogin() {
		return "redirect:/Login.html";
	}
	
	@RequestMapping(value="/toUserLogin", method= {RequestMethod.GET,RequestMethod.POST})
	public String toUserLogin() {
		return "redirect:/Login.html";
	}
	
	/**
	 * 获取登陆信息
	 * @return
	 */
	@RequestMapping(value="/getUserInfo", method= {RequestMethod.GET,RequestMethod.POST})
	public @ResponseBody Result<UserDto> getInfo(){
		HttpSession session=getSession();
		String username=(String) session.getAttribute(Constants.USERNAME_KEY);
		if(username != null) {
			UserDto ud=new UserDto();
			ud.setUsername(username);
			return new Result<UserDto>(true,"查询成功",ud);
		}else {
			return new Result<>(false,"你需要重新登陆!");
		}
	}
	
	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value="/logout", method= {RequestMethod.GET,RequestMethod.POST})
	public String logout(){
		HttpSession session=getSession();
		Enumeration<String> em=session.getAttributeNames();
		while(em.hasMoreElements()) {
			session.removeAttribute(em.nextElement().toString());
		}
		session.removeAttribute(Constants.ADMIN_KEY);
		session.removeAttribute(Constants.JH_KEY);
		session.removeAttribute(Constants.USERNAME_KEY);
		return "redirect:/home/toLogin";
	}
	
/*	
	public static HttpSession getSession() { 
	    HttpSession session = null; 
	    try { 
	        session = getRequest().getSession(); 
	    } catch (Exception e) {} 
	        return session; 
	} 
	    
	public static HttpServletRequest getRequest() { 
	    ServletRequestAttributes attrs =(ServletRequestAttributes) RequestContextHolder.getRequestAttributes(); 
	    return attrs.getRequest(); 
	} 
*/
}
