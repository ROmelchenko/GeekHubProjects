package com.spduniversity.dto;

import com.google.common.base.Stopwatch;
import com.spduniversity.entity.Person;

import java.util.List;

public class PersonsResponse {

    private String prettyTime;
    private List<Person> persons;
    private List<Stat> stats;

    public PersonsResponse(Stopwatch stopwatch, List<Person> persons, List<Stat> stats) {
        this.prettyTime = stopwatch + "";
        this.persons = persons;
        this.stats = stats;
    }

    public String getPrettyTime() {
        return prettyTime;
    }

    public void setPrettyTime(String prettyTime) {
        this.prettyTime = prettyTime;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}
