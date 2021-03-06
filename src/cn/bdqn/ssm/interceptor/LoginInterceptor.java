package cn.bdqn.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import cn.bdqn.ssm.pojo.User;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		//获取session
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		if (user==null) {
			response.sendRedirect(request.getContextPath()+"/401.jsp");
			return false;
		}
		return true;
	}
}
