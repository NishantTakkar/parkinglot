package com.assignment.parkinglot.entity;


import com.assignment.parkinglot.enums.ParkingSpotSize;

public class Vehicle {

    private String registrationNumber;

    private String color;

    private String owner;

    private ParkingSpotSize vehicleSize;

    private final ParkingSpotSize defaultVehicleSize=ParkingSpotSize.MEDIUM;

    public Vehicle(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.vehicleSize=defaultVehicleSize;
    }

    public Vehicle(String registrationNumber, String color, String owner,ParkingSpotSize parkingSpotSize) {
        this.registrationNumber = registrationNumber;
        this.color = color;
        this.owner = owner;
        this.vehicleSize=parkingSpotSize;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    public String getOwner() {
        return owner;
    }

    public ParkingSpotSize getVehicleSize() {
        return vehicleSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle)) return false;

        Vehicle vehicle = (Vehicle) o;

        if (registrationNumber != null ? !registrationNumber.equals(vehicle.registrationNumber) : vehicle.registrationNumber != null)
            return false;
        if (color != null ? !color.equals(vehicle.color) : vehicle.color != null) return false;
        return owner != null ? owner.equals(vehicle.owner) : vehicle.owner == null;
    }

    @Override
    public int hashCode() {
        int result = registrationNumber != null ? registrationNumber.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        return result;
    }


}
