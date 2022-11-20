package ru.jigulin.soap.countryclient.client;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import ru.jigulin.soap.countryclient.country.Country;
import ru.jigulin.soap.countryclient.currency.Currency;
import ru.jigulin.soap.countryclient.wsdl.FullCountryInfoAllCountries;
import ru.jigulin.soap.countryclient.wsdl.FullCountryInfoAllCountriesResponse;
import ru.jigulin.soap.countryclient.wsdl.ListOfCurrenciesByCode;
import ru.jigulin.soap.countryclient.wsdl.ListOfCurrenciesByCodeResponse;

public class CountryClient extends WebServiceGatewaySupport {

    public Set<Country> getFullInfo() {
        var req = new FullCountryInfoAllCountries();
        return ((FullCountryInfoAllCountriesResponse) getWebServiceTemplate().marshalSendAndReceive(req))
        		.getFullCountryInfoAllCountriesResult()
        		.getTCountryInfo()
        		.stream()
        		.map(CountryConvertor::convert)
        		.collect(Collectors.toSet());
    }

    public Set<Currency> getAllCurrencies() {
        var req = new ListOfCurrenciesByCode();
        return ((ListOfCurrenciesByCodeResponse) getWebServiceTemplate().marshalSendAndReceive(req))
        		.getListOfCurrenciesByCodeResult()
        		.getTCurrency()
        		.stream()
        		.map(CurrencyConvertor::convert)
        		.collect(Collectors.toSet());
    }
}
