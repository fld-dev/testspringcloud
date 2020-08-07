package com.test.testspringcloudproduct.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`sys_users`")
public class SysUser implements Serializable {

    @Id
    private Integer id;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`password`")
    private String password;

    @Column(name = "`salt`")
    private String salt;

    @Column(name = "`email`")
    private String email;

    @Column(name = "`mobile`")
    private String mobile;

    @Column(name = "`valid`")
    private Integer valid=1;

    @Column(name = "`deptid`")
    private Integer deptId;

    @Column(name = "`createdTime`")
    private Date   createdTime;

    @Column(name = "`modifiedTime`")
    private Date   modifiedTime;

    @Column(name = "`createdUser`")
    private String createdUser;

    @Column(name = "`modifiedUser`")
    private String modifiedUser;
}
