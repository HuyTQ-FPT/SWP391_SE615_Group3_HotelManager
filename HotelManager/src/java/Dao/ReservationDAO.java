/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.Reservation;

/**
 *
 * @author admin
 */
public interface ReservationDAO {
    public int updateReservation(Reservation re);
    public int addReservation(Reservation re);
}
