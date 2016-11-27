package com.spduniversity.controllers;

import com.google.common.base.Stopwatch;
import com.spduniversity.dto.PersonsResponse;
import com.spduniversity.dto.Stat;
import com.spduniversity.entity.Person;
import com.spduniversity.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("persons")
public class PersonController {

    public static final int PAGE_SIZE = 3;
    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("v1")
    public PersonsResponse listv1(@RequestParam(required = false) String name, @RequestParam(required = false) String jobTitle, @RequestParam(required = false) String age) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Person> persons = personRepository.list();
        if (name == null) {
            return new PersonsResponse(stopwatch.stop(), persons.size() > 3 ? persons.subList(0, 3) : persons, getStubStat());
        }
        List<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (person.getFirstName().toLowerCase().contains(name.toLowerCase()) || person.getLastName().toLowerCase().contains(name.toLowerCase()) || person.getJobTitle().toLowerCase().contains(jobTitle.toLowerCase()) || person.getAge().toString().toLowerCase().contains(age.toLowerCase())) {
                result.add(person);
            }
        }
        return new PersonsResponse(stopwatch.stop(), result.size() > 3 ? result.subList(0, 3) : result, getStubStat());
    }

    @RequestMapping("v1f")
    public PersonsResponse listv1f(@RequestParam(required = false) String name, @RequestParam(required = false) String jobTitle, @RequestParam(required = false) String age) {
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Person> persons = personRepository.list();
        if (name == null) {
            return new PersonsResponse(stopwatch.stop(), persons.size() > 3 ? persons.subList(0, 3) : persons, getStubStat());
        }
        List<Person> result = new ArrayList<>();
        int maxCount = 3;
        for (Person person : persons) {
            if (maxCount == 0) {
                break;
            }
            if (person.getFirstName().toLowerCase().contains(name.toLowerCase()) || person.getLastName().toLowerCase().contains(name.toLowerCase()) || person.getJobTitle().toLowerCase().contains(jobTitle.toLowerCase()) || person.getAge().toString().toLowerCase().contains(age.toLowerCase())) {
                result.add(person);
                maxCount--;
            }
        }
        return new PersonsResponse(stopwatch.stop(), result, getStubStat());
    }


    @RequestMapping("v2")
    public PersonsResponse listv2(@RequestParam(required = false) String name, @RequestParam(required = false) String jobTitle, @RequestParam(required = false) String age) {
        String lowercaseName = (name == null) ? null : name.toLowerCase();
        String lowercaseJob = (jobTitle == null) ? null : jobTitle.toLowerCase();
        String lowercaseAge = (age == null) ? null : age.toString().toLowerCase();
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Person> result = personRepository.list().stream()
                .filter(p -> lowercaseName == null || p.getFirstName().toLowerCase().contains(lowercaseName) || p.getLastName().toLowerCase().contains(lowercaseName))
                .filter(p -> lowercaseJob == null || p.getJobTitle().toLowerCase().contains(lowercaseJob))
                .filter(p -> lowercaseAge == null || p.getAge().toString().toLowerCase().contains(lowercaseJob))
                .limit(3).collect(Collectors.toList());
        return new PersonsResponse(stopwatch.stop(), result, getStubStat());
    }


    @RequestMapping("v3")
    public PersonsResponse listv3(@RequestParam(required = false) String name, @RequestParam(required = false) String jobTitle, @RequestParam(required = false) String age) {
        String lowercaseName = (name == null) ? null : name.toLowerCase();
        String lowercaseJob = (jobTitle == null) ? null : jobTitle.toLowerCase();
        String lowercaseAge = (age == null) ? null : age.toString().toLowerCase();
        Stopwatch stopwatch = Stopwatch.createStarted();
        List<Person> result = personRepository.list().parallelStream()
                .filter(p -> lowercaseName == null || p.getFirstName().toLowerCase().contains(lowercaseName) || p.getLastName().toLowerCase().contains(lowercaseName))
                .filter(p -> lowercaseJob == null || p.getJobTitle().toLowerCase().contains(lowercaseJob))
                .filter(p -> lowercaseJob == null || p.getAge().toString().toLowerCase().contains(lowercaseAge))
                .limit(PAGE_SIZE).collect(Collectors.toList());
        return new PersonsResponse(stopwatch.stop(), result, getStubStat());
    }

    private List<Stat> getStubStat() {
        List<Stat> result = IntStream.range(1, PAGE_SIZE)
                .mapToObj(e -> new Stat("name" + e, 0.0 + new Random().nextInt(100/PAGE_SIZE)))
                .collect(Collectors.toList());
        result.add(new Stat("Other", 100 - result.stream().mapToDouble(Stat::getValue).sum()));
        return result;
    }


}
