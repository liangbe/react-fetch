package com.bee.fetch.entity;

import javax.persistence.*;
import java.util.List;
/**
 * Created by liangbe on 2017/12/13.
 */
@Entity
@Table(name="user_info")
public class User {


//    @GeneratedValue(strategy = GenerationType.AUTO,generator = "user_id_seq")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="password" ,nullable = false)
    private  String password;

    @Column(length = 30,name="name")
    private  String name;

    @Column(length = 30,name="phone_num")
    private  String phoneNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
}
