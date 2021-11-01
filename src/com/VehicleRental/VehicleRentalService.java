package com.VehicleRental;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class VehicleRentalService {
    ArrayList <Branch> branches;
    int numberOfBranches = 0;

    private void addBranch(){
        numberOfBranches += 1;
        Branch branch = new Branch(numberOfBranches);
        branches.add(branch);
    }

    public void cliInterface() throws IOException {
        int currentBranch = -1;
        State state = State.start;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int option = 0,from,to;
        float price = 0.0F;
        while(true){
            switch (state){
                case start : {
                    System.out.println("1.Add branch \n2.Choose branch \n");
                    option = Integer.parseInt(reader.readLine());
                    switch (option){
                        case 1 : state = State.addBranch;
                        case 2 : state = State.chooseBranch;
                    }
                }
                case addBranch : {
                    addBranch();
                    System.out.println("New branch added\n");
                    state = State.start;
                }
                case chooseBranch : {
                    System.out.println("Choose a branch from: \n");
                    for(int i=1;i<=numberOfBranches;i++){
                        System.out.print(i + " ");
                    }
                    System.out.print("\n");
                    option = Integer.parseInt(reader.readLine());
                    currentBranch = option;
                    state = State.insideBranch;
                }
                case insideBranch : {
                    System.out.println("1.Add Vehicle \n2.Book Vehicle \nDrop Vehicle \n");
                    option = Integer.parseInt(reader.readLine());
                    switch (option){
                        case 1 : state = State.addVehicle;
                        case 2 : state = State.bookVehicle;
                        case 3 : state = State.dropVehicle;
                    }
                }
                case addVehicle : {
                    System.out.println("Enter vehicle type and price\n1.Car\n2.Scooter\nBike\n");
                    option = Integer.parseInt(reader.readLine());
                    price = Float.parseFloat(reader.readLine());
                    Branch branch = branches.get(currentBranch);
                    switch (option){
                        case 1 : branch.addVehicle(VehicleType.car,price);
                        case 2 : branch.addVehicle(VehicleType.scooter,price);
                        case 3 : branch.addVehicle(VehicleType.bike,price);
                    }
                    state = State.start;
                }
                case bookVehicle : {
                    System.out.println("Choose a vehicle from list and enter vehicle number from time and to time\n");
                    Branch branch = branches.get(currentBranch);
                    branch.showVehicleList();
                    option = Integer.parseInt(reader.readLine());
                    from = Integer.parseInt(reader.readLine());
                    to = Integer.parseInt(reader.readLine());
                    if(branch.bookVehicle(option,from,to)){
                        state = State.start;
                    }
                    else{
                        state = State.bookVehicle;
                    }
                }
                case dropVehicle : {
                    System.out.println("Enter vehicle number to drop\n");
                    Branch branch = branches.get(currentBranch);
                    option = Integer.parseInt(reader.readLine());
                    if(branch.dropVehicle(option)){
                        state = State.start;
                    }
                    else{
                        state = State.insideBranch;
                    }
                }
            }
        }
    }

}
