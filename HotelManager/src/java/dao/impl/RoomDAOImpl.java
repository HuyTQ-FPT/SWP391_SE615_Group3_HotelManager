package dao.impl;

import dao.RoomDAO;
import entity.Image;
import entity.Room;
import entity.RoomByDate;
import context.DBContext;
import entity.Device;
import entity.RoomCategory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;

public class RoomDAOImpl extends DBContext implements RoomDAO {

    @Override
    public Vector<Room> getRoomList(String sql) {
        Vector<Room> vector = new Vector<Room>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(14);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(19);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Vector<Room> getRoomList1(String sql) {
        Vector<Room> vector = new Vector<Room>();
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(17);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                int Status = rs.getInt(12);
                String cateroom = rs.getString(14);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom, Status);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    public Room getRoom1(String sql) {
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                int Status = rs.getInt(12);
                String cateroom = rs.getString(14);
                return new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom, Status);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Room getRoom(String roomid) {
        String query = "select * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                + "                     JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                + "                   where RoomID = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, roomid);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(14), rs.getDouble(6), rs.getInt(7), rs.getFloat(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(19));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Room getRooms(String cateroom) {
        String query = "select * from Room join CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                + "where Room.RoomcateID =?";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, cateroom);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(11), rs.getDouble(6), rs.getInt(7), rs.getFloat(8), rs.getString(9), rs.getInt(10), rs.getString(11), rs.getString(14));
            }
        } catch (Exception e) {
        }
        return null;
    }

