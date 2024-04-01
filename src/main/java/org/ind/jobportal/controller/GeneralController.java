package org.ind.jobportal.controller;

import java.time.LocalDate;


import org.ind.jobportal.dto.PortalUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Controller
public class GeneralController {
	@Autowired
	PortalUser portalUser;
	@GetMapping("/")
	public String loadHome() {
		return "home.html";
	}
	
	@GetMapping("/login")
	public String loadLogin()
	{
		return "login.html";
	}
//	@GetMapping("/signup")
//	public String loadSignup() {
//		return "signup.html";
//	}
//	@PostMapping("/signup")
//	public String loadSignup(@RequestParam String name) {
//		System.out.println(name);
//		return "login.html";
//	}
//	@PostMapping("/signup")
//	public String loadSignup(PortalUser portalUser) {
//		System.out.println(portalUser);//PortalUser(name=tha, email=indirard5599@gmail.com, mobile=916364282351, dob=2024-03-05, password=pjj, confirm_password=gha, role=applicant)
//		return "login.html";
//	}
//	@GetMapping("/signup")
//	public String loadSignup(ModelMap map) {
//		map.put("msg", "hey, what nonsence");
//		return "signup.html";
//	}
	@PostMapping("/signup")
	public String loadSignup(@Valid PortalUser portalUser, BindingResult result) {
		if(LocalDate.now().getYear()-portalUser.getDob().getYear()<18)
			result.rejectValue("dob", "error.dob", "*Age should be greater than 18");
		if(!portalUser.getPassword().equals(portalUser.getConfirm_password()))
			result.rejectValue("confirm_password", "error.confirm_password"," *Password and Confirm Password should be same");
		if(result.hasErrors())
			return "signup.html";
		else
			return "login.html";
	}
	@GetMapping("/signup")
	public String loadSignup(ModelMap map) {
		map.put("portalUser",portalUser);
		return "signup.html";
	}

}
