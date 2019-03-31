package sample;

public class Booking {
    private int seats, rooms, trips;

    public Booking(int seats, int rooms, int trips) {
        this.seats = seats;
        this.rooms = rooms;
        this.trips = trips;
    }

    public int removeSeats(int bookedSeats, Package lol) {
        seats = seats - bookedSeats;
        lol.flightSeats = seats;
        return  lol.flightSeats;
    }

    public int removeRoom(int bookedRoom, Package lol) {
        rooms = rooms - bookedRoom;
        lol.hotelRooms = rooms;
        return  lol.hotelRooms;
    }

    public int removeTrip(int bookedTrip, Package lol) {
        trips = trips - bookedTrip;
        lol.eventSeats = trips;
        return  lol.eventSeats;
    }
}
