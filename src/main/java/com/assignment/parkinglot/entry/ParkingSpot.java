package com.assignment.parkinglot.entry;

import com.assignment.parking.enums.ParkingSpotSize;

public class ParkingSpot {

    private Long slotNumber;

    private boolean isVacant;

    private Vehicle vehicle;

    private ParkingSpotSize parkingSpotSize;



    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isVacant = false;
        return this;
    }


    public Long getSlotNumber() {
        return slotNumber;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public void clear(){
        this.vehicle = null;
        this.isVacant = true;
    }

}
