package controller.rest.publ;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/publ")
public class HelloRest {

	public HelloRest() {
		super();
	}

	@RequestMapping(value = "/post", method = RequestMethod.POST)
	public String createBook(@RequestBody String body) {
		return String.format("Hello POST by %s", body);
	}

}
