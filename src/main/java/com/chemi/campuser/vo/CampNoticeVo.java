package com.chemi.campuser.vo;

import lombok.Data;

@Data
public class CampNoticeVo {
    private String no;
    private String campsiteNo;
    private String title;
    private String content;
    private String uploadDate;
    private String delYn;
    private String modifyDate;
    private String hit;
}
