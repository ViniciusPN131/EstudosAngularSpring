package com.vinic.person.controller;

import com.vinic.person.dto.response.PersonResponseDTO;
import com.vinic.person.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping
    private ResponseEntity<PersonResponseDTO> findById(@PathVariable Long id){

        return ResponseEntity.ok().body(personService.findById(id));

    }

    @GetMapping
    private ResponseEntity<List<PersonResponseDTO>> findAll(){

        

    }

}
