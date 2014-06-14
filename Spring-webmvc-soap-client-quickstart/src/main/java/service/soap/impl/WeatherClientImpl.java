package service.soap.impl;

import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import service.soap.WeatherClient;
import weather.wsdl.Forecast;
import weather.wsdl.ForecastReturn;
import weather.wsdl.GetCityForecastByZIP;
import weather.wsdl.GetCityForecastByZIPResponse;
import weather.wsdl.Temp;

@Service
public class WeatherClientImpl implements WeatherClient {

	@Autowired
	private WebServiceTemplate weatherWebServiceTemplate;

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode) {
		GetCityForecastByZIP request = new GetCityForecastByZIP();
		request.setZIP(zipCode);

		GetCityForecastByZIPResponse response = (GetCityForecastByZIPResponse) weatherWebServiceTemplate
				.marshalSendAndReceive(request, new SoapActionCallback(
						"http://ws.cdyne.com/WeatherWS/GetCityForecastByZIP"));
		return response;
	}

	public String printResponse(GetCityForecastByZIPResponse response) {
		StringBuilder result = new StringBuilder();
		ForecastReturn forecastReturn = response
				.getGetCityForecastByZIPResult();

		if (forecastReturn.isSuccess()) {
			result.append("\n");
			result.append("Forecast for " + forecastReturn.getCity() + ", "
					+ forecastReturn.getState() + "\n");

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			for (Forecast forecast : forecastReturn.getForecastResult()
					.getForecast()) {
				result.append(format.format(forecast.getDate()
						.toGregorianCalendar().getTime()));
				result.append(" ");
				result.append(forecast.getDesciption());
				result.append(" ");
				Temp temperature = forecast.getTemperatures();
				result.append(temperature.getMorningLow() + "\u00b0-"
						+ temperature.getDaytimeHigh() + "\u00b0 ");
				result.append("\n");
			}
		} else {
			result.append("No forecast received\n");
		}
		return result.toString();
	}

}
