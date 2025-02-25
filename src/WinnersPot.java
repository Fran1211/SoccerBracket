import java.util.ArrayList;
import java.util.List;

public class WinnersPot {

    private ArrayList<Team> quarterFinals;
    public WinnersPot(){
        quarterFinals = new ArrayList<>();
    }
    public void addTeam(Team team){
        quarterFinals.add(team);
    }
    public List<Team> getTeams() {
        return quarterFinals;
    }
    public void displayPot2() {
        for (Team team : quarterFinals) {
            System.out.println("Team: " + team.getName() + ", " + team.getCountry());
        }
    }

}
