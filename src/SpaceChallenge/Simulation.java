package SpaceChallenge;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    ArrayList loadedItems = new ArrayList();
    ArrayList u1RocketsArray = new ArrayList();
    ArrayList u2RocketsArray = new ArrayList();
    int totalBudget = 0;

    ArrayList loadItems(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Item item = new Item();
            item.name = line.split("=")[0];
            item.weight = Integer.parseInt(line.split("=")[1]);
            loadedItems.add(item);
        }
        return loadedItems;
    }

    ArrayList loadU1(){
        U1 u1 = new U1();
        Item item = new Item();
        for(int i = 0; i<loadedItems.size();i++){
            item = (Item) loadedItems.get(i);
            if(!u1.canCarry(item)){
                u1RocketsArray.add(u1);
                u1 = new U1();
            }
            u1.loadedWeight += item.weight;
        }
        u1RocketsArray .add(u1);
        return u1RocketsArray;
    }

    ArrayList loadU2(){
        U2 u2 = new U2();
        Item item = new Item();
        for(int i = 0; i<loadedItems.size();i++){
            item = (Item) loadedItems.get(i);
            if(!u2.canCarry(item)){
                u2RocketsArray.add(u2);
                u2 = new U2();
            }
            u2.loadedWeight += item.weight;
        }
        u2RocketsArray .add(u2);
        return u2RocketsArray;
    }

    int runSimulation(ArrayList rockets){
        for(int i=0; i<rockets.size(); i++){
            Rocket oneRocket = (Rocket) rockets.get(i);
            if(!oneRocket.launch() || !oneRocket.land()){
                i--;
            }
            totalBudget += oneRocket.cost;

        }
        return totalBudget;
    }
}
