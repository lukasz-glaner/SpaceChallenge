/*
Rocket cost = $100 Million
Rocket weight = 10 Tonnes
Max weight (with cargo) = 18 Tonnes
Chance of launch explosion = 5% * (cargo carried / cargo limit)
Chance of landing crash = 1% * (cargo carried / cargo limit)
*/
package SpaceChallenge;

public class U1 extends Rocket {
    {
        cost = 100;
        weight = 10000;
        maxWeight = 18000;
        loadedWeight = weight;
    }

    @Override
    public boolean launch() {
        double random = Math.random() * 100 + 1;
        double launchExpChance = 5.0*(loadedWeight - weight)/(maxWeight - weight);
        return random > launchExpChance;
    }

    @Override
    public boolean land() {
        double random = Math.random() * 100 + 1;
        double landExpChance = 1.0*(loadedWeight - weight)/(maxWeight - weight);
        return random > landExpChance;
    }
}
