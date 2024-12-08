package com.example.projectapp;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class Flight {
    private final StringProperty flightNumber;
    private final StringProperty destination;
    private final StringProperty time;
    private final StringProperty price;

    public Flight(String flightNumber, String destination, String time, String price) {
        this.flightNumber = new SimpleStringProperty(flightNumber);
        this.destination = new SimpleStringProperty(destination);
        this.time = new SimpleStringProperty(time);
        this.price = new SimpleStringProperty(price);
    }



    public String getFlightNumber() {
        return flightNumber.get();
    }

    public StringProperty flightNumberProperty() {
        return flightNumber;
    }

    public String getDestination() {
        return destination.get();
    }

    public StringProperty destinationProperty() {
        return destination;
    }

    public String getTime() {
        return time.get();
    }

    public StringProperty timeProperty() {
        return time;
    }

    public String getPrice() {
        return price.get();
    }

    public StringProperty priceProperty() {
        return price;
    }
}

