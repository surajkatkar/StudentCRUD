package com.studentcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.studentcrud.domain.Student;
import com.studentcrud.services.StudentService;

@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	
	@GetMapping("/")
	public String studentHandler(Model model)
	{
		System.out.println("Inside Handler");
		List <Student> listStudent=service.listAll();
		model.addAttribute("listStudent",listStudent);
		System.out.println("getting Data "+ listStudent);
		return "home"; 
	}
	
	@GetMapping("/new")
	public String newAdd(Model model)
	{
		model.addAttribute("student", new Student());
		return "new";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String saveStudent(@ModelAttribute ("student") Student std)
	{
		service.save(std);
		return "redirect:/";
	}
	
	@RequestMapping ("/edit/{id}")
	public ModelAndView editStudentPage(@PathVariable(name="id")int id)
	{
		ModelAndView mav=new ModelAndView("new");
		Student std=service.get(id);
		mav.addObject("student",std);
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteStudent(@PathVariable(name="id")int id)
	{
		service.delete(id);
		return "redirect:/";
	}
}
