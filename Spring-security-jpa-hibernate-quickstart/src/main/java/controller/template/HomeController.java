package controller.template;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
public class HomeController {

	@Autowired
	private UserService userService;

	public HomeController() {
		super();
	}

	@RequestMapping("/")
	public String homePage(Model model) {

		User user = userService.loadAuthenticatedUser();
		model.addAttribute("userName", user.getUserName());

		return "index";
	}

}
