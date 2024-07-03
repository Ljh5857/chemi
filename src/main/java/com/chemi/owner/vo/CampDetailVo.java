package com.chemi.owner.vo;

import lombok.Data;

import java.util.List;

@Data
public class CampDetailVo {

    private CampingVo campingVo;
    private List<CampImgVo> campImgVoList;
}
