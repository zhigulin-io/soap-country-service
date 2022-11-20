package ru.jigulin.soap.countryclient.client;

import ru.jigulin.soap.countryclient.country.Country;
import ru.jigulin.soap.countryclient.wsdl.TCountryInfo;

public final class CountryConvertor {
	private CountryConvertor() {}
	
	public static Country convert(TCountryInfo soapCountry) {
		var country = new Country();
				
		country.setCode(soapCountry.getSISOCode());
		country.setName(soapCountry.getSName());
		country.setCapital(soapCountry.getSCapitalCity());
		country.setPhoneCode(soapCountry.getSPhoneCode());
		country.setFlagLink(soapCountry.getSCountryFlag());
		country.setCurrencyCode(soapCountry.getSCurrencyISOCode());
		
		return country;
	}
}
