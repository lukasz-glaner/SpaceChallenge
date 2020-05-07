/*
Rocket cost = $120 Million
Rocket weight = 18 Tonnes
Max weight (with cargo) = 29 Tonnes
Chance of launch explosion = 4% * (cargo carried / cargo limit)
Chance of landing crash = 8% * (cargo carried / cargo limit)
 */

package SpaceChallenge;

public class U2 extends Rocket {
    {
        cost = 120;
        weight = 18000;
        maxWeight = 29000;
        loadedWeight = weight;
    }

    @Override
    public boolean launch() {
        double random = Math.random() * 100 + 1;
        double launchExpChance = 4.0*(loadedWeight - weight)/(maxWeight - weight);
        return random > launchExpChance;
    }

    @Override
    public boolean land() {
        double random = Math.random() * 100 + 1;
        double landExpChance = 8.0*(loadedWeight - weight)/(maxWeight - weight);
        return random > landExpChance;
    }
}
