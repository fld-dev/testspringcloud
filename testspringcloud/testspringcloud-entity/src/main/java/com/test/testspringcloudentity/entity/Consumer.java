package com.test.testspringcloudentity.entity;

import lombok.Data;

@Data
public class Consumer {
    private String name;
    private Integer age;
    private String add;
    private String email;

    public Consumer(){
        this.name="fld";
        this.age=23;
        this.add="南京栖霞区";
        this.email="没有";
    }
}
