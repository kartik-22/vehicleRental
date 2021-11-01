package com.VehicleRental;

public class Booking {
    int from;
    int to;
    int vehicleId;
    Booking(int vehicleId, int from ,int to){
        this.vehicleId = vehicleId;
        this.from = from;
        this.to = to;
    }
}
