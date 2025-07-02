package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import com.cognizant.orm_learn.service.CountryService;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com/cognizant/orm_learn/service", "com/cognizant/orm_learn/repository", "com/cognizant/orm_learn/model"})
public class OrmLearnApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		LOGGER.info("Inside main");

		countryService = context.getBean(CountryService.class);
		testGetAllCountries();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.info("Countries: {}", countries);
		LOGGER.info("End");
	}
}
