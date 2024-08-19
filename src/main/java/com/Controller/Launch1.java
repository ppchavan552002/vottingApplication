package com.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.adminDao;
import com.Model.Candidate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch1 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		
		String username = request.getParameter("aname");
		String pass = request.getParameter("apass");
		
		String path = "C:\\Users\\Victory\\OneDrive\\Desktop\\Advance-java\\Spring_Core\\vottingApplication\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		
		String res=cxt.getBean("aDao", adminDao.class).verifyAdmin(username, pass);
		
		if (res.equals("valid")) {
			List<Candidate> cl= cxt.getBean("aDao", adminDao.class).showAll();
			mv.addObject("cl",cl);
			mv.addObject("check",username);
			mv.setViewName("adminPanel");
		}else {
			mv.setViewName("Adminlogin");
		}
		return mv;
	}

}
