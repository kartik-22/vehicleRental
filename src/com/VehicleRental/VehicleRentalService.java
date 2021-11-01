package com.VehicleRental;

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

    public void cliInterface(){
        int currentBranch = -1;
        State state = State.start;
//        Scanner input = new Scanner(System.in);
//        int inputCase = -1;
//        while(true){
//            switch (state){
//                case start -> {
//                    System.out.println("1.Add branch \n 2.Choose branch \n");
//
//                }
//            }
//        }
    }

}
