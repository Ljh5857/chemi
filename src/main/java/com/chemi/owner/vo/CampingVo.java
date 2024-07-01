package com.chemi.owner.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CampingVo {

    private String no;
    private String ownerNo;
    private String name;
    private String address;
    private String tel;
    private String introduction;
    private String basicInfo;
    private MultipartFile zoneLayoutImg;
    private String delYn;
    private String area;
    private String campsiteCategory;
    private String zoneImg;


}
