package com.assignment.parkinglot.manager.impl;

import com.assignment.parkinglot.entity.MediumSizeParkingDimension;
import com.assignment.parkinglot.entity.ParkingDimension;
import com.assignment.parkinglot.enums.ParkingSpotSize;
import com.assignment.parkinglot.manager.ParkingTypeSelectionManager;

public class ParkingTypeSelectionManagerImpl implements ParkingTypeSelectionManager {


    public ParkingDimension getParkingDimension(ParkingSpotSize parkingSpotSize){

        switch (parkingSpotSize){

            case MEDIUM:
                return new MediumSizeParkingDimension();
            case LARGE:
                //multiple Types can be implemented here;
                return null;

        }
        return null;
    }
}
