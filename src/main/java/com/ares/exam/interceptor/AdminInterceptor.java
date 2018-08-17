package com.ares.exam.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ares.exam.util.Constants;
/**
 * 管理员权限拦截器
 * @author szares02
 *
 */
public class AdminInterceptor implements HandlerInterceptor{
	private static  final String ADMIN_VIEW="admin.html";
	private static  final String ADMIN_SUBVIEW="sub/"; 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
        String url =request.getRequestURI();
        if(url!=null&&(url.indexOf(ADMIN_VIEW)>0||url.indexOf(ADMIN_SUBVIEW)>0 )) {//登陆资源或请求，放行
        	HttpSession session = request.getSession();  
    	    Integer ak = (Integer) session.getAttribute(Constants.ADMIN_KEY); 
    	    if(ak==0||ak==4) {
    	    	return false;
    	    }
			
		}
		return true;
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
