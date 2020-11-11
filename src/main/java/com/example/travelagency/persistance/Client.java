package com.example.travelagency.persistance;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "client")
@Data
public class Client {

    //https://vladmihalcea.com/postgresql-serial-column-hibernate-identity/ -
    // miałem tu drobny problem jak pożenić id hibernate'owe z postrgresowym "serial"
    // żeby się nie "gryzły".
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "passport_number", unique = true)
    private String passportNumber;


}
