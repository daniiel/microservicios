package com.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.webservices.restfulwebservices.model.Person3;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;

@RestController
public class DynamicFiltering {

    @GetMapping("/dynamic-filter")
    public MappingJacksonValue getPerson() {
        Person3 person = new Person3("Alan", LocalDate.of(1954, Month.JUNE, 7), "Londres");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("name");
        FilterProvider filters = new SimpleFilterProvider()
                .addFilter("filter-person", filter);
        MappingJacksonValue mapping = new MappingJacksonValue(person);
        mapping.setFilters(filters);
        return mapping;
    }
}
