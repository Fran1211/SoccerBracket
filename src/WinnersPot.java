import java.util.ArrayList;
import java.util.List;

public class WinnersPot {

    private ArrayList<Team> winningTeams;
    public WinnersPot(){
        winningTeams = new ArrayList<>();
    }
    public void addTeam(Team team){
        winningTeams.add(team);
    }
    public void removeTeam(Team team){
        winningTeams.remove(team);
    }
    public List<Team> getTeams() {
        return winningTeams;
    }
    public void displayPot2() {
        for (Team team : winningTeams) {
            System.out.println("Team: " + team.getName() + ", " + team.getCountry());
        }
    }

}
