package Business.Logistics;

import Business.Employee.Employee; // Assuming employees are part of teams
import java.util.ArrayList;
import java.util.List;

public class LogisticsTeam {

    private String teamId;
    private String teamName;
    private List<Employee> teamMembers;
    private boolean isAvailable;
    private String currentAssignment; // e.g., "Organ Transport #XYZ"

    private static int counter = 0;

    public LogisticsTeam(String teamName) {
        this.teamName = teamName;
        this.teamId = "TEAM" + counter++;
        this.teamMembers = new ArrayList<>();
        this.isAvailable = true; // Default to available
        this.currentAssignment = "None";
    }

    // Getters and Setters
    public String getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public List<Employee> getTeamMembers() {
        return teamMembers;
    }

    public void addTeamMember(Employee employee) {
        this.teamMembers.add(employee);
    }

    public void removeTeamMember(Employee employee) {
        this.teamMembers.remove(employee);
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCurrentAssignment() {
        return currentAssignment;
    }

    public void setCurrentAssignment(String currentAssignment) {
        this.currentAssignment = currentAssignment;
    }

    @Override
    public String toString() {
        return teamName + " (" + teamId + ")";
    }
}
