package com.hcl.java;

import java.util.List;

import org.hibernate.query.criteria.internal.expression.function.AggregationFunction.COUNT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class EmployeeController {
	private int x=5,pagesize=0;

	@Autowired
	EmployeeDao dao;
	@RequestMapping("/")
	public ModelAndView getEmployees() {
		ModelAndView mv=new ModelAndView();
		List<Employ> lst=(List<Employ>) dao.findAll();
		mv.addObject("employeeList",dao.findAll());
		mv.addObject("total",lst.size());
		mv.addObject("pagesize",x);
		mv.setViewName("home");
		return mv;
	}
	@RequestMapping("/displaycontractor")
		public ModelAndView getJavaContractors() {
			ModelAndView mv=new ModelAndView();
			mv.addObject("employeeList",dao.findByDeptAndDesign("h", "g"));
			mv.setViewName("home");
			return mv;
		
	}
	@RequestMapping("/managersalary")
	public ModelAndView getManagerSalary() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findManagerSalary("h", "g", 68));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/managername")
	public ModelAndView getManagerName() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findManagerName(31000,"devel"));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/name")
	public ModelAndView getName() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findName("vinod"));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayallsortbydesigndesending")
	public ModelAndView displayAllSortByDesignDesc() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findAll(Sort.by("desig").descending()));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayallsortbydesign")
	public ModelAndView displayAllSortByDesign() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findAll(Sort.by("desig")));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayallsortbydesignandsalary")
	public ModelAndView displayAllSortByDesignandsalary() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findAll(Sort.by("desig","basic").descending() ));
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayallsortbydesignandsalary1")
	public ModelAndView displayAllSortByDesignandsalary1() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findAll(Sort.by("desig").descending() ));
		mv.addObject("employeeList",dao.findAll(Sort.by("basic")));

		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayall4")
	public ModelAndView sortByDesigAndSalDes() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findJavaEmp("developer") );
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayall5")
	public ModelAndView sortByJavaManager() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findjavaM("developer",100000) );
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayall6")
	public ModelAndView sortByJavaManager1() {
		ModelAndView mv=new ModelAndView();
		mv.addObject("employeeList",dao.findjavaM1("developer",100000) );
		mv.setViewName("home");
		return mv;
	
}
	@RequestMapping("/displayAll/Page/{pageno}")
	public ModelAndView DisplayAllsortByDesig(@PathVariable("pageno") int pageno) {
		ModelAndView mv=new ModelAndView();
		/**long x=12;
		int y = 0;
		if(x-2>2) {
			x=x-2;
			y++;
			
		}
		else {
			y=y++;
		}**/
		mv.addObject("employeeList",dao.findAll(PageRequest.of(pageno, x)).getContent() );
		mv.addObject("pagesize",x);
		mv.addObject("total",8);
		mv.setViewName("home");
		return mv;
	
}
	
}
