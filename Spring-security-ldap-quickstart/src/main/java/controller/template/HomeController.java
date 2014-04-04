package controller.template;

import model.LdapUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.LdapUserService;

@Controller
public class HomeController {

	@Autowired
	private LdapUserService ldapUserService;

	public HomeController() {
		super();
	}

	@RequestMapping("/")
	public String homePage(Model model) {

		LdapUser ldapUser = ldapUserService.loadAuthenticatedUser();
		model.addAttribute("userId", ldapUser.getSAMAccountName());

		return "index";
	}

}
