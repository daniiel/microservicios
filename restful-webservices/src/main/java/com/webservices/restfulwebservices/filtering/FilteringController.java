
package com.webservices.restfulwebservices.filtering;

import com.webservices.restfulwebservices.model.Person;
import com.webservices.restfulwebservices.model.Person2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering-person")
    public Person getPerson() {
        return new Person("Alan", LocalDate.of(1954, Month.JUNE, 7), "Londres");
    }

    @GetMapping("/filtering-person-list")
    public List<Person> getPersonList() {
        return Arrays.asList(new Person("Alan", LocalDate.of(1954, Month.JUNE, 7), "Londres"),
                new Person("Merlin", LocalDate.of(1990, Month.JUNE, 10), "Macondo"));
    }

    @GetMapping("/filtering2-person")
    public Person2 getPerson2() {
        return new Person2("Daniel", LocalDate.of(1990, Month.JUNE, 10), "Macondo");
    }
}
