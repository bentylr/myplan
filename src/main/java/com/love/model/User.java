package com.love.model;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by bhagi on 10/2/2017.
 */
@Data
@Entity
@Table(name = "User")
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column
    private String passWord;
    @Column
    private String firstName;
    //private String emailId;
}
