package dao;

import entity.Reservation;
import java.sql.Date;
import java.util.Vector;

public interface ReservationDAO {

    public int updateReservation(Reservation re);

    public int addReservation(Reservation re);

    public Vector<Reservation> Reservation(String sql);

    public int sumReservation() throws Exception;

    public Vector<Reservation> totalOfRoomSearch(String name, Date from, Date to) throws Exception;
    public Vector<Reservation> totalOfRoom() throws Exception;
    public Vector<Reservation> totalOfRoomByMonth(Integer month, Integer year) throws Exception;
    public Vector<Reservation> selectAllYear() throws Exception;
}
