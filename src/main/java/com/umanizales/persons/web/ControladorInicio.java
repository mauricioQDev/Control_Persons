package com.umanizales.persons.web;

import com.umanizales.persons.domain.Person;
import com.umanizales.persons.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
@Slf4j
public class ControladorInicio {
    
    @Autowired
    private PersonService personService;
    
    @GetMapping("/")
    public String inicio(Model model){
        var persons = personService.listPersons();
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("persons", persons);
        return "index";
    }

    @GetMapping("/add")
    public String add(Person person){
        return "modify";
    }

    @PostMapping("/save")
    public String save(@Valid Person person, Errors errors){
        if (errors.hasErrors()){
            return "modify";
        }
        personService.save(person);
        return "redirect:/";
    }

    @GetMapping("/edit/{idPerson}")
    public String edit(Person person, Model model){
        person = personService.findPerson(person);
        model.addAttribute("person", person);
        return "modify";
    }

    @GetMapping("/delete/{idPerson}")
    public String delete(Person person){
        personService.delete(person);
        return "redirect:/";
    }
}
