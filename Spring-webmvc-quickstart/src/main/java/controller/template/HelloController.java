package controller.template;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	public HelloController() {
		super();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String printWelcome(Model model) {

		model.addAttribute("message", "Hello World!");

		return "index";
	}

}
