package ru.jigulin.soap.countryclient.currency;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyService(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    public void updateCurrencies(Set<Currency> newCurrencies) {
    	var oldCurrencies = new HashSet<Currency>(currencyRepository.findAll());
    	
    	var forRemove = new HashSet<Currency>(oldCurrencies);
    	forRemove.removeAll(newCurrencies);
    	if (!forRemove.isEmpty()) {
    		currencyRepository.deleteAll(forRemove);
    	}
    	
    	newCurrencies.removeAll(oldCurrencies);
    	if (!newCurrencies.isEmpty()) {
    		currencyRepository.saveAll(newCurrencies);
    	}
    }

}
