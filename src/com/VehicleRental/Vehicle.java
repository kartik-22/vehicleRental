package com.VehicleRental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Vehicle {
    int vehicleId;
    VehicleType type;
    Float normalPrice;
    Float increasedPrice;
    Boolean isAvailable;
    ArrayList<Boolean> availability = new ArrayList<Boolean>(Arrays.asList(new Boolean[24]));


    Vehicle(VehicleType type, Float price, int id){
        this.type = type;
        vehicleId = id;
        normalPrice = price;
        increasedPrice = (normalPrice * (100+Const.percentageHikePrice))/100;
        isAvailable = true;
        Collections.fill(availability, Boolean.TRUE);
    }

    public void setAvailability(int from,int to, Boolean isFree){
        for(int i=from;i<=to;i++){
            availability.set(i,isFree);
        }
        for(int i=0;i<24;i++){
            if(availability.get(i)){
                isAvailable = true;
                return;
            }
        }
        isAvailable = false;
    }

    public Boolean checkAvailability(int from,int to){
        for(int i=from;i<=to;i++){
            if(!availability.get(i)){
                return false;
            }
        }
        return true;
    }

}
