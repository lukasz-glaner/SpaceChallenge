package SpaceChallenge;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Simulation simulation = new Simulation();
        int n = 2;
        int budget1 = 0;
        int budget2 = 0;
        File[] files = new File[2];
        files[0] = new File("phase-1.txt");
        files[1] = new File("phase-2.txt");

        for (int i = 0; i<n; i++){
            simulation.loadItems(files[i]);
            simulation.loadU1();
            simulation.loadU2();
            simulation.runSimulation(simulation.u1RocketsArray);
            budget1 += simulation.totalBudget;
            simulation.runSimulation(simulation.u2RocketsArray);
            budget2 += simulation.totalBudget;
        }
        System.out.println("Total budget for U1 rockets for phase-1 and phase-2 was:"+ budget1);
        System.out.println("Total budget for U2 rockets for phase-1 and phase-2 was:"+ budget2);
    }
}
