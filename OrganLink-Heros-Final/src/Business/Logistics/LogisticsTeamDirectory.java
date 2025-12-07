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
public class LogisticsTeamDirectory {
    private ArrayList<LogisticsTeam> teamList;

    public LogisticsTeamDirectory() {
        teamList = new ArrayList<>();
    }

    public ArrayList<LogisticsTeam> getTeamList() {
        return teamList;
    }
    
    public LogisticsTeam createTeam(String teamName) {
        LogisticsTeam team = new LogisticsTeam(teamName);
        teamList.add(team);
        return team;
    }
    
    public void removeTeam(LogisticsTeam team) {
        teamList.remove(team);
    }
    
    // get all Available Teams
    public ArrayList<LogisticsTeam> getAvailableTeams() {
        ArrayList<LogisticsTeam> availableList = new ArrayList<>();
        for (LogisticsTeam team : teamList) {
            if (team.isIsAvailable()) {
                availableList.add(team);
            }
        }
        return availableList;
    }
    
    // find Team By Id
    public LogisticsTeam findTeamById(String teamId) {
        for (LogisticsTeam team : teamList) {
            if (team.getTeamId().equals(teamId)) {
                return team;
            }
        }
        return null;
    }
}
