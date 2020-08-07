package com.test.testspringcloudproduct.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`sys_logs`")
public class SysLog {
    @Id
    private Integer id;

    @Column(name = "`username`")
    private String username;

    @Column(name = "`operation`")
    private String operation;

    @Column(name = "`method`")
    private String method;

    @Column(name = "`params`")
    private String params;

    @Column(name = "`time`")
    private Long time;

    @Column(name = "`ip`")
    private String ip;

    @Column(name = "`createdTime`")
    private Date createdTime;
}
