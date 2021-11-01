package com.VehicleRental;


import java.util.HashMap;
import java.util.Map;

public class Branch {
    int branchId;
    int totalNumberOfVehicles;
    int vehiclesRented;
    HashMap <Integer,Vehicle> vehicleList;
    Boolean isPriceIncreased;
    HashMap <Integer,Booking> bookings;

    Branch(int id){
        branchId = id;
        totalNumberOfVehicles = 0;
        vehiclesRented = 0;
        isPriceIncreased = false;
        vehicleList.clear();
        bookings.clear();
    }

    public void addVehicle(VehicleType type, Float price, int id){
        Vehicle vehicle = new Vehicle(type,price,id);
        vehicleList.put(id,vehicle);
        totalNumberOfVehicles += 1;
    }

    private void sortVehicleList(){
        //
    }

    public void showVehicleList(){
        sortVehicleList();
        for (Map.Entry mapElement : vehicleList.entrySet()){
            Vehicle vehicle = (Vehicle) mapElement.getValue();
            if(vehicle.isAvailable){
                System.out.print(vehicle.vehicleId + " ");
                if(isPriceIncreased){
                    System.out.print(vehicle.increasedPrice + " " );
                }
                else{
                    System.out.print(vehicle.normalPrice + " " );
                }
                for(int j=0;j<24;j++){
                    if(vehicle.availability.get(j)){
                        System.out.print(j + " ");
                    }
                }
                System.out.print("\n");
            }
        }
    }

    public Boolean bookVehicle(int id, int from, int to){
       if(!vehicleList.containsKey(id) || !vehicleList.get(id).isAvailable){
            System.out.println("Invalid vehicle id");
            return  false;
       }
       if(from<0 || from>23 || to<0 || to>23){
           System.out.println("Invalid time slot");
           return  false;
       }
       if(vehicleList.get(id).checkAvailability(from,to)){
           vehicleList.get(id).setAvailability(from,to,false);
           vehiclesRented += 1;
           Booking booking = new Booking(id,from,to);
           bookings.put(id,booking);
           changePriceDynamically();
       }
       else{
           System.out.println("vehicle not available in the selected time slot");
           return false;
       }
       return true;
    }

    public Boolean dropVehicle(int vehicleId){
        if(!bookings.containsKey(vehicleId)){
            System.out.println("Invalid vehicle id");
            return  false;
        }
        Booking booking = bookings.get(vehicleId);
        vehicleList.get(vehicleId).setAvailability(booking.from,booking.to,true);
        bookings.remove(vehicleId);
        return true;
    }

    private void changePriceDynamically(){
        if((float)(vehiclesRented/totalNumberOfVehicles) >= (Const.getPercentageHikeVehicle)/100){
            isPriceIncreased = true;
        }
        else{
            isPriceIncreased = false;
        }
    }

}
