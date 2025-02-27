import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        WinnersPot winnersPot = new WinnersPot();
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
                winnersPot.addTeam(pot.getTeams().get(n));
            }
            else{
                winnersPot.addTeam(pot.getTeams().get(n+1));
                //add  team 2 into winners pot
            }
            n++;
            n++;

        }
        System.out.println();
        System.out.println("Qualifying Teams");
        winnersPot.displayPot2();
        System.out.println();

        int a = 0;
        int[] q_aggScore1 = new int[winnersPot.getTeams().size()];
        int[] q_aggScore2 = new int[winnersPot.getTeams().size()];

        while(a < winnersPot.getTeams().size())
        {
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);
            System.out.println("Home: " + winnersPot.getTeams().get(a) + " " + goals1 + " " + winnersPot.getTeams().get(a+1) + " " + goals2);
            q_aggScore1[a] = goals1;
            q_aggScore2[a+1] = goals2;
            a++;
            a++;
        }
        System.out.println();

        int b = 0;
        while(b < winnersPot.getTeams().size())
        {
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);
            System.out.println("Away: " + winnersPot.getTeams().get(b+1) + " " + goals2 + " " + winnersPot.getTeams().get(b) + " " + goals1);
            q_aggScore1[b] += goals1;
            q_aggScore2[b+1] += goals2;
            b++;
            b++;
        }

        System.out.println();
        System.out.println("Aggregate Scores");
        int c = 0;
        while(c < winnersPot.getTeams().size())
        {
            System.out.println(winnersPot.getTeams().get(c) + " " + q_aggScore1[c] + " " + winnersPot.getTeams().get(c+1) + " " + q_aggScore2[c+1]);

            while(q_aggScore1[c] == q_aggScore2[c+1]){

                System.out.println(winnersPot.getTeams().get(c) + " And " + winnersPot.getTeams().get(c +1) + " Have Tied ");
                int goals1 = rand.nextInt(6);
                int goals2 = rand.nextInt(6);
                if(goals1 == goals2){
                    System.out.println("Round of penalties tied! Next Round");
                    continue;
                }

                System.out.println("Penalties Score: " + winnersPot.getTeams().get(c) + " " + goals1 + " " + winnersPot.getTeams().get(c+1) + " " + goals2);
                q_aggScore1[c] = goals1;
                q_aggScore2[c+1] = goals2;

            }
            c++;
            c++;
        }


        System.out.println();

        List<Team> advancingTeams = new ArrayList<>();

        for (int z = 0; z < winnersPot.getTeams().size(); z += 2) {
            if (q_aggScore1[z] > q_aggScore2[z+1]) {
                advancingTeams.add(winnersPot.getTeams().get(z));  // Winner advances
            } else {
                advancingTeams.add(winnersPot.getTeams().get(z+1));  // Other team advances
            }
        }

        winnersPot.getTeams().clear();
        winnersPot.getTeams().addAll(advancingTeams);
        // Clear original list and add only winners
        System.out.println("Qualifying Teams");
        winnersPot.displayPot2();

        int[] s_aggScore1 = new int[winnersPot.getTeams().size()];
        int[] s_aggScore2 = new int[winnersPot.getTeams().size()];
        System.out.println();

        int h = 0;
        while (h < winnersPot.getTeams().size()){
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);

            System.out.println("Home: " + winnersPot.getTeams().get(h) + " " + goals1 + " " + winnersPot.getTeams().get(h+1) + " " + goals2);
            s_aggScore1[h] = goals1;
            s_aggScore2[h+1] = goals2;

            h++;
            h++;
        }
        System.out.println();
        int l = 0;
        while(l < winnersPot.getTeams().size()){
            int goals1 = rand.nextInt(9);
            int goals2 = rand.nextInt(9);

            System.out.println("Away: " + winnersPot.getTeams().get(l+1) + " " + goals2 + " " + winnersPot.getTeams().get(l) + " " + goals1);
            s_aggScore1[l] += goals1;
            s_aggScore2[l+1] += goals2;

            l++;
            l++;
        }
        System.out.println();

        System.out.println("Aggregate Scores");
        int g = 0;
        while(g < winnersPot.getTeams().size())
        {
            System.out.println(winnersPot.getTeams().get(g) + " " + s_aggScore1[g] + " " + winnersPot.getTeams().get(g+1) + " " + s_aggScore2[g+1]);

            while(s_aggScore1[g] == s_aggScore2[g+1]){

                System.out.println(winnersPot.getTeams().get(g) + " And " + winnersPot.getTeams().get(g +1) + " Have Tied ");
                int goals1 = rand.nextInt(6);
                int goals2 = rand.nextInt(6);
                if(goals1 == goals2){
                    System.out.println("Round of penalties tied! Next Round");
                    continue;
                }

                System.out.println("Penalties Score: " + winnersPot.getTeams().get(g) + " " + goals1 + " " + winnersPot.getTeams().get(g+1) + " " + goals2);
                s_aggScore1[g] = goals1;
                s_aggScore2[g+1] = goals2;

            }
            g++;
            g++;
        }

        System.out.println();
        System.out.println("Final");

        advancingTeams.clear();

        for (int z = 0; z < winnersPot.getTeams().size(); z += 2) {
            if (s_aggScore1[z] > s_aggScore2[z+1]) {
                advancingTeams.add(winnersPot.getTeams().get(z));  // Winner advances
            } else {
                advancingTeams.add(winnersPot.getTeams().get(z+1));  // Other team advances
            }
        }

        winnersPot.getTeams().clear();
        winnersPot.getTeams().addAll(advancingTeams);

        int goals1 = rand.nextInt(9);
        int goals2 = rand.nextInt(9);
        System.out.println(winnersPot.getTeams().get(0) + " " + goals1 + " " + winnersPot.getTeams().get(1) + " " + goals2);

        while(goals1 == goals2){

            System.out.println(winnersPot.getTeams().get(0) + " And " + winnersPot.getTeams().get(1) + " Have Tied ");
            int goals_1 = rand.nextInt(6);
            int goals_2 = rand.nextInt(6);
            if(goals_1 == goals_2){
                System.out.println("Round of penalties tied! Next Round");
                continue;
            }
            goals1 = goals_1;
            goals2 = goals_2;

            System.out.println("Penalties Score: " + winnersPot.getTeams().get(0) + " " + goals1 + " " + winnersPot.getTeams().get(1) + " " + goals2);

        }

        System.out.println();

        if(goals1 > goals2){
            System.out.println("Champions!\n" + winnersPot.getTeams().get(0));
        }
        else{
            System.out.println("Champions!\n" + winnersPot.getTeams().get(1));
        }

    }


}
