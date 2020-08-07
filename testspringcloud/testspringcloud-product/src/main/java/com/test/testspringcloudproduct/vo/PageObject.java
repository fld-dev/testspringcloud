package com.test.testspringcloudproduct.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageObject<T> implements Serializable {

    private List<T> records;
    /**总记录数*/
    private int     rowCount;
    /**总页数*/
    private int     pageCount;
    /**页面大小*/
    private int     pageSize=3;
    /**当前页的页码*/
    private int pageCurrent=1;
}
