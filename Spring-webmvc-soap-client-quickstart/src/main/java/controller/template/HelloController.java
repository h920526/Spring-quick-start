package controller.template;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import service.soap.WeatherClient;
import weather.wsdl.GetCityForecastByZIPResponse;

@Controller
public class HelloController {

	@Autowired
	private WeatherClient weatherClient;

	public HelloController() {
		super();
	}

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String printWelcome() {
		GetCityForecastByZIPResponse response = weatherClient
				.getCityForecastByZip("94304");

		StringBuilder builder = new StringBuilder();
		builder.append("<html><body><pre>");
		builder.append(weatherClient.printResponse(response));
		builder.append("</pre></body></html>");
		return builder.toString();
	}

}
