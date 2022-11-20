package ru.jigulin.soap.countryclient.client;

import ru.jigulin.soap.countryclient.currency.Currency;
import ru.jigulin.soap.countryclient.wsdl.TCurrency;

public final class CurrencyConvertor {
	
	private CurrencyConvertor() {}
	
	public static Currency convert(TCurrency soapCurrency) {
		var currency = new Currency();
		currency.setCode(soapCurrency.getSISOCode());
		currency.setName(soapCurrency.getSName());
		return currency;
	}
}
