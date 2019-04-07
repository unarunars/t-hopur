package leit.flug;

public class ScheduledFlight {
    private String scheduledDate;
    private Passenger[] passengers;
    private boolean[][] availableSeats;
    private int rowAmount;
    private int rowLength;
    private Flight flight;

    ScheduledFlight(String scheduledDate, int rowAmount, int rowLength, Flight flight, String availableSeats) {
        this.passengers = new Passenger[rowAmount*rowLength];
        this.availableSeats = new boolean[rowAmount][rowLength];
        this.scheduledDate = scheduledDate;
        this.flight = flight;
        this.rowAmount = rowAmount;
        this.rowLength = rowLength;

        String[] seats = availableSeats.split("");
        for(int i = 0; i < seats.length; i++){
            this.availableSeats[i / rowLength][i % rowLength] = !seats[i].equals("0");
        }
    }

    void addPassenger(Passenger passenger) {
        String seat = passenger.getSeat();
        String seatNumber = seat.replaceAll("^[A-I]", "");
        String seatLetter = seat.replaceAll("^[0-9]", "");

        int seatNo = Integer.parseInt(seatNumber);
        // Convert seatLetter to number, e.g. A=0
        char seatLetterChar = seatLetter.charAt(0);
        int seatLetterNo = seatLetterChar - 'A';

        availableSeats[seatNo][seatLetterNo] = false;

        passengers[seatNo*5 + seatLetterNo] = passenger;
    }

    void removePassenger(Passenger passenger) {
        String seat = passenger.getSeat();
        String seatNumber = seat.replaceAll("^[A-I]", "");
        String seatLetter = seat.replaceAll("^[0-9]", "");

        int seatNo = Integer.parseInt(seatNumber);
        // Convert seatLetter to number, e.g. A=0
        char seatLetterChar = seatLetter.charAt(0);
        int seatLetterNo = seatLetterChar - 'A';

        availableSeats[seatNo][seatLetterNo] = true;
        passengers[seatNo*5 + seatLetterNo] = null;
    }

    int getSeatsLeft() {
        int count = 0;
        for(int i = 0; i < rowAmount; i++){
            for(int j = 0; j < rowLength; j++){
                if(availableSeats[i][j]) count++;
            }
        }

        return count;
    }

    public String getScheduledDate(){
        return scheduledDate;
    }

    public Flight getFlight() {
        return flight;
    }

}
