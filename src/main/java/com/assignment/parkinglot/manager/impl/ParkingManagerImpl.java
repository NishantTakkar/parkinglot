package com.assignment.parkinglot.manager.impl;

import com.assignment.parkinglot.entity.ParkingLot;
import com.assignment.parkinglot.exception.ParkingException;
import com.assignment.parkinglot.manager.ParkingManager;

import java.util.List;

public class ParkingManagerImpl implements ParkingManager {

    private ParkingLot parkingLot;

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void createParkingLot(long capacity) throws ParkingException {
        this.parkingLot = new ParkingLot(capacity);
    }


    @Override
    public Long park(String registrationNumber, String color) throws ParkingException {
        return parkingLot.park(registrationNumber,color);

    }

    @Override
    public Long remove(Long slotNumber) throws ParkingException {
        return parkingLot.remove(slotNumber);
    }

    @Override
    public Long getSlotNumber(String registrationNumber) throws ParkingException {
        return parkingLot.getSlotNumber(registrationNumber);
    }

    @Override
    public List<Long> getSlotNumbers(String color) throws ParkingException {
        return parkingLot.getSlotNumbers(color);
    }

    @Override
    public List<String> getRegistrationNumbers(String color) throws ParkingException {
        return parkingLot.getRegistrationNumbers(color);
    }
}
