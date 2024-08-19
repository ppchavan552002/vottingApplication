package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.adminDao;
import com.Dao.votterDao;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch5 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		String vote = request.getParameter("entervote");
		String name = request.getParameter("uname");
		
		
		String path="C:\\Users\\Victory\\OneDrive\\Desktop\\Advance-java\\Spring_Core\\vottingApplication\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";

		ApplicationContext cxt=new FileSystemXmlApplicationContext(path);
		
		String res=cxt.getBean("aDao", adminDao.class).voteUpdate(vote);
		
		System.out.println(res);
		if(res.equals("vote")) {
			cxt.getBean("vDao", votterDao.class).update(name);
			
		}
		mv.addObject("vote","vote");
		mv.setViewName("userlogin");
		return mv;
	}

}
