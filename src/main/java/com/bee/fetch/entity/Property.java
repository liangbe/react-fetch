package com.bee.fetch.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liangbe on 2018/1/5.
 */
@Entity
@Table(name="property")
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="name" ,nullable = false)
    private String name;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},
            fetch=FetchType.LAZY)
    @JoinColumn(name = "property_id")
    private List<User> userList;


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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