//    @Override
//    public void insertRoom(String Roomname, String Roomdes, String RoomImageid, String roomPrice, String Number) {
////        String query = "INSERT INTO [dbo].[Room]\n"
////                + "           ([Roomname]\n"
////                + "           ,[Roomdesc]\n"
////                + "           ,[RoomcateID]\n"
////                + "           ,[RoomimgaeID]\n"
////                + "           ,[Roomprice]\n"
////                + "           ,[NumberPerson]\n"
////                + "           ,[Square]\n"
////                + "           ,[Comment]\n"
////                + "           ,[Rate]\n"
////                + "           ,[Note]\n"
////                + "           ,[Status])\n"
////                + "     VALUES\n"
////                + "           (?,?,?,?,?,?,?,?,?,?,?)";
////        try {
////            PreparedStatement pre = conn.prepareStatement(query);
////            pre.setString(1, name);
////            pre.setString(2, price);
////            pre.setString(3, status);
////            pre.setString(4, RoomcateID);
////            pre.setString(5, Quantity);
////            pre.execute();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
//    }
    @Override
    public void updateRoom(Room Room) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteRoom(int roomid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPage() {
        int n = 0;
        String sql = "select COUNT(*) from Room where Status=0";
        Vector<Room> vector = new Vector<Room>();
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
    public int getPage(String sql) {
        int n = 0;
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
    public Vector<Room> getRoomByPage(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public int getPageByPageStatus() {
        int n = 0;
        String sql = "select COUNT(*) from Room where status=0";
        Vector<Room> vector = new Vector<Room>();
        try {
            int totalPage = 0;
            int countPage = 0;
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet rs = getData(sql);
            while (rs.next()) {
                totalPage = rs.getInt(1);
                countPage = totalPage / 3;
                if (totalPage % 3 != 0) {
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
    public Vector<Room> getRoomByPageStatus(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 3;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 3;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomListbyPrice(int n, int from, int to) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 3;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomID) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0\n"
                + " and r.Roomprice between " + from + " and " + to + "\n"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public int getPageByPrice(int p1, int p2) {
        int n = 0;
        String sql = "select COUNT(*) from Room Where Roomprice between " + p1 + " and " + p2 + "";
        Vector<Room> vector = new Vector<Room>();
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
    public Vector<Room> getRoomByPriceMax(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomPrice DESC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomByPriceMin(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.RoomPrice ASC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<Room> getRoomByRate(int n) {
        Vector<Room> vector = new Vector<Room>();
        int begin = 1;
        int end = 6;
        for (int i = 2; i <= n; i++) {
            begin += 6;
            end += 6;
        }
        String sql = "with t as(SELECT r.RoomID,r.Roomname,r.Roomdesc, r.RoomcateID,i.image1,r.Roomprice,r.NumberPerson,r.[Square],r.Comment,r.Rate,r.Note,c.Catename,ROW_NUMBER() OVER (order by r.Rate DESC) \n"
                + "AS RowNum FROM Room r INNER JOIN [Image] i on i.RoomimgaeID= r.RoomimgaeID \n"
                + "          JOIN CateRoom c on r.RoomcateID = c.RoomcateID\n"
                + "where r.Status=0"
                + ")\n"
                + "select * from t Where RowNum between " + begin + " AND " + end;
        try {
            ResultSet rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom);
                vector.add(im);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return vector;
    }

    @Override
    public Vector<RoomByDate> seachRoom(String a, String datein, String dateout) throws Exception {

        PreparedStatement pre = null;
        ResultSet rs = null;
        SimpleDateFormat format = new SimpleDateFormat("E MMM dd yyyy");
        Vector<RoomByDate> vector = new Vector<RoomByDate>();
        String sql = "select * from Room r  \n"
                + "inner join Image i on i.RoomimgaeID=r.RoomimgaeID join CateRoom c on \n"
                + "r.RoomcateID =c.RoomcateID \n"
                + "left join DateOfRoom d \n"
                + "on r.RoomID=d.RoomID \n";
        if (datein != null && dateout != null && datein != "" && dateout != "") {
            java.util.Date date1 = (java.util.Date) format.parse(datein);
            java.sql.Date sDate = new java.sql.Date(date1.getTime());
            java.util.Date date2 = (java.util.Date) format.parse(dateout);
            java.sql.Date cDate = new java.sql.Date(date2.getTime());

            sql += "where((d.DateOut < " + sDate + " or d.DateIn> " + cDate + ") or (d.DateIn is null and d.DateOut is null))\n";
        }
        if (a != null && a != "") {
            sql += "and r.NumberPerson= " + a;
        }
        try {
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(14);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                String cateroom = rs.getString(19);
//                Date date1 = rs.getDate(23);
//                Date date2 = rs.getDate(24);
                RoomByDate im = new RoomByDate(cateid, name, Comment, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, cateroom, null, null);
                vector.add(im);
            }
        } catch (SQLException ex) {
            throw ex;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);

        }
        return vector;
    }

    @Override
    public ArrayList<Room> getRoomListAll(String sql) throws Exception {

        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Room> vector = new ArrayList<Room>();
        try {
            rs = getData(sql);
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                int status = rs.getInt(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, status);
                vector.add(im);
            }
        } catch (SQLException ex) {
            throw ex;

        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);

        }

        return vector;

    }

    @Override
    public void updateStatus(int rID, int rStatus) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "UPDATE [SWPgroup3].[dbo].[Room]\n"
                + "   SET [Status] = ?\n"
                + " WHERE [RoomID]=?";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            pre.setInt(1, rStatus);
            pre.setInt(2, rID);

            pre.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
    }

    public ArrayList<Room> selectRoom(String rName, int status) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        ArrayList<Room> vector = new ArrayList<Room>();
        String sql = "select * from [Room] where Roomname like N'%" + rName + "%'";
        if (status >= 0) {
            sql = sql.concat(" and [status]=" + status);
        }

        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);

                int status1 = rs.getInt(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, rs.getInt("status"));

                vector.add(im);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }

    @Override
    public Image searchRoomidAndImage(int RoomID) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "select i.image1,i.image2,i.image3,i.image4 from [Image] i inner join [Room] r on i.RoomimgaeID = r.RoomimgaeID\n"
                + "where r.RoomID=" + RoomID;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return new Image(rs.getString("image1"), rs.getString("image2"), rs.getString("image3"), rs.getString("image4"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return null;
    }

    @Override
    public ArrayList<Room> searchRoomNamebyAjax(String roomName, int cateID) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Room> vector = new ArrayList<>();
        String sql = "select * from Room where Roomname like '%" + roomName + "%' and  RoomcateID=" + cateID;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String des = rs.getString(3);
                int cateid = rs.getInt(4);
                String image = rs.getString(5);
                double Roomprice = rs.getDouble(6);
                int NumberPerson = rs.getInt(7);
                float Square = rs.getFloat(8);
                String Comment = rs.getString(9);
                int Rate = rs.getInt(10);
                String Note = rs.getString(11);
                int status1 = rs.getInt(12);
                Room im = new Room(id, name, des, cateid, image, Roomprice, NumberPerson, Square, Comment, Rate, Note, status1);

                vector.add(im);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }

    @Override
    public Room getOneRoom(int roomid) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        String sql = "select * from Room INNER JOIN Image on Image.RoomimgaeID= Room.RoomimgaeID \n"
                + "  JOIN CateRoom on Room.RoomcateID = CateRoom.RoomcateID\n"
                + "    where RoomID = " + roomid;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new Room(rs.getInt("RoomId"), rs.getString("Roomname"), rs.getString("Roomdesc"), rs.getInt("RoomcateID"), rs.getDouble("Roomprice"), rs.getInt("NumberPerson"), rs.getFloat("Square"), rs.getString("Comment"), rs.getInt("Rate"), rs.getString("Note"), rs.getInt("status"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return null;
    }

    @Override
    public ArrayList< RoomCategory> numberOfRoomsByCategory() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList< RoomCategory> vector = new ArrayList<>();

        String sql = "select c.RoomcateID,c.Catename ,COUNT(r.RoomcateID) as count from CateRoom c inner join Room r on c.RoomcateID = r.RoomcateID \n"
                + "group by c.RoomcateID,c.Catename";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {

                vector.add(new RoomCategory(rs.getInt("RoomcateID"), rs.getString("Catename"), rs.getInt("count")));

            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }

    @Override
    public ArrayList<Room> sumOfRoom() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList< Room> vector = new ArrayList<>();

        String sql = "select Room.[Status],COUNT(Room.[Status]) as Sumstatus from Room \n"
                + "group by  Room.[Status]";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                vector.add(new Room(rs.getInt("Status"), rs.getInt("Sumstatus")));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }

    @Override
    public ArrayList<Device> numberOfDevice() throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<Device> vector = new ArrayList<>();

        String sql = "select d.DeviceName , SUM(r.Quantity) as Quantity from  RoomDevice r INNER JOIN Device d on \n"
                + "                r.DeviceID = d.DeviceID\n"
                + "                group by d.DeviceName";
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                vector.add(new Device(rs.getString("DeviceName"), rs.getInt("Quantity")));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return vector;
    }

    @Override
    public RoomCategory getRoomCate(int cateID) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;
        ArrayList<RoomCategory> vector = new ArrayList<>();

        String sql = "select c.* from Room r inner join CateRoom c on r.RoomcateID = c.RoomcateID where r.RoomcateID=" + cateID;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            while (rs.next()) {
                return new RoomCategory(rs.getInt("RoomcateID"), rs.getString("Catename"));
            }
        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);

        }
        return null;
    }

    @Override
    public void crudRoom(String sql) {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.executeUpdate();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void crudImage(String string) {
        try {
            PreparedStatement pre = conn.prepareStatement(string);
            pre.execute();
            System.out.println("done");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Room checkRoom(int roomName) throws Exception {
        Connection conn = null;
        PreparedStatement pre = null;
        ResultSet rs = null;

        String sql = "select * from Room where Roomname =" + roomName;
        try {
            conn = getConnection();
            pre = conn.prepareStatement(sql);
            rs = pre.executeQuery();
            if (rs.next()) {
                return new Room(rs.getInt("RoomId"), rs.getString("Roomname"), rs.getString("Roomdesc"), rs.getInt("RoomcateID"), rs.getDouble("Roomprice"), rs.getInt("NumberPerson"), rs.getFloat("Square"), rs.getString("Comment"), rs.getInt("Rate"), rs.getString("Note"), rs.getInt("status"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            closeResultSet(rs);
            closePreparedStatement(pre);
            closeConnection(conn);
        }
        return null;
    }

}
