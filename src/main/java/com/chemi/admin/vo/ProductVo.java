package com.chemi.admin.vo;

import lombok.Data;

@Data
public class ProductVo {
    private String no;
    private String categoryNo;
    private String name;
    private String price;
    private String prodExplain;
    private String stock;
    private String createDate;
    private String delYn;

}
