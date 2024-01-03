package ru.netology.jpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.jpa.repository.Person;
import ru.netology.jpa.repository.UserRepository;
import java.util.List;

@RestController
public class AuthorizationController {
    private final UserRepository repository;

    public AuthorizationController(UserRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/persons/by-city")
    public List<Person> getAuthorities(@RequestParam("city") String city) {
        return repository.getPersonsByCity(city);
    }
}
