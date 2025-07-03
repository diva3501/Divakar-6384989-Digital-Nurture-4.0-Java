package com.cognizant.orm_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm_learn.model.Country;
import com.cognizant.orm_learn.service.CountryService;
import com.cognizant.orm_learn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
    private static CountryService countryService;

    public static void main(String[] args) throws CountryNotFoundException {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);

        testAddCountry();
        testFindCountry();
        testUpdateCountry();
        testDeleteCountry();
        testSearchCountry();
    }

    private static void testAddCountry() {
        LOGGER.info("Start testAddCountry");
        Country c = new Country("JP", "Japan");
        countryService.addCountry(c);
        LOGGER.info("End testAddCountry");
    }

    private static void testFindCountry() throws CountryNotFoundException {
        LOGGER.info("Start testFindCountry");
        Country country = countryService.findCountryByCode("JP");
        LOGGER.debug("Country: {}", country);
        LOGGER.info("End testFindCountry");
    }

    private static void testUpdateCountry() throws CountryNotFoundException {
        LOGGER.info("Start testUpdateCountry");
        countryService.updateCountry("JP", "Nippon");
        LOGGER.info("Updated country name to Nippon");
        LOGGER.info("End testUpdateCountry");
    }

    private static void testDeleteCountry() {
        LOGGER.info("Start testDeleteCountry");
        countryService.deleteCountry("JP");
        LOGGER.info("Deleted JP");
        LOGGER.info("End testDeleteCountry");
    }

    private static void testSearchCountry() {
        LOGGER.info("Start testSearchCountry");
        countryService.findCountriesByPartialName("in").forEach(c -> LOGGER.debug("{}", c));
        LOGGER.info("End testSearchCountry");
    }
}
