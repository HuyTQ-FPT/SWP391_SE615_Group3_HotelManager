
package dao.impl;

import dao.ReservationDAO;
import entity.Reservation;
import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class ReservationDAOImpl extends DBContext implements ReservationDAO {

    @Override
    public int updateReservation(Reservation re) {
        int n = 0;
        String sql = "UPDATE [SWPgroup3].[dbo].[Reservation]\n"
                + "   SET [UserID] = ?\n"
                + "      ,[RoomID] = ?\n"
                + "      ,[Name] = ?\n"
                + "      ,[Email] = ?\n"
                + "      ,[Address] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[NumberOfPerson] = ?\n"
                + "      ,[Checkin] = ?\n"
                + "      ,[Checkout] = ?\n"
                + "      ,[Total] = ?\n"
                + "      ,[Status] = ?\n"
                + "      ,[Date] =?\n"
                + " WHERE BillID=?";
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, re.getUserID());
            pre.setInt(2, re.getRoomID());
            pre.setString(3, re.getName());
            pre.setString(4, re.getEmail());
            pre.setString(5, re.getAddress());
            pre.setString(6, re.getPhone());
            pre.setInt(7, re.getNumberOfPerson());
            pre.setDate(8, re.getCheckin());
            pre.setDate(9, re.getCheckout());
            pre.setDouble(10, re.getTotal());
            pre.setInt(11, re.getStatus());
            pre.setDate(12, re.getDate());
            pre.setInt(13, re.getBillID());
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public int addReservation(Reservation re) {
        String sql = "INSERT INTO [SWPgroup3].[dbo].[Reservation]\n"
                + "([UserID],[RoomID],[Name],[Email],[Address],[Phone],[NumberOfPerson],[Checkin],[Checkout],[Total],[Status],[Date]) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            //        create statement: execute sql
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, re.getUserID());
            pre.setInt(2, re.getRoomID());
            pre.setString(3, re.getName());
            pre.setString(4, re.getEmail());
            pre.setString(5, re.getAddress());
            pre.setString(6, re.getPhone());
            pre.setInt(7, re.getNumberOfPerson());
            pre.setDate(8, re.getCheckin());
            pre.setDate(9, re.getCheckout());
            pre.setDouble(10, re.getTotal());
            pre.setInt(11, re.getStatus());
            pre.setDate(12, re.getDate());
            pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
    public Vector<Reservation> Reservation(String sql) {
        Vector<Reservation> re = new Vector<Reservation>();
        try{
            //        create statement: execute sql
             ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                int UserID = rs.getInt(2);
                int RoomID = rs.getInt(3);
                String Name = rs.getString(4);
                String Email = rs.getString(5);
                String Address = rs.getString(6);
                String Phone = rs.getString(7);
                int NumberOfPerson = rs.getInt(8);
                Date checkin =rs.getDate(9);
                Date checkout =rs.getDate(10);
                double total =rs.getDouble(11);
                int Status = rs.getInt(12);
                Date dat =rs.getDate(13);
                
                Reservation im = new Reservation(UserID, RoomID, Name, Email, Address, Phone, NumberOfPerson, checkin, checkout, total, Status, dat);
                re.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re;
    }
    public static void main(String[] args) {
        ReservationDAOImpl dao= new ReservationDAOImpl();
//                Date a = Date.valueOf("2022-05-03");
//        Date b = Date.valueOf("2022-07-03");
//        Reservation re =new Reservation(4, 8, "Rose", "rs2001@gmail.com", "Hanoi", "0904652125", 4, a, b, 1600, 1,a );
//        int n= dao.addReservation(re);
        try {
            dao.sumReservation();
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int sumReservation() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
      
        try {
            String sql = "select SUM(Total) as Total from Reservation";
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                
                    return  rs.getInt("Total");

                

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return 0;
    }

    @Override
    public int removeReservation(int id) {
         int n = 0;
        String sql = "delete from Reservation where BillID=" + id;
        try {
            Statement state = conn.createStatement();
            n = state.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }
   
}
