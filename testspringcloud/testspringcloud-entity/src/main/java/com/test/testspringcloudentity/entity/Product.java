package com.test.testspringcloudentity.entity;

import lombok.Data;

@Data
public class Product {
    private String name;
    private Integer age;
    private String add;
    private String email;

    public Product(){
        this.name="ppc";
        this.age=23;
        this.add="南京秦淮区";
        this.email="null";
    }
}
