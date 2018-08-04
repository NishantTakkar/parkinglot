package com.assignment.parkinglot.entry;


import com.assignment.parkinglot.enums.ParkingSpotSize;

public class ParkingSpot {

    private Long slotNumber;

    private boolean isVacant;

    private Vehicle vehicle;

    private ParkingSpotSize parkingSpotSize;

    private final ParkingSpotSize defaultSize=ParkingSpotSize.MEDIUM;

    public ParkingSpot(Long slotNumber, ParkingSpotSize parkingSpotSize) {
        this.slotNumber = slotNumber;
        this.isVacant = true;
        this.parkingSpotSize=parkingSpotSize;
    }

    public ParkingSpot(Long slotNumber) {
        this.slotNumber = slotNumber;
        this.isVacant = true;
        this.parkingSpotSize=defaultSize;
    }



    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.isVacant = false;
        return this;
    }

    public ParkingSpot unparkVehicle(){
        this.vehicle=null;
        this.isVacant=true;
        return this;
    }


    public Long getSlotNumber() {
        return slotNumber;
    }

    public boolean isVacant() {
        return isVacant;
    }

    public String getParkingStatus(){
        return new StringBuilder().append(slotNumber).append("   ")
                .append(this.vehicle.getRegistrationNumber()).append("   ")
                .append(this.vehicle.getColor()).toString();
    }



}
