package service.soap;

import weather.wsdl.GetCityForecastByZIPResponse;

public interface WeatherClient {

	public GetCityForecastByZIPResponse getCityForecastByZip(String zipCode);

	public String printResponse(GetCityForecastByZIPResponse response);

}
