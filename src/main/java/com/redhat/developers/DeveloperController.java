package com.redhat.developers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/spring-developer")
public class DeveloperController {

    @Autowired
    SpringDeveloperRepository developerRepository;

    @GetMapping
    public List<Developer> developers(@RequestParam("brazilian") boolean brazilian) {
        if (brazilian) {
            return developerRepository.findByName("Yanaga");
        }
        return Developer.listAll();
    }

}