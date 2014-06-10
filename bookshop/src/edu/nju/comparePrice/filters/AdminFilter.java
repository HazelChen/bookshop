package edu.nju.comparePrice.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.nju.bookHouse.model.User;

public class AdminFilter extends HttpServlet implements javax.servlet.Filter{
	private static final long serialVersionUID = -1310252912656204148L;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest sRequest, ServletResponse sResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) sRequest;
		HttpServletResponse response = (HttpServletResponse) sResponse;
		HttpSession session = request.getSession();
		
		String contextPath=request.getContextPath();
		String url=request.getServletPath();
		
		if (!url.contains("css") && !url.contains("js")  && !url.contains("image")
				&& !url.contains("manager") && url.contains("admin") && !url.contains("ogin")) {
			User admin = (User) session.getAttribute("admin");
			if (admin == null) {
				response.sendRedirect(contextPath+"/admin/login.jsp"); 
				return;
			}
		}
        chain.doFilter(sRequest, sResponse); 
	}

}
