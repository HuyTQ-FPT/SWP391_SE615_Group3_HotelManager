
package dao;

import entity.Reservation;
import java.util.Vector;

public interface ReservationDAO {
    public int updateReservation(Reservation re);
    public int addReservation(Reservation re);
    public Vector<Reservation> Reservation(String sql);
}
