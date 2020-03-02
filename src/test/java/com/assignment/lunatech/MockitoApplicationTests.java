package com.assignment.lunatech;

import com.assignment.lunatech.controller.SummaryController;
import com.assignment.lunatech.domain.consumed.Airport;
import com.assignment.lunatech.domain.consumed.Country;
import com.assignment.lunatech.services.AirportService;
import com.assignment.lunatech.services.CountryService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SummaryController.class)
public class MockitoApplicationTests {

    @MockBean
    private AirportService airportService;

    @MockBean
    private CountryService countryService;

    @Test
    public void getAllCountriesTest() {
        List<Country> list = countryService.getAllCountries();
        Mockito.when(countryService.getAllCountries()).thenReturn(list);
    }

    @Test
    public void getAirportsPerCountryTest() {
        String country = "PL";
        List<Airport> list = airportService.getAirportsPerCountry("PL");
        Mockito.when(airportService.getAirportsPerCountry(country)).thenReturn(list);
    }

    @Test
    public void getAllAirportsTest() {
        List<Airport> list = airportService.getAllAirports();
        Mockito.when(airportService.getAllAirports()).thenReturn(list);
    }
}
