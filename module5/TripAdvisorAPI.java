package module7.module5;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class TripAdvisorAPI implements API {

    private List<Room> rooms = new ArrayList<>();

    public TripAdvisorAPI() {
        rooms.add(new Room(123, 120, 2, new Date(2016, 9, 25), "Hilton", "Madrid"));
        rooms.add(new Room(124, 150, 2, new Date(2016, 9, 22), "Holliday Inn", "London"));
        rooms.add(new Room(125, 170, 2, new Date(2016, 9, 29), "Redisson", "Madrid"));
        rooms.add(new Room(126, 90, 1, new Date(2016, 9, 30), "Ritz", "Oslo"));
        rooms.add(new Room(127, 200, 3, new Date(2016, 10, 11), "Carlton", "Paris"));
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
