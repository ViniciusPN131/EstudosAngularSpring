package com.vinic.person.dto.response;

import com.vinic.person.entidade.Person;

public class PersonResponseDTO {

    private Long id;

    private String name;

    private String cpf;

    private String age;

    public PersonResponseDTO(Person person){

        this.id = person.getId();
        this.name = person.getName();
        this.cpf = person.getCpf();
        this.age = person.getAge();

    }

}
