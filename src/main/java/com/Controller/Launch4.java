package com.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.adminDao;
import com.Dao.votterDao;
import com.Model.Candidate;
import com.Model.votter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch4 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		String path="C:\\Users\\Victory\\OneDrive\\Desktop\\Advance-java\\Spring_Core\\vottingApplication\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		
		String res=cxt.getBean("vDao", votterDao.class).checkVotter(name,pass);
		if(res == null) {
			res="failed";
			mv.addObject("vote", res);
			mv.setViewName("userlogin");
		}else if(res.equals("No")) {
			List<Candidate> cl= cxt.getBean("aDao", adminDao.class).showAll();
			mv.addObject("cl",cl);
			mv.addObject("vote", res);
			mv.addObject("una", name);
			mv.setViewName("vottingPage");
			
		}else if(res.equals("Yes")) {
			mv.addObject("vote", res);
			mv.setViewName("userlogin");
		}
		return mv;
	}

}
