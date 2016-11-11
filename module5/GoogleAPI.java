package module7.module5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class GoogleAPI implements API {

    private List<Room> rooms = new ArrayList<>();

    public GoogleAPI() {
        rooms.add(new Room(133, 110, 2, new Date(2016, 9, 26), "Hilton", "London"));
        rooms.add(new Room(134, 130, 2, new Date(2016, 9, 23), "Holliday Inn", "Madrid"));
        rooms.add(new Room(135, 180, 2, new Date(2016, 9, 28), "Redisson", "Oslo"));
        rooms.add(new Room(136, 80, 1, new Date(2016, 9, 30), "Ritz", "Paris"));
        rooms.add(new Room(137, 210, 3, new Date(2016, 10, 10), "Carlton", "Berlin"));
    }

    @Override
    public List<Room> findRooms(int price, int persons, String cityName, String hotelName) {
        List<Room> roomsFitched = new ArrayList<>();
        int j = rooms.size();
        while (j>0){
            j--;
            if (rooms.get(j).getPrice() <= price && rooms.get(j).getPersons() >= persons && rooms.get(j).getCityName() == cityName && rooms.get(j).getHotelName() == hotelName) {
                roomsFitched.add(rooms.get(j));
            }
        }
        return roomsFitched;
    }

    @Override
    public List<Room> getAll() {
        return rooms;
    }
}
