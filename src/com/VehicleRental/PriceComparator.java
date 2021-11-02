package com.VehicleRental;

import java.util.Comparator;

public class PriceComparator implements Comparator<Vehicle> {

    @Override
    public int compare(Vehicle v1, Vehicle v2) {
        return v2.normalPrice.compareTo(v1.normalPrice);
    }
}

