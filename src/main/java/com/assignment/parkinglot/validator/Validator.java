package com.assignment.parkinglot.validator;

import com.assignment.parkinglot.entry.ParkingSpot;
import com.assignment.parkinglot.exception.ParkingException;

import java.util.Objects;

import static com.assignment.parkinglot.exception.ErrorMessage.INVALID_VEHICLE_COLOUR;
import static com.assignment.parkinglot.exception.ErrorMessage.INVALID_VEHICLE_REGISTRATION_NUMBER;
import static com.assignment.parkinglot.exception.ErrorMessage.VEHICLE_NOT_FOUND;

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

}
