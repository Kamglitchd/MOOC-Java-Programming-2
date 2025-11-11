/*
 * ==============================================================
 *   Project: 
 *   Author: KamGlitchd
 *   Created on: Nov 10, 2025
 * 
 *   Description: FlightControl — 
 * 
 *   License: Personal / Educational Use Only
 *   (Modify and reuse freely for learning or personal work)
 * ==============================================================
 */



package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private Map<String, Place> places;

    public FlightControl() {
        this.flights = new HashMap<>();
        this.airplanes = new HashMap<>();
        this.places = new HashMap<>();
    }

    public void addAirplane(String ID, int capacity) {
        Airplane plane = new Airplane(ID, capacity);
        this.airplanes.put(ID, plane);
    }

    public void addFlight(Airplane plane, String departureID, String destinationID) {
        // checks place exists
        this.places.putIfAbsent(departureID, new Place(departureID));
        this.places.putIfAbsent(destinationID, new Place(destinationID));

        Place departurePlace = this.places.get(departureID);
        Place destinationPlace = this.places.get(destinationID);
        
        // Create new flight
        Flight flight = new Flight(plane, departurePlace, destinationPlace);
        
        
        this.flights.put(flight.toString(), flight);// Use flight's toString as the key
    }

    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }

    public Collection<Flight> getFlights() {
        return this.flights.values();
    }

    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);//airplane by ID
    }
}
