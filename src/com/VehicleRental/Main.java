package com.VehicleRental;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        //System.out.println("hello world");
        VehicleRentalService vehicleRentalService = new VehicleRentalService();
        vehicleRentalService.cliInterface();
    }
}
