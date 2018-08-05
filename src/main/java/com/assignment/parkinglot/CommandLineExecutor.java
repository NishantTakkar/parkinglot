package com.assignment.parkinglot;

import com.assignment.parkinglot.exception.ParkingException;
import com.assignment.parkinglot.manager.ParkingManager;
import com.assignment.parkinglot.manager.impl.ParkingManagerImpl;
import com.assignment.parkinglot.utils.Validator;

import java.util.List;
import java.util.stream.Collectors;

import static com.assignment.parkinglot.exception.ErrorMessage.*;
import static com.assignment.parkinglot.utils.CommandHelper.*;

public class CommandLineExecutor {

    private final static String DELIMITER = ", ";

    ParkingManager parkingManager=new ParkingManagerImpl();


    public void execute(String[] arguments) throws ParkingException {
        switch (arguments[0]) {
            case CREATE_PARKING_LOT_COMMAND:
                if (arguments.length < 2)
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<capacity>");

                try {
                    parkingManager.createParkingLot(Long.parseLong(arguments[1]));
                    System.out.println("Created a parking lot with " + arguments[1] + " slots");
                } catch (NumberFormatException e) {
                    throw new ParkingException(INVALID_CAPACITY);
                }

                break;

            case LEAVE_COMMAND:
                if (arguments.length < 2)
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<slot_number>");

                Validator.validateParkingLot(parkingManager.getParkingLot());
                try {
                    Long slotNumber = parkingManager.remove(Long.parseLong(arguments[1]));
                    System.out.println("Slot number " + arguments[1] + " is free");
                } catch (NumberFormatException e) {
                    System.out.println(INVALID_SLOT_NUMBER);
                }
                break;

            case PARK_COMMAND:
                if (arguments.length < 3)
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<registration_number> <colour>");

                Validator.validateParkingLot(parkingManager.getParkingLot());

                Long slotNumber = parkingManager.park(arguments[1], arguments[2]);
                System.out.println("Allocated slot number: " + slotNumber);
                break;

            case REG_NO_FOR_CARS_COLOR_COMMAND:
                if (arguments.length < 2)
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<colour>");

                Validator.validateParkingLot(parkingManager.getParkingLot());

                List<String> registrationNumbers = parkingManager.getRegistrationNumbers(arguments[1]);
                System.out.println(String.join(DELIMITER, registrationNumbers));
                break;

            case SLOT_NUMBER_FOR_CAR_COLOR_COMMAND:
                if (arguments.length < 2)
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<colour>");

                Validator.validateParkingLot(parkingManager.getParkingLot());

                List<Long> colours = parkingManager.getSlotNumbers(arguments[1]);
                System.out.println(colours.stream()
                        .map(colour -> String.valueOf(colour))
                        .collect(Collectors.joining(DELIMITER)));
                break;

            case SLOT_NUMBER_FOR_CAR_REG_NO_COMMAND:
                if (arguments.length < 2) {
                    throw new ParkingException(INVALID_COMMAND_FORMAT, arguments[0], "<colour>");
                }
                System.out.println(parkingManager.getSlotNumber(arguments[1]));
                break;

            case STATUS_COMMAND:
                Validator.validateParkingLot(parkingManager.getParkingLot());
                parkingManager.getParkingLot().getOccupiedParkingSpots().values()
                        .forEach(parkingSpot -> System.out.println(parkingSpot.getParkingStatus()));
                break;


        }
    }

}
