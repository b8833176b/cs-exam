package com.ares.exam.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ares.exam.util.Constants;
/**
 * 用于拦截所有请求，权限验证(登陆)
 * @author szares02
 *
 */
public class SecurityInterceptor implements HandlerInterceptor{
	//登陆资源包含的字符
	private static  final String LOGIN="Wopop"; 
	private static final String USER_LOGIN="Login";
	private static final String LOGIN_ACTION="home/login";
	private static final String TO_LOGIN="toLogin";
	private static final String IMG="img";
	private static final String ASSETS="assets";
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//获取请求的URL
		String url =request.getRequestURI();
		
		System.out.println(url);
		if(url!=null&&(url.indexOf(LOGIN)>0||url.indexOf(LOGIN_ACTION)>0||url.indexOf(TO_LOGIN)>0||url.indexOf(USER_LOGIN)>0)||url.indexOf(IMG)>0||url.indexOf(ASSETS)>0) {//登陆资源或请求，放行
			return true;
		}
		else { //判断是否登陆
			  HttpSession session = request.getSession();  
       //       String username = (String) session.getAttribute(Constants.USERNAME_KEY); 
              Object obj= session.getAttribute(Constants.USERNAME_KEY); 
              if(obj != null) {
            	  return true;
              }else {
            	  request.getRequestDispatcher("/home/toLogin").forward(request, response);
            	  System.out.println("!!!!!");
            	  return false;
              }
		}
	//	return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
