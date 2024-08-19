package com.Controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.Dao.adminDao;
import com.Model.Candidate;
import com.mysql.cj.callback.UsernameCallback;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Launch2 extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ModelAndView mv=new ModelAndView();
		
		String path="C:\\Users\\Victory\\OneDrive\\Desktop\\Advance-java\\Spring_Core\\vottingApplication\\src\\main\\webapp\\WEB-INF\\spring-servlet.xml";
		
		ApplicationContext cxt = new FileSystemXmlApplicationContext(path);
		
		String name = request.getParameter("cname");
		String age = request.getParameter("cage");
		String city = request.getParameter("ccity");
		String votes = request.getParameter("votes");
		
		Candidate c=new Candidate();
		c.setName(name);
		c.setAge(Integer.valueOf(age));
		c.setCity(city);
		c.setVotes(Integer.valueOf(votes));
		
		String res=cxt.getBean("aDao", adminDao.class).enterCandidate(c);
		System.out.println(res);
		if(res.equals("inserted")) {
			List<Candidate> cl= cxt.getBean("aDao", adminDao.class).showAll();
			mv.addObject("cl",cl);
			mv.addObject("check", name);
			mv.setViewName("adminPanel");
		}
		
		return mv;
	}

}
