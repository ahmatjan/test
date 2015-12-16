package com.shenny.test.interceptor;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.shenny.test.anno.User;

/**
 * @ClassName: LoginInterceptor
 * @Description:
 * @author <a href="mailto:zhonghuagen@qq.com">Huagen_Zhong</a>
 * @date 2015年9月23日 下午1:24:59
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			User anno = handlerMethod.getMethodAnnotation(User.class);
			if (anno != null)
				try {
					//response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
					request.getRequestDispatcher("/error.htm").forward(request, response);
					return false;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		return true;
	}

}
