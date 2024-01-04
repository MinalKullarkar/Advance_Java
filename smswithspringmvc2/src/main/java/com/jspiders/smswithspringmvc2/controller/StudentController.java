package com.jspiders.smswithspringmvc2.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspiders.smswithspringmvc2.pojo.AdminPOJO;
import com.jspiders.smswithspringmvc2.pojo.StudentPOJO;
import com.jspiders.smswithspringmvc2.service.StudentService;

import antlr.collections.List;

@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(path = "/add_student", method = RequestMethod.GET)
	public String getPageToAddStudent(HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			return "add_student";
		}
		else {
			return "log_in";
		}
		
	}
	
	@RequestMapping(path="/add_student", method = RequestMethod.POST)
	public String addStudent(@RequestParam String name, @RequestParam String email,@RequestParam long mobile,
			@RequestParam byte age, ModelMap modelMap) {
		studentService.addStudent(name,email,mobile,age);
		modelMap.addAttribute("message","Student Added");
		
		return "add_student";
	}
	
	@RequestMapping(path="/get_students")
	public String getAllStudent(ModelMap modelMap,HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			java.util.List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students",students);
			return "get_students";
		}
		else {
			return "log_in";
		}
		
	}
	
	@RequestMapping(path="/delete_student",method=RequestMethod.GET)
	public String getPageToBeDeleteStudent(ModelMap modelMap,HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			java.util.List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "delete_Student";
		}
		else {
			return "log_in";
		}	
	}
	
	@RequestMapping(path="/delete_student",method = RequestMethod.POST)
	public String deleteStudent(@RequestParam int id,ModelMap modelMap) {
		String message = studentService.deleteStudent(id);
		modelMap.addAttribute("message",message);
		java.util.List<StudentPOJO> students=studentService.getAllStudents();
		modelMap.addAttribute("students",students);
		return "delete_Student";
		
	}
	@RequestMapping(path = "edit_student", method = RequestMethod.GET)
	public String getPageToEditStudent(ModelMap modelMap,HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			java.util.List<StudentPOJO> students = studentService.getAllStudents();
			modelMap.addAttribute("students", students);
			return "edit_student";
		}
		else {
			return "log_in";
		}
		
	}

	@RequestMapping(path = "edit_student", method = RequestMethod.POST)
	public String editStudent(@RequestParam long id, ModelMap modelMap) {
		StudentPOJO student = studentService.editStudent(id);
		modelMap.addAttribute("student", student);
		return "update_student";
	}
	@RequestMapping(path = "update_student", method = RequestMethod.POST)
	public String updateStudent(@RequestParam long id, @RequestParam String name, @RequestParam String email,
			@RequestParam long mobile, @RequestParam byte age, ModelMap modelMap) {
		studentService.updateStudent(id, name, email, mobile, age);
		java.util.List<StudentPOJO> students = studentService.getAllStudents();
		modelMap.addAttribute("students", students);
		modelMap.addAttribute("message", "Student updated.");
		return "edit_student";
	}
	@RequestMapping(path = "/search", method = RequestMethod.GET)
	public String getPageToSearchStudent(HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			return "search";
		}
		else {
			return "log_in";
		}
				
	}

	@RequestMapping(path = "/search", method = RequestMethod.POST)
	public String searchStudentByPattern(@RequestParam String pattern, ModelMap modelMap) {
		java.util.List<StudentPOJO> students = studentService.searchStudentByPattern(pattern);
		modelMap.addAttribute("students", students);
		return "search";
	}
	
	@RequestMapping(path = "/searchbyid", method = RequestMethod.GET)
	public String getPageToSearchById(HttpSession httpSession) {
		AdminPOJO admin=(AdminPOJO) httpSession.getAttribute("admin");
		if (admin!=null) {
			return "searchbyid";
		}
		else {
			return "log_in";
		}
				
	}
	
	@RequestMapping(path="/searchbyid", method = RequestMethod.POST)
	public String searchStudentById(@RequestParam int id, ModelMap modelMap) {
		java.util.List<StudentPOJO> students=studentService.searchStudentById(id);
		modelMap.addAttribute("students",students);
		return "searchbyid";
	}
}
