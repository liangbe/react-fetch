package com.bee.fetch.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by liangbe on 2018/1/4.
 */
@Entity
@Table(name="household")
public class Household {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="floor" ,nullable = false)
    private int floor;

    @Column(name="number" ,nullable = false)
    private int number;

    @Column(name="room_number" ,nullable = false)
    private String roomNum;

    @Column(name="area" ,nullable = false)
    private float area;

    @OneToMany(cascade={CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH},
            fetch=FetchType.LAZY)
    @JoinColumn(name = "household_id")
    private List<User> userList;

    @OneToOne(cascade= CascadeType.REFRESH,fetch=FetchType.LAZY)
    @JoinColumn(name = "house_owner_id")
    private User houseOwner;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum =roomNum;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public User getHouseOwner() {
        return houseOwner;
    }

    public void setHouseOwner(User houseOwner) {
        this.houseOwner = houseOwner;
    }
}
