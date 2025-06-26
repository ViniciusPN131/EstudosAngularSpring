package com.vinic.person.service;

import com.vinic.person.dto.request.PersonRequestDTO;
import com.vinic.person.dto.response.PersonResponseDTO;
import com.vinic.person.entidade.Person;
import com.vinic.person.repository.PersonRepository;
import com.vinic.person.util.PersonMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class PersonServiceImplements implements PersonService{

    private final PersonRepository personRepository;

    private final PersonMapper personMapper;

    @Override
    public PersonResponseDTO findById(Long id) {

        return personMapper.toPersonDTO(returnPerson(id));

    }

    @Override
    public List<PersonResponseDTO> findAll() {

        return personMapper.toPeopleDTO(personRepository.findAll());

    }

    @Override
    public PersonResponseDTO register(PersonRequestDTO personDTO) {

        Person person = personMapper.toPerson(personDTO);

        return personMapper.toPersonDTO(personRepository.save(person));

    }

    @Override
    public PersonResponseDTO update(PersonRequestDTO personDTO, Long id) {

        Person person = returnPerson(id);

        personMapper.updatePersonData(person,personDTO);

        personRepository.save(person);

        return personMapper.toPersonDTO(personRepository.save(person));

    }

    @Override
    public String delete(Long id) {

        personRepository.deleteById(id);

        return "Person id: "+" deleted";

    }


    private Person returnPerson(Long id){

        return personRepository.findById(id).orElseThrow(()-> new RuntimeException("Person wasn't found on database"));

    }
}

