package com.assignment.parkinglot.entity;

import com.assignment.parkinglot.enums.ParkingSpotSize;
import com.assignment.parkinglot.exception.ParkingException;
import com.assignment.parkinglot.utils.Validator;

import java.util.*;
import java.util.stream.Collectors;

import static com.assignment.parkinglot.exception.ErrorMessage.*;

public class ParkingLot {


    private long capacity;

    private TreeMap<Long,ParkingSpot> vacantParkingSpots=new TreeMap<>();
    private TreeMap<Long,ParkingSpot> occupiedParkingSpots=new TreeMap<>();
    private Map<String,ParkingSpot> vehicleRegNoToParkingSlotMap=new HashMap<>();

    private final ParkingSpotSize DEFAULT_PARKING_SIZE=ParkingSpotSize.MEDIUM;

    public ParkingLot(long capacity) throws ParkingException {
        this.capacity = capacity;
        this.createParkingLot();
    }

    public long getCapacity() {
        return capacity;
    }

    public TreeMap<Long, ParkingSpot> getOccupiedParkingSpots() {
        return occupiedParkingSpots;
    }

    private void createParkingLot() throws ParkingException {
        if (this.capacity <= 0l)
            throw new ParkingException(INVALID_CAPACITY, capacity);
        long slot = 1;
        while (slot <= capacity){
            vacantParkingSpots.put(slot,new ParkingSpot(slot++,DEFAULT_PARKING_SIZE));
        }

    }

    public synchronized Long park(String registrationNumber, String color) throws ParkingException {

        Validator.validateVehicleRegNumber(registrationNumber);
        Validator.validateVehicleColor(color);
        Validator.checkForAlreadyParked(vehicleRegNoToParkingSlotMap,registrationNumber);
        ParkingSpot parkingSpot = findNearestVacant();
        parkingSpot.parkVehicle(new Vehicle(registrationNumber, color));
        occupiedParkingSpots.put(parkingSpot.getSlotNumber(),parkingSpot);
        vacantParkingSpots.remove(parkingSpot.getSlotNumber());
        vehicleRegNoToParkingSlotMap.put(registrationNumber,parkingSpot);
        return parkingSpot.getSlotNumber();
    }


    public Long remove(Long slotNumber) throws ParkingException {
        ParkingSpot parkingSpot = occupiedParkingSpots.get(slotNumber);
        Validator.validateParkingSpot(parkingSpot);
        vehicleRegNoToParkingSlotMap.remove(parkingSpot.getVehicle().getRegistrationNumber());
        parkingSpot.unparkVehicle();
        occupiedParkingSpots.remove(parkingSpot.getSlotNumber());
        vacantParkingSpots.put(parkingSpot.getSlotNumber(),parkingSpot);
        return parkingSpot.getSlotNumber();
    }


    public Long getSlotNumber(String registrationNumber) throws ParkingException {
        Validator.validateVehicleRegNumber(registrationNumber);
        ParkingSpot parkingSpot = vehicleRegNoToParkingSlotMap.get(registrationNumber.toUpperCase());
        Validator.validateParkingSpot(parkingSpot);
        return parkingSpot.getSlotNumber();
    }

    public List<Long> getSlotNumbers(String color) throws ParkingException{
        Validator.validateVehicleColor(color);
        return vehicleRegNoToParkingSlotMap.values()
                .stream()
                .filter(parkingSpot -> parkingSpot.getVehicle().getColor().equalsIgnoreCase(color))
                .map(parkingSpot -> parkingSpot.getSlotNumber())
                .collect(Collectors.toList());
    }

    public List<String> getRegistrationNumbers(String color) throws ParkingException{
        Validator.validateVehicleColor(color);
        return vehicleRegNoToParkingSlotMap.values()
                .stream()
                .filter(parkingSpot -> parkingSpot.getVehicle().getColor().equalsIgnoreCase(color))
                .map(parkingSpot -> parkingSpot.getVehicle().getRegistrationNumber())
                .collect(Collectors.toList());
    }


    private ParkingSpot findNearestVacant() throws ParkingException {
        if(vacantParkingSpots.isEmpty()){
            throw new ParkingException(PARKING_SPACE_LIMIT_EXCEEDED);
        }
        ParkingSpot parkingSpot= vacantParkingSpots.firstEntry().getValue();
        return parkingSpot;
    }








}
