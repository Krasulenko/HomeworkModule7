package module7.module5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class BookingComAPI implements API {

    private List<Room> rooms = new ArrayList<>();

    public BookingComAPI() {
        rooms.add(new Room(143, 120, 2, new Date(2016, 9, 26), "Hilton", "Madrid"));
        rooms.add(new Room(144, 140, 2, new Date(2016, 9, 23), "Holliday Inn", "Oslo"));
        rooms.add(new Room(145, 190, 2, new Date(2016, 9, 28), "Redisson", "Paris"));
        rooms.add(new Room(146, 70, 1, new Date(2016, 9, 30), "Ritz", "Berlin"));
        rooms.add(new Room(147, 220, 3, new Date(2016, 10, 10), "Carlton", "London"));
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
