package com.example.testlogin.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Entity
@Builder
@Table(name = "`test_user`")
public class User {

    @Id
    @Column(name = "`id`")
    private Integer id;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

}
