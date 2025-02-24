import java.util.ArrayList;
import java.util.List;

//Pot will hold 16 teams
public class Pot {
    private ArrayList<Team> teams;

    public Pot(){
        teams = new ArrayList<>();
    }
    public void addTeam(Team team){
        teams.add(team);
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void displayPot(){
        for(Team team: teams){
            System.out.println("Team: " + team.getName() + ", " + team.getCountry());
        }
    }
}
