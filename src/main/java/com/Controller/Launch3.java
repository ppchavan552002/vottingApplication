package com.Controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.votterDao;
import com.Model.votter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch3  extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		String path="C:\\Users\\Victory\\OneDrive\\Desktop\\Advance-java\\Spring_Core\\vottingApplication\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String pass = request.getParameter("upass");
		String vote = request.getParameter("vote");
		
		votter v=new votter();
		v.setUsername(name);
		v.setEmail(email);
		v.setPassword(pass);
		v.setVote(vote);
		
		String res=cxt.getBean("vDao", votterDao.class).insertVotter(v);
		
		if(res.equals("insert")) {
			mv.setViewName("userlogin");
		}
		
		return mv;
	}

}
