package ru.jigulin.soap.countryclient.country;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    
    public void updateCountries(Set<Country> newCountries) {
    	var oldCountries = new HashSet<Country>(countryRepository.findAll());
    	
    	var forRemove = new HashSet<Country>(oldCountries);
    	forRemove.removeAll(newCountries);
    	if (!forRemove.isEmpty()) {
    		countryRepository.deleteAll(forRemove);
    	}
    	
    	newCountries.removeAll(oldCountries);
    	if (!newCountries.isEmpty()) {
    		countryRepository.saveAll(newCountries);
    	}
    }
}
