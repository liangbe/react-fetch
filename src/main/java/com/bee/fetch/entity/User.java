package com.bee.fetch.entity;

import javax.persistence.*;
import java.util.List;
/**
 * Created by liangbe on 2017/12/13.
 */
@Entity
@Table(name="user_info")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "user_id_seq")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="password")
    private  String password;

    @Column(name="age")
    private int age;

    @Column(length = 30,name="name")
    private  String name;

    @Column(length = 30,name="first_name")
    private  String firstName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
