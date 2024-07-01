package com.chemi.reservation.service;

import com.chemi.reservation.dao.ReservationDao;
import com.chemi.reservation.vo.ReservationVo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationDao reservationDao;

    public ReservationService(ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }

    public List<ReservationVo> getAllReservations() {
        return reservationDao.getAllReservations();
    }

    public ReservationVo getReservationById(int no) {
        return reservationDao.getReservationById(no);
    }

    public void saveReservation(ReservationVo reservation) {
        reservationDao.saveReservation(reservation);
    }
}