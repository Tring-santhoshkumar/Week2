
import java.util.Scanner;

class Room {

    private int roomNumber;
    private String type;
    private int price;
    private boolean booked;

    Room(int currRoomNumber, String currType, int currPrice) {
        this.roomNumber = currRoomNumber;
        this.type = currType;
        this.price = currPrice;
        this.booked = false;
    }

    public void bookingRoom() {
        if (!booked) {
            booked = true;
            System.out.println(roomNumber + " Room has been booked Successfully!");
        } else {
            System.out.println(roomNumber + " is already booked,choose different room.");
        }
    }

    public void cancel() {
        if (booked) {
            booked = false;
            System.out.println("Room " + roomNumber + " Booking has been cancelled.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    public void display() {
        String temp = (booked == true) ? "Booked" : "Available";
        System.out.println(roomNumber + " Room Number with " + type + " type of Ru." + price + " is " + temp);
    }

    public boolean available() {
        return (!booked) ? true : false;
    }

    public int roomNo() {
        return roomNumber;
    }

    public String roomType() {
        return type;
    }

}

class Book {

    int totalRooms;
    int roomNumber;
    Room[] rooms;

    public Book(int X) {
        rooms = new Room[X];
        totalRooms = X;
        roomNumber = 0;
    }

    public void add(int roomNum, String type, int price) {
        try {
            if (roomNumber < totalRooms) {
                rooms[roomNumber++] = new Room(roomNum, type, price);
            } else {
                throw new Exception("Hotel has maximum rooms.");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());

        }
    }

    public void bookRoom(int roomNum, String type) {
        for (int i = 0; i < roomNumber; i++) {
            if (rooms[i].available() && rooms[i].roomNo() == roomNum && rooms[i].roomType().equals(type)) {
                rooms[i].bookingRoom();
                return;
            } else if (rooms[i].available() && rooms[i].roomNo() == roomNum && !rooms[i].roomType().equals(type)) {
                System.out.println("It's a " + rooms[i].roomType() + " Room,Check Availability.");
                return;
            } else if (totalRooms <= roomNum) {
                System.out.println("Invalid Room Number,Check Availability.");
                return;
            }
        }
        System.out.println("Room Booked,Check Availability.");
    }

    public void checkAvailability() {
        int flag = 0;
        for (int i = 0; i < roomNumber; i++) {
            if (rooms[i].available()) {
                rooms[i].display();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No Rooms are Available");
        }
    }

    public void cancelBooking(int roomNum) {
        for (int i = 0; i < roomNumber; i++) {
            if (!rooms[i].available() && rooms[i].roomNo() == roomNum) {
                rooms[i].cancel();
                return;
            } else if (!rooms[i].available() && !(rooms[i].roomNo() == roomNum)) {
                System.out.println("Room " + roomNum + " is not Booked.");
                return;
            }
        }
        System.out.println("No Rooms are Booked.");
    }

    public void displayHotelRooms() {
        int flag = 0;
        for (int i = 0; i < roomNumber; i++) {
            if (!rooms[i].available()) {
                rooms[i].display();
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("No Rooms are Booked.");
        }
    }

}

public class HotelBooking {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book rooms = new Book(5);
        rooms.add(1, "AC", 1000);
        rooms.add(2, "AC", 1000);
        rooms.add(3, "AC", 1000);
        rooms.add(4, "Non-AC", 500);
        rooms.add(5, "Non-AC", 500);
        System.out.println("Welcome To Hotel Booking System!!!");
        while (true) {
            System.out.println("Type\n1 - Check Availability\n2 - Book a Room\n3 - Display Booking Details\n4 - Cancel Booking\n5 - Exit");
            switch (sc.nextInt()) {
                case 1:
                    rooms.checkAvailability();
                    break;
                case 2:
                    System.out.print("Enter room No : ");
                    int roomNumber = sc.nextInt();
                    System.out.print("Enter AC or Non-AC Type of room : ");
                    String typeofRoom = sc.next();
                    rooms.bookRoom(roomNumber, typeofRoom);
                    break;
                case 3:
                    rooms.displayHotelRooms();
                    break;
                case 4:
                    System.out.print("Enter room No : ");
                    int roomNumber2 = sc.nextInt();
                    rooms.cancelBooking(roomNumber2);
                    break;
                case 5:
                    System.out.println("Thankyou for Using Hotel Booking System!");
                    return;
                default:
                    System.out.println("Enter Options : ");

            }
        }
    }
}
