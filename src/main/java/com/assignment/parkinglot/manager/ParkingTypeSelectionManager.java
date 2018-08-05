package com.assignment.parkinglot.manager;

import com.assignment.parkinglot.entry.ParkingDimension;
import com.assignment.parkinglot.enums.ParkingSpotSize;

public interface ParkingTypeSelectionManager {

    ParkingDimension getParkingDimension(ParkingSpotSize parkingSpotSize);

}
