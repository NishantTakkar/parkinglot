package com.assignment.parkinglot.utils;

import com.assignment.parkinglot.entry.ParkingLot;
import com.assignment.parkinglot.entry.ParkingSpot;
import com.assignment.parkinglot.exception.ParkingException;

import java.util.Map;
import java.util.Objects;

import static com.assignment.parkinglot.exception.ErrorMessage.*;

public class Validator {


    public static boolean validateVehicleRegNumber(String registrationNumber) throws ParkingException {

        if (Objects.isNull(registrationNumber))
            throw new ParkingException(INVALID_VEHICLE_REGISTRATION_NUMBER, registrationNumber);
        return true;

    }

    public static boolean validateVehicleColor(String color) throws ParkingException {

        if (Objects.isNull(color))
            throw new ParkingException(INVALID_VEHICLE_COLOUR, color);
        return true;

    }

    public static boolean validateParkingSpot(ParkingSpot parkingSpot) throws ParkingException {
        if (Objects.isNull(parkingSpot))
            throw new ParkingException(VEHICLE_NOT_FOUND);

        return true;
    }

    public static boolean validateParkingLot(ParkingLot parkingLot) throws ParkingException {
        if (Objects.isNull(parkingLot))
            throw new ParkingException(PARKING_LOT_NOT_FOUND);

        return true;
    }

    public static boolean checkForAlreadyParked(Map<String,ParkingSpot> vehicleRegNoToParkingSlotMap,String registrationNumber) throws ParkingException {
        if (Objects.nonNull(vehicleRegNoToParkingSlotMap.get(registrationNumber.toUpperCase())))
            throw new ParkingException(VEHICLE_ALREADY_PARKED, registrationNumber);
        return true;
    }

}
