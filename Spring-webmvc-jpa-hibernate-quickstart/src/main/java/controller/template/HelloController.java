package controller.template;

import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;

@Controller
public class HelloController {

	@Autowired
	private UserService userService;

	public HelloController() {
		super();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(Model model) {

		User user = userService.findUserByKey(1);
		model.addAttribute("message", user.getUserName());

		return "index";
	}

}
