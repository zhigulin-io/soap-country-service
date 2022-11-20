package ru.jigulin.soap.countryclient.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.jigulin.soap.countryclient.client.CountryClient;
import ru.jigulin.soap.countryclient.country.CountryService;
import ru.jigulin.soap.countryclient.currency.CurrencyService;

@Service
public class Scheduler {

    private final CountryClient countryClient;
    private final CurrencyService currencyService;
    private final CountryService countryService;

    @Autowired
    public Scheduler(CountryClient countryClient, CurrencyService currencyService, CountryService countryService) {
        this.countryClient = countryClient;
        this.currencyService = currencyService;
        this.countryService = countryService;
        scheduledTask();
    }

    @Scheduled(cron = "* */30 * * * *")
    @Transactional
    public void scheduledTask() {
        consistCurrencies();
        consistCountries();
    }

    private void consistCurrencies() {
        currencyService.updateCurrencies(countryClient.getAllCurrencies());
    }

    private void consistCountries() {
        countryService.updateCountries(countryClient.getFullInfo());
    }
}
