/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.DateOfRoomDAO;
import entity.DateOfRoom;
import entity.Reservation;
import context.DBContext;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author admin
 */
public class DateOfRoomImpl extends DBContext implements DateOfRoomDAO {

    @Override
    public int updateReservation(DateOfRoom date) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addReservation(DateOfRoom date) {
        String sql = "INSERT INTO [SWPgroup3].[dbo].[DateOfRoom]\n"
                + "           ([RoomID],[DateIn],[DateOut],[Status])\n"
                + "     VALUES(?,?,?,?)";
        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, date.getRoomID());
            pre.setDate(2, date.getDatein());
            pre.setDate(3, date.getDateout());
            pre.setInt(4, date.getStatus());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

}
