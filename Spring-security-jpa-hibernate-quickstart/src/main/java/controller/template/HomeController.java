package controller.template;

import model.UserAuthorityInfo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	public HomeController() {
		super();
	}

	@RequestMapping("/")
	public String homePage(Model model) {

		model.addAttribute("userName", UserAuthorityInfo.get().getUserName());

		return "index";
	}

}
