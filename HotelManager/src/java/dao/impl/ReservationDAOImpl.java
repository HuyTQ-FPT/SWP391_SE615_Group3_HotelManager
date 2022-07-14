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
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        try {
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
                Date checkin = rs.getDate(9);
                Date checkout = rs.getDate(10);
                double total = rs.getDouble(11);
                int Status = rs.getInt(12);
                Date dat = rs.getDate(13);

                Reservation im = new Reservation(UserID, RoomID, Name, Email, Address, Phone, NumberOfPerson, checkin, checkout, total, Status, dat);
                re.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re;
    }

    public static void main(String[] args) {
        ReservationDAOImpl dao = new ReservationDAOImpl();
        try {
            //                Date a = Date.valueOf("2022-05-03");
//        Date b = Date.valueOf("2022-07-03");
//        Reservation re =new Reservation(4, 8, "Rose", "rs2001@gmail.com", "Hanoi", "0904652125", 4, a, b, 1600, 1,a );
//        int n= dao.addReservation(re);
            Date to = Date.valueOf("2022-05-21");
            Date from = Date.valueOf("2022-06-28");
            String a="2022-02-21";
            String b="2022-05-24";
            Vector<Reservation> v = dao.searchRoom(a, b);
            for (Reservation reservation : v) {
                System.out.println(reservation);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
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

                return rs.getInt("Total");

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return 0;
    }

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

    @Override

    public ArrayList<Reservation> totalOfRoomSearch(String name, Date to, Date from) throws Exception {

        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Reservation> ArrayList = new ArrayList<>();
        String sql = "select r.RoomID,r.Roomname,SUM(re.Total) as Total from Reservation re full outer join  Room r on re.RoomID = r.RoomID\n"
                + "where r.RoomID like '%" + name + "%' \n"
                + "group by r.RoomID,r.Roomname \n"
                + "order by r.RoomID asc";
        if (to != null && from != null) {
            sql = " select r.RoomID,r.Roomname,SUM(re.Total) as Total from Reservation re full outer join  Room r on re.RoomID = r.RoomID\n"
                    + "                  where r.RoomID like '%" + name + "%' and  re.Checkin >= '" + to + "'  and   re.Checkin <= '" + from + "'\n"
                    + "                    group by r.RoomID,r.Roomname\n"
                    + "                    order by r.RoomID asc";
        }
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {

                ArrayList.add(new Reservation(rs.getInt("RoomID"), rs.getString("Roomname"), rs.getDouble("Total")));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }

        return ArrayList;
    }

    @Override
    public ArrayList<Reservation> totalOfRoom() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Reservation> ArrayList = new ArrayList<>();
        String sql = "select r.RoomID,r.Roomname,SUM(re.Total) as Total from Reservation re full outer join  Room r on re.RoomID = r.RoomID\n"
                + "group by r.RoomID,r.Roomname\n"
                + "order by r.RoomID asc";

        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {

                ArrayList.add(new Reservation(rs.getInt("RoomID"), rs.getString("Roomname"), rs.getDouble("Total")));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }

        return ArrayList;
    }

    @Override
    public ArrayList<Reservation> totalOfRoomByMonth(Integer month, Integer year) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Reservation> ArrayList = new ArrayList<>();
        String sql = "";
        if (month == null && year == null) {

            sql = "select  MONTH(Checkin)as Status, YEAR(Checkin) as NumberOfPerson, SUM(Total) as Total  from Reservation       \n"
                    + "group by MONTH(Checkin),YEAR(Checkin)\n"
                    + "order by MONTH(Checkin),YEAR(Checkin)";
        }
        if (month != null && year != null) {
            sql = "select  MONTH(Checkin) as Status, YEAR(Checkin) as NumberOfPerson, SUM(Total) as Total  from Reservation       \n"
                    + "where MONTH(Checkin) =" + month + " and  YEAR(Checkin) = " + year + "\n"
                    + "group by MONTH(Checkin),YEAR(Checkin)\n"
                    + "order by MONTH(Checkin),YEAR(Checkin)";
        }
        if (month == null && year != null) {
            sql = "select  MONTH(Checkin)as Status, YEAR(Checkin) as NumberOfPerson, SUM(Total) as Total  from Reservation       \n"
                    + "where YEAR(Checkin) = " + year + "\n"
                    + "group by MONTH(Checkin),YEAR(Checkin)\n"
                    + "order by MONTH(Checkin),YEAR(Checkin)";
        }
        if (month != null & year == null) {
            sql = "select  MONTH(Checkin)as Status, YEAR(Checkin) as NumberOfPerson, SUM(Total) as Total  from Reservation      \n"
                    + "                    where  MONTH(Checkin)=" + month + "\n"
                    + "                   group by MONTH(Checkin),YEAR(Checkin)\n"
                    + "                   order by MONTH(Checkin),YEAR(Checkin)";
        }
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {

                ArrayList.add(new Reservation(rs.getInt("Status"), rs.getInt("NumberOfPerson"), rs.getDouble("Total")));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return ArrayList;
    }

    @Override
    public ArrayList<Reservation> selectAllYear() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Reservation> ArrayList = new ArrayList<>();
        String sql = "select  YEAR(Checkin) as Year from Reservation       \n"
                + "group by YEAR(Checkin)\n"
                + "order by YEAR(Checkin)";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {

                ArrayList.add(new Reservation(rs.getInt("Year")));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return ArrayList;
    }

    @Override
    public ArrayList<Reservation> sumService() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Reservation> ArrayList = new ArrayList<>();
        String sql = "select ServiceName, COUNT( ServiceName)as Total from [Reservation]\n"
                + "group by ServiceName";

        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();

            while (rs.next()) {
                ArrayList.add(new Reservation(rs.getString("ServiceName"), rs.getInt(2)));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }

        return ArrayList;

    }

    @Override
    public int getPage() throws Exception {
        int n = 0;
        String sql="select Count(*) from Reservation";
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 6;
                if (totalPage % 6 != 0) {
                    countPage++;
                }
                return countPage;
            }
            n = pre.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return n;
    }

    @Override
    public Vector<Reservation>getReservationByPage(int n) throws Exception {
        Vector<Reservation> vector = new Vector<Reservation>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID,ROW_NUMBER() OVER (order by re.BillID) \n"
                + "AS RowNum FROM Reservation re join Room r on r.RoomID=re.RoomID\n"
                + "          join [Image] i on r.RoomimgaeID=i.RoomimgaeID \n"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                String Roomname = rs.getString(1);
                String image1 = rs.getString(2);
                String Name = rs.getString(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                String Phone = rs.getString(6);
                int NumberOfPerson = rs.getInt(7);
                Date Checkin = rs.getDate(8);
                Date Checkout = rs.getDate(9);
                double Total = rs.getDouble(10);
                int Status = rs.getInt(11);
                Date dDate = rs.getDate(12);
                int RoomID = rs.getInt(13);
                int BillID = rs.getInt(14);
                int UserID = rs.getInt(15);
                Reservation im = new Reservation(BillID, UserID, RoomID, Roomname, image1, Name, Email, Address, Phone, NumberOfPerson, Checkin, Checkout, Total, Status, dDate);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Reservation> searchRoom(String a, String b) throws Exception {
       Vector<Reservation> vector = new Vector<Reservation>();
        
        String sql = "select r.Roomname,i.image1,re.Name,re.Email,re.[Address],re.Phone,re.NumberOfPerson,re.Checkin,re.Checkout,re.Total,re.[Status],re.[Date],re.RoomID,re.BillID,re.UserID \n"
                + "  FROM Reservation re join Room r on r.RoomID=re.RoomID\n"
                + " join [Image] i on r.RoomimgaeID=i.RoomimgaeID \n"
                + " where re.Checkout <='"+b+"'and re.Checkin >='"+a+"'" ;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                String Roomname = rs.getString(1);
                String image1 = rs.getString(2);
                String Name = rs.getString(3);
                String Email = rs.getString(4);
                String Address = rs.getString(5);
                String Phone = rs.getString(6);
                int NumberOfPerson = rs.getInt(7);
                Date Checkin = rs.getDate(8);
                Date Checkout = rs.getDate(9);
                double Total = rs.getDouble(10);
                int Status = rs.getInt(11);
                Date dDate = rs.getDate(12);
                int RoomID = rs.getInt(13);
                int BillID = rs.getInt(14);
                int UserID = rs.getInt(15);
                Reservation im = new Reservation(BillID, UserID, RoomID, Roomname, image1, Name, Email, Address, Phone, NumberOfPerson, Checkin, Checkout, Total, Status, dDate);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }
}
