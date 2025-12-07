/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Business.Logistics;

import java.util.ArrayList;

/**
 *
 * @author eric
 */
public class TransportVehicleDirectory {
    private ArrayList<TransportVehicle> vehicleList;

    public TransportVehicleDirectory() {
        vehicleList = new ArrayList<>();
    }

    public ArrayList<TransportVehicle> getVehicleList() {
        return vehicleList;
    }
    
    public TransportVehicle createVehicle(String model, String licensePlate) {
        TransportVehicle vehicle = new TransportVehicle(model, licensePlate);
        vehicleList.add(vehicle);
        return vehicle;
    }
    
    public void removeVehicle(TransportVehicle vehicle) {
        vehicleList.remove(vehicle);
    }
    
    // get all Available Vehicles
    public ArrayList<TransportVehicle> getAvailableVehicles() {
        ArrayList<TransportVehicle> availableList = new ArrayList<>();
        for (TransportVehicle vehicle : vehicleList) {
            if (vehicle.isIsAvailable()) {
                availableList.add(vehicle);
            }
        }
        return availableList;
    }
    
    // find Vehicle By Id
    public TransportVehicle findVehicleById(String vehicleId) {
        for (TransportVehicle vehicle : vehicleList) {
            if (vehicle.getVehicleId().equals(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }
}
