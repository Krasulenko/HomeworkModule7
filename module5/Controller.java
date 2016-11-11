package module7.module5;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private List<API> apis = new ArrayList<>();

    public Controller() {
        BookingComAPI bookingComAPI = new BookingComAPI();
        apis.add(bookingComAPI);
        GoogleAPI googleAPI = new GoogleAPI();
        apis.add(googleAPI);
        TripAdvisorAPI tripAdvisorAPI = new TripAdvisorAPI();
        apis.add(tripAdvisorAPI);
    }

    public Controller(List<API> apis) {
        this.apis = apis;
    }

    List<Room> requestRooms(int price, int persons, String city, String hotel) {
        List<Room> requestedRoms = new ArrayList<>();
        DAOImpl dao = new DAOImpl();

        for (API api : apis) {
            for (Room room : api.findRooms(price, persons, city, hotel)) {
                requestedRoms.add(room);
                dao.save(room);
            }
        }
        return requestedRoms;
    }

    List<Room> check(API api1, API api2) {

        List<Room> roomsFromApi1 = api1.getAll();
        List<Room> roomsFromApi2 = api2.getAll();

        List<Room> sameroom = new ArrayList<>();

        for (Room room1 : roomsFromApi1) {
            for (Room room2 : roomsFromApi2) {
                if (room1.equals(room2)) {
                    sameroom.add(room1);
                }
            }
        }
        return sameroom;
    }

}
