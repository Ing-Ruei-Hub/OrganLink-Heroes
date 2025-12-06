package Business.Logistics;

public class TransportVehicle {

    private String vehicleId;
    private String model;
    private String licensePlate;
    private boolean isAvailable;
    private String currentStatus; // e.g., "Parked", "In Transit", "Maintenance"

    private static int counter = 0;

    public TransportVehicle(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
        this.vehicleId = "VEH" + counter++;
        this.isAvailable = true; // Default to available
        this.currentStatus = "Parked"; // Default status
    }

    // Getters and Setters
    public String getVehicleId() {
        return vehicleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return licensePlate + " (" + model + ")";
    }
}
