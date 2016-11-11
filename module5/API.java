package module7.module5;

import java.util.List;

public interface API {
    List<Room> findRooms(int price, int persons, String cityName, String hotelName);

    List<Room> getAll();
}
