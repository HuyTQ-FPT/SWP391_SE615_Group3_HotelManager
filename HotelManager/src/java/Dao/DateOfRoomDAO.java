/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Entity.DateOfRoom;
import Entity.Reservation;

/**
 *
 * @author admin
 */
public interface DateOfRoomDAO {
    public int updateReservation(DateOfRoom date);
    public int addReservation(DateOfRoom date);
}
