package com.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/home")
	public String getHomePage()
	{
		return "homepage";
	}

	@GetMapping("/welcome")
	public String getWelcomePage()
	{
		return "welcomepage";
	}
	@GetMapping("/admin")
	public String getAdminPage()
	{
		return "adminpage";
	}
	@GetMapping("/emp")
	public String getEmployeePage()
	{
		return "emppage";
	}
	@GetMapping("/mgr")
	public String getManagerPage()
	{
		return "mgrpage";
	}
	@GetMapping("/common")
	public String getCommonPage()
	{
		return "commonpage";
	}
	@GetMapping("/logout")
	public String getLogoutPage()
	{
		return "logoutpage";
	}
}
