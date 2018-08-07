package com.assignment.parkinglot.manager;

import com.assignment.parkinglot.entity.ParkingLot;
import com.assignment.parkinglot.exception.ParkingException;

import java.util.List;

public interface ParkingManager {

    ParkingLot getParkingLot();

    void createParkingLot(long capacity) throws ParkingException;

    Long park(String registrationNumber, String color) throws ParkingException;

    Long remove(Long slotNumber) throws ParkingException;

    Long getSlotNumber(String registrationNumber) throws ParkingException;

    List<Long> getSlotNumbers(String color) throws ParkingException;

    List<String> getRegistrationNumbers(String color) throws ParkingException;

}
