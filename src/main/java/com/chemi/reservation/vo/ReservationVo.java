package com.chemi.reservation.vo;

import lombok.Data;

import java.util.Date;

@Data
public class ReservationVo {
    private int no;
    private int zoneNo;
    private int memNo;
    private Date bookDate;
    private Date startDate;
    private Date endDate;
    private int count;
}