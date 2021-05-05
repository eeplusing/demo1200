package com.eplusing.demo.db.mybatis;

import java.util.Date;

public class User2 {
    Integer id;
    String name;
    String phone;
    Integer age;
    Date createTime;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

}
