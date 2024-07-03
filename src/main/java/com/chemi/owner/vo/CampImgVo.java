package com.chemi.owner.vo;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CampImgVo {
    private String no;
    private String campsiteNo;
    private String filePath;
    private String delYn;
    private String createDate;
}
