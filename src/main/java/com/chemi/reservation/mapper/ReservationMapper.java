package com.chemi.reservation.mapper;


import com.chemi.reservation.vo.ReservationVo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ReservationMapper {

    @Select("SELECT * FROM reservation")
    List<ReservationVo> getAllReservations();

    @Select("SELECT * FROM reservation WHERE no = #{no}")
    ReservationVo getReservationById(int no);

    @Insert("INSERT INTO reservation (no, zone_no, mem_no, start_date, end_date, count) VALUES (#{no}, #{zoneNo}, #{memNo}, #{startDate}, #{endDate}, #{count})")
    void saveReservation(ReservationVo reservation);
}