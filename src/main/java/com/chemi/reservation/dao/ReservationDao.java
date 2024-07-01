package com.chemi.reservation.dao;


import com.chemi.reservation.mapper.ReservationMapper;
import com.chemi.reservation.vo.ReservationVo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReservationDao {

    private final ReservationMapper reservationMapper;

    public ReservationDao(ReservationMapper reservationMapper) {
        this.reservationMapper = reservationMapper;
    }

    public List<ReservationVo> getAllReservations() {
        return reservationMapper.getAllReservations();
    }

    public ReservationVo getReservationById(int no) {
        return reservationMapper.getReservationById(no);
    }

    public void saveReservation(ReservationVo reservation) {
        reservationMapper.saveReservation(reservation);
    }
}