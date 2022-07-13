package dao;

import entity.Reservation;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Vector;

public interface ReservationDAO {

    public int updateReservation(Reservation re);

    public int addReservation(Reservation re);

    public Vector<Reservation> Reservation(String sql);
    public int removeReservation(int id);
    
    public int sumReservation() throws Exception;
    public ArrayList<Reservation> sumService() throws Exception;
    public ArrayList<Reservation> totalOfRoomSearch(String name, Date from, Date to) throws Exception;
    public ArrayList<Reservation> totalOfRoom() throws Exception;
    public ArrayList<Reservation> totalOfRoomByMonth(Integer month, Integer year) throws Exception;
    public ArrayList<Integer> selectAllYear() throws Exception;
    public ArrayList<Integer> selectAllMotnh() throws Exception;
}
