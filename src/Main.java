import java.util.Collections;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Pot pot = new Pot();

        Team team1 = new Team("Gremio", "Brazil");
        Team team2 = new Team("Velez Sarsfield", "Argentina");
        Team team3 = new Team("U.Catolica", "Chile");
        Team team4 = new Team("Botafogo", "Brazil");
        Team team5 = new Team("America Cali", "Colombia");
        Team team6 = new Team("Nacional", "Uruguay");
        Team team7 = new Team("Boca Jrs", "Argentina");
        Team team8 = new Team("Colo-Colo", "Chile");
        Team team9 = new Team("Olimpia", "Paraguay");
        Team team10 = new Team("Alianza Lima", "Peru");
        Team team11 = new Team("Palmeiras", "Brazil");
        Team team12 = new Team("River Plate", "Argentina");
        Team team13 = new Team("Atletico Nacional", "Colombia");
        Team team14 = new Team("Bolivar", "Bolivia");
        Team team15 = new Team("Libertad", "Paraguay");
        Team team16 = new Team("Flamengo", "Brazil");

        pot.addTeam(team1);
        pot.addTeam(team2);
        pot.addTeam(team3);
        pot.addTeam(team4);
        pot.addTeam(team5);
        pot.addTeam(team6);
        pot.addTeam(team7);
        pot.addTeam(team8);
        pot.addTeam(team9);
        pot.addTeam(team10);
        pot.addTeam(team11);
        pot.addTeam(team12);
        pot.addTeam(team13);
        pot.addTeam(team14);
        pot.addTeam(team15);
        pot.addTeam(team16);

        Collections.shuffle(pot.getTeams());
        pot.displayPot();
        System.out.println();


       for(int i = 0; i < pot.getTeams().size(); i += 2){
           System.out.println(pot.getTeams().get(i) + " vs " + pot.getTeams().get(i + 1));

       }
       System.out.println();

       Random rand = new Random();
        int i = 0;

        int[] aggScore1 = new int[pot.getTeams().size()];
        int[] aggScore2 = new int[pot.getTeams().size()];

        while(i < pot.getTeams().size())
        {
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);
            System.out.println("Home: " + pot.getTeams().get(i) + " " + goals1 + " " + pot.getTeams().get(i+1) + " " + goals2);
            aggScore1[i] = goals1;
            aggScore2[i+1] = goals2;
            i++;
            i++;
        }

        System.out.println();

        int j = 0;

        while(j < pot.getTeams().size())
        {
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);
            System.out.println("Away: " + pot.getTeams().get(j+1) + " " + goals2 + " " + pot.getTeams().get(j) + " " + goals1);
            aggScore1[j] += goals1;
            aggScore2[j+1] += goals2;
            j++;
            j++;
        }

        System.out.println();
        WinnersPot quarterFinals = new WinnersPot();
        System.out.println("Aggregate Scores");
        int n = 0;
        while(n < pot.getTeams().size())
        {
            System.out.println(pot.getTeams().get(n) + " " + aggScore1[n] + " " + pot.getTeams().get(n+1) + " " + aggScore2[n+1]);

            while(aggScore1[n] == aggScore2[n+1]){

                System.out.println(pot.getTeams().get(n) + " And " + pot.getTeams().get(n +1) + " Have Tied ");
                int goals1 = rand.nextInt(6);
                int goals2 = rand.nextInt(6);
                if(goals1 == goals2){
                    System.out.println("Round of penalties tied! Next Round");
                    continue;
                }

                System.out.println("Penalties Score: " + pot.getTeams().get(n) + " " + goals1 + " " + pot.getTeams().get(n+1) + " " + goals2);
                aggScore1[n] = goals1;
                aggScore2[n+1] = goals2;

            }

            if(aggScore1[n] > aggScore2[n+1]){
                //add team 1 into winners pot
                quarterFinals.addTeam(pot.getTeams().get(n));
            }
            else{
                quarterFinals.addTeam(pot.getTeams().get(n+1));
                //add  team 2 into winners pot
            }
            n++;
            n++;

        }
        System.out.println();
        System.out.println("Qualifying Teams");
        quarterFinals.displayPot2();

    }


}
