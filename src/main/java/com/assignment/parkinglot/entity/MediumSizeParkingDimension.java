package com.assignment.parkinglot.entity;

public class MediumSizeParkingDimension extends ParkingDimension {

    private static final Long MEDIUM_DIMENSION=10l;

    public MediumSizeParkingDimension() {
        super(MEDIUM_DIMENSION, MEDIUM_DIMENSION, MEDIUM_DIMENSION);
    }
}
