
import java.util.Scanner;

import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;
import org.nocrala.tools.texttablefmt.CellStyle.HorizontalAlign;

public class Main{
    public static void main (String[]args){
        Scanner scanner = new Scanner(System.in);
        int[][] BusSeat;

        int Buses;
        int Seats;

        System.out.println(" ");
        System.out.println("------------- Setting up Bus -------------");
        System.out.println(" ");

        //User enter buses validation with loop and if else
        while (true) {
            System.out.print("-> Enter number of Buses: ");
            if (scanner.hasNextInt()) {
                Buses = scanner.nextInt();
                if (Buses >= 1 && Buses <= 100) {
                    break;
                } else {
                    System.out.println(ANSI_YELLOW + "-------------> Out of Bus Number[1 - 100] <-------------" + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "-------------> Allow number only. <-------------" + ANSI_RESET);
                scanner.next();
            }
        }

        //User enter seat validation with loop and if else
        while (true) {
            System.out.print("-> Enter number Seat of Bus: ");
            if (scanner.hasNextInt()) {
                Seats = scanner.nextInt();
                if (Seats >= 1 && Seats <= 50) {
                    break;
                } else {
                    System.out.println(ANSI_YELLOW + "-------------> Out of Bus Number[1 - 50] <-------------" + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "-------------> Allow number only. <-------------" + ANSI_RESET);
                scanner.next();
            }
        }

        int choice;;
        BusSeat = new int[Buses][Seats];
        //need to reset array before calculation
        resetBuses(BusSeat, Buses, Seats);

        //Loop for menu
        while(true){
            System.out.println(" ");
            System.out.println("--------------- Bus Managements System ---------------");
            System.out.println("1- Check Bus");
            System.out.println("2- Booking Bus");
            System.out.println("3- Cancel Booking");
            System.out.println("4- Reset Bus");
            System.out.println("5- Exit");
            System.out.println("------------------------------------------------------");

            //Validation user input option
            while (true) {
                System.out.print("-> Choose option (1-5): ");
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 5) {
                        break;
                    } else {
                        System.out.println(ANSI_YELLOW + "-------------> Choice start from [1 - 5 ] <-------------" + ANSI_RESET);
                    }
                } else {
                    System.out.println(ANSI_RED + "-------------> Allow number only. <-------------" + ANSI_RESET);
                    scanner.next();
                }
            }

            switch (choice) {
                case 1:
//                    displayAllBusInformation(BusSeat, Buses);
                    showAllBusInfo(scanner, BusSeat, Buses);
                    break;
                case 2:
                    bookingBus(scanner, BusSeat, Buses, Seats);
                    break;
                case 3:
                    cancelBooking(scanner, BusSeat, Buses, Seats);
                    break;
                case 4:
                    resetBus(scanner, BusSeat);
                    break;
                case 5:
                    System.out.println(ANSI_GREEN + "-> Good bye!" + ANSI_RESET);
                    System.exit(0);
                    break;
            }
        }

    }
    //set color code
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\033[0;33m";

    private static int userInputBusId(Scanner scanner, int buses) {
        int busId;
        //User input bus's id validation
        while (true) {
            System.out.print("-> Enter bus’s Id: ");
            if (scanner.hasNextInt()) {
                busId = scanner.nextInt();
                if (busId >= 1 && busId <= buses) {
                    break;
                } else {
                    System.out.println(ANSI_YELLOW + "-------------> Out of Bus Number[1 - " + buses + "] <-------------" + ANSI_RESET);
                }
            } else {
                System.out.println(ANSI_RED + "-------------> Allow number only. <-------------" + ANSI_RESET);
                scanner.next();
            }
        }
        return busId;
    }

    private static int userInputSeatId(Scanner scanner, int seats, String enterText){
        int seatNumber;
        //User input bus's id validation
        while(true){
            System.out.print(enterText);
            if(scanner.hasNextInt()){
                seatNumber = scanner.nextInt();
                if(seatNumber >= 1 && seatNumber <= seats){
                    break;
                }else {
                    System.out.println(ANSI_YELLOW + "-------------> Out of Chair Number[1 - "+ seats + "] <-------------" + ANSI_RESET);
                }
            } else{
                System.out.println(ANSI_RED + "-------------> Allow number only. <-------------" + ANSI_RESET);
                scanner.next();
            }
        }
        return seatNumber;
    }

    //counting Available Seats
    private static int countAvailableSeats(int[] bus) {
        int counter = 0;
        for (int seat : bus) {
            if (seat == 1) {
                counter++;
            }
        }
        return counter;
    }

    //method display all bus information table data
    private static void allBusInfoTable(int[][] buses){
        //Table Style
        CellStyle numberStyle = new CellStyle(HorizontalAlign.center);
        Table t = new Table(4, BorderStyle.UNICODE_ROUND_BOX_WIDE,
                ShownBorders.SURROUND_HEADER_AND_COLUMNS);
        System.out.println("---------- Display All Bus Information ----------");
        t.addCell("ID", numberStyle);
        t.addCell("Seat", numberStyle);
        t.addCell("Available", numberStyle);
        t.addCell("Unavailable", numberStyle);

        //Loop data in table with style
        for (int i = 0; i < buses.length; i++) {
            int availableSeats = countAvailableSeats(buses[i]);
            t.addCell(String.valueOf(i + 1), numberStyle);
            t.addCell(String.valueOf(buses[i].length), numberStyle);
            t.addCell(String.valueOf(availableSeats), numberStyle);
            t.addCell(String.valueOf(buses[i].length - availableSeats), numberStyle);
        }
        System.out.println(t.render());
    }

    //method display a bus information
    private static void showBusInfo(int[] bus) {
        System.out.println("---------- Display Bus information ----------");
        for (int i = 0; i < bus.length; i++) {
            if (i % 5 == 0) {
                System.out.println();
            }
            if (bus[i] == 1) {
                System.out.print(ANSI_GREEN + "\t" + "(+) " + ANSI_RESET );
            } else {
                System.out.print(ANSI_RED + "\t" + "(-) " + ANSI_RESET);
            }
            System.out.printf("%-2d", i + 1);
        }
        System.out.println("\n\t" + ANSI_RED +"(-) : Unavailable"+"("+ (bus.length - countAvailableSeats(bus) ) +")"+ ANSI_RESET +" "+ ANSI_GREEN +"(+) : Available(" + countAvailableSeats(bus) + ")"+ ANSI_RESET);
        System.out.println();
    }

    //method display all bus information
    private static void showAllBusInfo(Scanner scanner, int[][] buses, int Buses) {
        //call method to show all bus's information with table
        allBusInfoTable(buses);

        int busId;
        while(true){
            System.out.print("=> Enter 0 to back or Bus Id to see detail: ");
            if(scanner.hasNextInt()){
                busId = scanner.nextInt();
                if(busId >= 1 && busId <= buses.length){
                    showBusInfo(buses[busId - 1]);
                }else if(busId == 0){
                    break;
                }else {
                    System.out.println(ANSI_YELLOW + "-------------> Out of Bus Number[1 - " + Buses + "] <-------------" + ANSI_RESET);
                }
            } else{
                System.out.println(ANSI_RED + "----------------> Allow number only. <----------------" + ANSI_RESET);
                scanner.next();
            }
        }
    }

    //method for booking bus
    private static void bookingBus(Scanner scanner, int[][] buses, int Buses, int Seats) {
        System.out.println("---------- Bus Management System ----------");
        //busId to get value after check user input busId
        int busId = userInputBusId(scanner, Buses);

        //calling method to show bus information
        showBusInfo(buses[busId - 1]);

        //seatNumber to get value after check user input seat number
        int seatNumber = userInputSeatId(scanner, Seats, "-> Enter Chair number to booking: ");

        if (buses[busId - 1][seatNumber - 1] == 1) {
            char ch;
            while (true) {
                System.out.print("=> Do you want to book chair number " + seatNumber + "? (y/n): ");
                if (scanner.hasNext()) {
                    ch = scanner.next().charAt(0);
                    if (ch == 'y' || ch == 'Y') {
                        buses[busId - 1][seatNumber - 1] = 0;
                        System.out.println(ANSI_GREEN + "-> Chair number " + seatNumber + " was booked successfully!" + ANSI_RESET);
                        break;
                    } else if(ch == 'n' || ch == 'N'){
                        System.out.println(ANSI_YELLOW + "-> Booking canceled." +ANSI_RESET);
                        break;
                    }else {
                        System.out.println(ANSI_RED + "-------------> Charactor Only (y/n) or (Y/N) <-------------" + ANSI_RESET);
                    }
                }else {
                    scanner.next();
                }
            }
        } else {
            System.out.println(ANSI_RED + "-> The chair is already booked." + ANSI_RESET);
        }

    }

    //method for cancellation booking bus
    private static void cancelBooking(Scanner scanner, int[][] buses, int Buses, int Seats) {
        System.out.println("---------- Bus Management System ----------");
        int busId = userInputBusId(scanner, Buses);

        showBusInfo(buses[busId - 1]);

        int seatNumber = userInputSeatId(scanner, Seats, "-> Enter Chair number to cancel: ");;

        if (buses[busId - 1][seatNumber - 1] == 0) {

            char ch;
            while (true) {
                System.out.print("=> Do you want to cancel book chair number " + seatNumber + "? (y/n): ");
                if (scanner.hasNext()) {
                    ch = scanner.next().charAt(0);
                    if (ch == 'y' || ch == 'Y') {
                        buses[busId - 1][seatNumber - 1] = 1;
                        System.out.println(ANSI_GREEN + "-> Seat number " + seatNumber + " was canceled successfully!" + ANSI_RESET);
                        break;
                    } else if(ch == 'n' || ch == 'N'){
                        System.out.println(ANSI_YELLOW + "-> Cancellation canceled." +ANSI_RESET);
                        break;
                    }else {
                        System.out.println(ANSI_RED + "-------------> Charactor Only (y/n) or (Y/N) <-------------" + ANSI_RESET);
                    }
                }else {
                    scanner.next();
                }
            }
        } else {
            System.out.println(ANSI_YELLOW + "-> The seat is not booked." + ANSI_RESET);
        }
    }

    private static void resetABus(int[] bus) {
        for (int i = 0; i < bus.length; i++) {
            bus[i] = 1;
        }
    }

    //method to reset bus with bus's id
    private static void resetBus(Scanner scanner, int[][] buses) {
        //Input bus's ID to reset
        System.out.println("---------- Bus Management System ----------");
        System.out.print("-> Enter bus’s Id: ");
        int busId = scanner.nextInt();

        char ch;
        while (true) {
            System.out.print("=> Bus id " + busId + " was reset with all seats available? (y/n): ");
            if (scanner.hasNext()) {
                ch = scanner.next().charAt(0);
                if (ch == 'y' || ch == 'Y') {
                    resetABus(buses[busId - 1]);
                    System.out.println(ANSI_GREEN + "-> Bus id " + busId + " was reset successfully." + ANSI_RESET);
                    break;
                } else if(ch == 'n' || ch == 'N'){
                    System.out.println(ANSI_RED + "-> Reset canceled." + ANSI_RESET);
                    break;
                }else {
                    System.out.println(ANSI_RED + "-------------> Charactor Only (y/n) or (Y/N) <-------------" + ANSI_RESET);
                }
            }else {
                scanner.next();
            }
        }
    }

    //to reset the seats within each bus
    private static void resetBuses(int[][] buses, int numOfBuses, int numOfSeats) {
        for (int i = 0; i < numOfBuses; i++) {
            buses[i] = new int[numOfSeats];
            resetABus(buses[i]);
        }
    }

}



