package com.vinic.person.util;

import com.vinic.person.dto.request.PersonRequestDTO;
import com.vinic.person.dto.response.PersonResponseDTO;
import com.vinic.person.entidade.Person;

import java.util.List;
import java.util.stream.Collectors;

public class PersonMapper {

    public Person toPerson(PersonRequestDTO personDTO){

    Person person = Person.builder()
            .name(personDTO.getName())
            .cpf(personDTO.getCpf())
            .age(personDTO.getAge())
            .build();

    }


    public PersonResponseDTO toPersonDTO(Person person){

        return new PersonResponseDTO(person);

    }

    public List<PersonResponseDTO> toPeopleDTO(List<Person> peopleList){

        return peopleList.stream().map(PersonResponseDTO::new).collect(Collectors.toList());

    }

    public void updatePersonData(Person person, PersonRequestDTO personDTO){
        person.setName(personDTO.getName());
        person.setCpf(personDTO.getCpf());
        person.setAge(personDTO.getAge());

    }

}
