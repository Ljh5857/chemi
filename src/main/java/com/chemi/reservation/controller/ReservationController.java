package com.chemi.reservation.controller;


import com.chemi.reservation.service.ReservationService;
import com.chemi.reservation.vo.ReservationVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<ReservationVo> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/get")
    public ReservationVo getReservationById(@RequestParam int no) {
        return reservationService.getReservationById(no);
    }

    @PostMapping("/save")
    public void saveReservation(@RequestBody ReservationVo reservation) {
        reservationService.saveReservation(reservation);
    }
}