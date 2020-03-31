package com.webservices.restfulwebservices.controllers;

import com.webservices.restfulwebservices.versioning.Name;
import com.webservices.restfulwebservices.versioning.PersonV1;
import com.webservices.restfulwebservices.versioning.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersingController {

    @GetMapping("v1/person")
    public PersonV1 personV1() {
        return new PersonV1("Stephen Hawking");
    }

    @GetMapping("v2/person")
    public PersonV2 personV2() {
        return new PersonV2(new Name("Ida", "Rhodes"));
    }

    /*
    * GET http://localhost:8085/person/param?version=1
    * */
    @GetMapping(value = "/person/param", params = "version=1")
    public PersonV1 paramV1() {
        return new PersonV1("Stephen Hawking");
    }

    @GetMapping(value = "/person/param", params = "version=2")
    public PersonV2 paramV2() {
        return new PersonV2(new Name("Ida", "Rhodes"));
    }

    /*
     * GET http://localhost:8085/person/header
     * Header: X-API-VERSION = 1 (postman)
     * */
    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1() {
        return new PersonV1("Stephen Hawking");
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2() {
        return new PersonV2(new Name("Ida", "Rhodes"));
    }

    /*
     * GET http://localhost:8085/person/procedures
     * Header: Accept = application/vnd.company.app-v1+json (postman)
     * */
    @GetMapping(value = "/person/procedures", produces = "application/vnd.company.app-v1+json")
    public PersonV1 proceduresV1() {
        return new PersonV1("Stephen Hawking");
    }

    @GetMapping(value = "/person/procedures", produces = "application/vnd.company.app-v2+json")
    public PersonV2 proceduresV2() {
        return new PersonV2(new Name("Ida", "Rhodes"));
    }
}
