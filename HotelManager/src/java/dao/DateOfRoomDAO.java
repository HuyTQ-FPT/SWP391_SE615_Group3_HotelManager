
package dao;

import entity.DateOfRoom;
import entity.Reservation;

public interface DateOfRoomDAO {
    public int updateReservation(DateOfRoom date);
    public int addReservation(DateOfRoom date);
}
