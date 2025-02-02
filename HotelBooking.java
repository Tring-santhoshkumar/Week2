
import java.util.Scanner;

class Room {

    private int roomNumber;                                                       //Room class have all the required attributes
    private String type;
    private int price;
    private boolean booked;

    Room(int currRoomNumber, String currType, int currPrice) {                    //Constructor used for initializing(Encapsulation)
        this.roomNumber = currRoomNumber;
        this.type = currType;
        this.price = currPrice;
        this.booked = false;
    }

    public void bookingRoom() {                                                    //Method for checking room available or not
        if (!booked) {
            booked = true;
            System.out.println(roomNumber + " Room has been booked Successfully!");
        } else {
            System.out.println(roomNumber + " is already booked,choose different room.");
        }
    }

    public void cancel() {
        if (booked) {
            booked = false;                                                         //Method for cancelling the booked rooms
            System.out.println("Room " + roomNumber + " Booking has been cancelled.");
        } else {
            System.out.println("Room " + roomNumber + " is not booked.");
        }
    }

    public void display() {                                                         //Method to display all the details
        String temp = (booked == true) ? "Booked" : "Available";
        System.out.println(roomNumber + " Room Number with " + type + " type of Ru." + price + " is " + temp);
    }

    public boolean available() {                                                    //Check availability
        return (!booked) ? true : false;
    }

    public int roomNo() {
        return roomNumber;                                                          //getter for private attributes
    }                                                                                               //encapsulation

    public String roomType() {
        return type;                                                               //getter for private attributes
    }

}

class Book {

    int totalRooms;                                                     //Class Book for all the essential operations
    int roomNumber;
    Room[] rooms;                                                       //Declaring array of objects(Room)
    int roomBooked = 0;

    public Book(int X) {
        rooms = new Room[X];                                            //Initializing the array with size
        totalRooms = X;
        roomNumber = 0;
    }

    public void add(int roomNum, String type, int price) {              //Method for adding rooms
        try {
            if (roomNumber < totalRooms) {
                rooms[roomNumber++] = new Room(roomNum, type, price);
            } else {
                throw new Exception("Hotel has rooms to be added.Give Minimum Size of Rooms to be added.");    //Exception handling
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void bookRoom(int roomNum) {                    //Method for booking rooms
        for (int i = 0; i < roomNumber; i++) {
            if (rooms[i].available() && rooms[i].roomNo() == roomNum) {
                rooms[i].bookingRoom();
                roomBooked++;
                return;
            } else if (totalRooms < roomNum || roomNum > roomNumber) {
                System.out.println("Invalid Room Number,Check Availability.");
                return;
            }
        }
        System.out.println("Room Booked,Check Availability.");
    }

    public void checkAvailability() {                                 //Method for checking Availability
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

    public void cancelBooking(int roomNum) {                        //Method for Cancel Booking 
        for (int i = 0; i < roomNumber; i++) {
            if (rooms[i].roomNo() == roomNum) {
                if (!rooms[i].available()) {
                    rooms[i].cancel();
                    roomBooked--;
                    return;
                } else {
                    System.out.println("Room " + roomNum + " is not Booked...");
                    return;
                }
            }
        }
        try {
            if (roomNum > roomNumber) {
                throw new Exception("No such Room is present.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayHotelRooms() {                               //Method for displaying the booked rooms
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

enum ChooseOption {                                         //Using enum instead of Switch case
    checkAvailabilityOption(1) {
        void action(Scanner sc, Book rooms) {                           //User Choices
            rooms.checkAvailability();
        }
    },
    bookRoomOption(2) {
        void action(Scanner sc, Book rooms) {
            System.out.print("Enter room No 1 to 3 for AC and 4 to 5 for Non-Ac : ");
            int roomNumber = sc.nextInt();
            rooms.bookRoom(roomNumber);
        }
    },
    displayBookingDetailsOption(3) {
        void action(Scanner sc, Book rooms) {
            rooms.displayHotelRooms();
        }
    },
    cancelBookingOption(4) {
        void action(Scanner sc, Book rooms) {
            if (rooms.roomBooked == 0) {
                System.out.println("No Rooms are Booked,Please first Book Room.");
            } else {
                System.out.print("Enter room No : ");
                int roomNumber2 = sc.nextInt();
                rooms.cancelBooking(roomNumber2);
            }
        }
    },
    exitOption(5) {
        void action(Scanner sc, Book rooms) {
            System.out.println("Thankyou for Using Hotel Booking System!");
            System.exit(0);
        }
    };
    public int option;

    ChooseOption(int val) {
        this.option = val;
    }

    public static ChooseOption choice(int choiceOfUser) {
        for (ChooseOption i : values()) {
            if (i.option == choiceOfUser) {
                return i;
            }
        }
        throw new IllegalArgumentException("Invalid Options,Please Choose valid options!!!");
    }

    abstract void action(Scanner sc, Book rooms);                    //abstract method
}

public class HotelBooking {                                          //Main class 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Give Total rooms to be added : ");
        int totalSize = sc.nextInt();
        Book rooms = new Book(totalSize);
        rooms.add(1, "AC", 1000);
        rooms.add(2, "AC", 1000);
        rooms.add(3, "AC", 1000);                //Adding rooms to hotel
        rooms.add(4, "Non-AC", 500);
        rooms.add(5, "Non-AC", 500);
        System.out.println("Welcome To Hotel Booking System!!!");
        while (true) {
            System.out.println("Type\n1 - Check Availability\n2 - Book a Room\n3 - Display Booking Details\n4 - Cancel Booking\n5 - Exit");
            try {
                int option = sc.nextInt();
                
                ChooseOption select = ChooseOption.choice(option);
                select.action(sc, rooms);                                    //Exception Handling
            } catch (Exception e) {
                System.out.println("Invalid Options,Please Choose valid options!");
            }
        }
    }
}
