/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: TextUI — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package FlightControl.ui;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import java.util.Scanner;
import FlightControl.logic.FlightControl;

import FlightControl.domain.Flight;
import FlightControl.domain.Airplane;
import java.util.Scanner;
import FlightControl.logic.FlightControl;

public class TextUI {
    private FlightControl flightControl;
    private Scanner scanner;

    public TextUI(FlightControl flightControl, Scanner scanner) {
        this.flightControl = flightControl;
        this.scanner = scanner;
    }

    public void start() {
        startAssetControl();
        System.out.println();
        startFlightControl();
        System.out.println();
    }

    //print menu
    private void startAssetControl() {
        System.out.println("Airport Asset Control");
        System.out.println("--------------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Add an airplane");
            System.out.println("[2] Add a flight");
            System.out.println("[x] Exit Airport Asset Control");

            System.out.print("> ");
            String answer = scanner.nextLine();

            if (answer.equals("1")) {
                addAirplane();
            } else if (answer.equals("2")) {
                addFlight();
            } else if (answer.equals("x")) {
                break;
            }
        }
    }

    private void addAirplane() {
        System.out.print("Give the airplane id: ");
        String id = this.scanner.nextLine();
        System.out.print("Give the airplane capacity: ");
        //check capacity
        int capacity = 0;
        try {
            capacity = Integer.parseInt(this.scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid capacity. Using 0.");
        }

        this.flightControl.addAirplane(id, capacity);
    }

    private void addFlight() {
        System.out.print("Give the airplane id: ");
        Airplane airplane = askForAirplane(); 
        
        System.out.print("Give the departure airport id: ");
        String departureID = this.scanner.nextLine();
        
        System.out.print("Give the target airport id: ");
        String destinationID = this.scanner.nextLine();

        this.flightControl.addFlight(airplane, departureID, destinationID);
    }

    private void startFlightControl() {
        System.out.println("Flight Control");
        System.out.println("------------");
        System.out.println();

        while (true) {
            System.out.println("Choose an action:");
            System.out.println("[1] Print airplanes");
            System.out.println("[2] Print flights");
            System.out.println("[3] Print airplane details");
            System.out.println("[x] Quit");

            System.out.print("> ");
            String answer = scanner.nextLine();
            if (answer.equals("1")) {
                printAirplanes();
            } else if (answer.equals("2")) {
                printFlights();
            } else if (answer.equals("3")) {
                printAirplaneDetails();
            } else if (answer.equals("x")) {
                break;
            }
        }
    }

    private void printAirplanes() {
        for (Airplane plane : flightControl.getAirplanes()) {
            System.out.println(plane);
        }
    }

    private void printFlights() {
        for (Flight flight : flightControl.getFlights()) {
            System.out.println(flight);
        }
    }

    private void printAirplaneDetails() {
        System.out.print("Give the airplane id: ");
        // askForAirplane() handles reading input and validation
        Airplane plane = askForAirplane();
        System.out.println(plane);
    }

    private Airplane askForAirplane() {
        Airplane airplane = null;
        while (airplane == null) {
            String id = this.scanner.nextLine(); 
            airplane = flightControl.getAirplane(id);

            if (airplane == null) {
                System.out.println("No airplane with the id " + id + ".");
            }
        }

        return airplane;
    }
}
