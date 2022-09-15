package com.example.controller;

import com.example.dao.PersonDAO;
import com.example.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin
@Controller
@RequestMapping("/api/people")
public class PeopleRESTController {
    private final PersonDAO personDAO;

    public PeopleRESTController(@Autowired PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
    @GetMapping

    public @ResponseBody List<Person> getPeople(){
       return  personDAO.index();
    }
}
