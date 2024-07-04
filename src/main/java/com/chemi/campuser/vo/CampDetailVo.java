package com.chemi.campuser.vo;


import com.chemi.owner.vo.CampingVo;
import lombok.Data;

import java.util.List;

@Data
public class CampDetailVo {

    private List<CampImgVo> campImgVoList;
    private List<CampZoneVo> campZoneVoList;
    private List<CampNoticeVo> campNoticeVoList;
    private List<RefundVo> refundVoList;
    private List<SeasonVo> seasonVoList;

}
