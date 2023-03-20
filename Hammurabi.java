package hammurabi;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int year = 0;
    int stores = 2800; //starting bushels of grain number in storage
    int population = 95; //starting population
    int immigrants = 5; //number immigrated to make 100.
    int acres = 100; //starting acres of land

    boolean isBuying = false;

    public static void main(String[] args) {
        new Hammurabi().playGame();

        String intro ="Congratulations, you are the newest ruler of ancient " +
                "Sumer, elected for a ten year term of office. " +
                "Your duties are to dispense food, direct farming, " +
                "and buy and sell land as needed to support your people. " +
                "Watch out for rat infestations and the plague! " +
                "Grain is the general currency, measured in bushels.";
        System.out.println(intro);

        String yearly = "O great Hammurabi!\n" +
                "You are in year 1 of your ten year rule.\n" +
                "In the previous year 0 people starved to death.\n" +
                "In the previous year 5 people entered the kingdom.\n" +
                "The population is now 100.\n" +
                "We harvested 3000 bushels at 3 bushels per acre.\n" +
                "Rats destroyed 200 bushels, leaving 2800 bushels in storage.\n" +
                "The city owns 1000 acres of land.\n" +
                "Land is currently worth 19 bushels per acre.";

    }

    void playGame() {
        int totalDeaths = 0;
        int percentDied = 0;
        int rats = 0;
        int landCost = 19;
        int plagueDeaths = 0;
        int starvationDeaths = 0;

        //year1(stores, totalDeaths, percentDied, rats, landCost, plagueDeaths, starvationDeaths, immigrants, population, acres);

    }
    int askHowManyAcresToBuy(int price, int bushels) {
        isBuying = true;
        System.out.print("How many acres would you like to buy?");
        int userAcreAmt = scanner.nextInt();
        int costInBushels = price * userAcreAmt;

        System.out.println("I would like to buy" + userAcreAmt + "acres. " +
                "It will cost me" + costInBushels + "bushels to buy that.");

        while (userAcreAmt > acres || bushels < costInBushels) {
            System.out.println("There is not enough acres to be purchased " +
                    "or you do not have enough bushels to purchase that amount.");
            System.out.print("How many acres would you like to buy?");
            userAcreAmt = scanner.nextInt();
            costInBushels = price * userAcreAmt;
        }
        return userAcreAmt;
    }
    int askHowManyAcresToSell(int acresOwned) {
        // if you're buying, then can't sell. Returns 0 for sell amount.
        if (isBuying){
            return 0;
        }

        System.out.print("How many acres would you like to sell?");
        int userAcreAmt = scanner.nextInt();

        System.out.println("I would like to sell" + userAcreAmt + "acres. ");

        while (userAcreAmt > acresOwned) {
            System.out.println("You are trying to sell more acres than you have.");
            System.out.print("How many acres would you like to sell?");
            userAcreAmt = scanner.nextInt();
        }
        return userAcreAmt;
    }
    int askHowMuchGrainToFeedPeople(int bushels){
        System.out.print("How much grain do you need to feed the people?");
        int userGrainAmt = scanner.nextInt();

        while (userGrainAmt > bushels) {
            System.out.println("You do not have that many bushels of grain.");
            userGrainAmt = scanner.nextInt();
        }

        return userGrainAmt;
    }
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        System.out.print("How many acres do you want to plant with grain?");
        int userAcresPlant = scanner.nextInt();
        int populationNeeded = (int) Math.ceil(userAcresPlant/10);
        int bushelCostToPlant = userAcresPlant*2;

        while (userAcresPlant > acresOwned || bushelCostToPlant > bushels || populationNeeded > population){
            System.out.print("You do not have enough acres. " +
                    "Or you do not have enough bushels. " +
                    "Or you do not have enough population.");
            System.out.print("How many acres do you want to plant with grain?");
            userAcresPlant = scanner.nextInt();
            populationNeeded = (int) Math.ceil(userAcresPlant/10);
            bushelCostToPlant = userAcresPlant*2;
        }
        return userAcresPlant;
    }
    int plagueDeaths(int population){
        int chancePlague = (int) (Math.random() * (100 - 1) + 1);
        int diedByPlague = 0;
        if (chancePlague <= 15){
            diedByPlague = population/2;
        }
        return diedByPlague;
    }
    int starvationDeaths(int population, int bushelsFedToPeople){
        int diedByStarve = (int) Math.abs(population - Math.floor((bushelsFedToPeople/20)));
        return diedByStarve;
    }
    boolean uprising(int population, int howManyPeopleStarved){
        if (howManyPeopleStarved >= 0.45*population) {
            return true;
        }
        return false;
    }
    int immigrants(int population, int acresOwned, int grainInStorage){
        int immigrants;
//        if (starvationDeaths(population, grainInStorage) > 0) {
//            immigrants =0;
//        } else {
            immigrants = (20*acresOwned + grainInStorage)/(100*population) +1;
//        }
        return immigrants;
    }
    int harvest(int bushelsUsedAsSeed){
        int random = rand.nextInt(5);
        System.out.println(bushelsUsedAsSeed);
        // () so the value is converted to int after all operations.
        System.out.println("Random number generated: " + random);
        int acresAbleToPlant = bushelsUsedAsSeed/2;
        System.out.println("Acres able to plant: " + acresAbleToPlant);
        int harvestedBushels = acresAbleToPlant*random;
        System.out.println("Harvested bushels: " + harvestedBushels);
        return harvestedBushels;

        //        if (acresAbleToPlant < acres) {
//            harvestedBushels = acresAbleToPlant*random;
//        } else {
//
//        }
    }
    int grainEatenByRats(int bushels){
        int chanceRats = (int) (Math.random() * (100 - 1) + 1);
        int eatenByRats = 0;
        if (chanceRats <= 40){
            //to ensure that the eatenByRats is always a number between 10-30%
            int percentEaten = ((int) (Math.random()*(30-10) +10));
            eatenByRats = bushels * percentEaten / 100;
        }
        return eatenByRats;
    }
    int newCostOfLand(){
        int landPrice = (int) (Math.random() * (24-17) +17);
        return landPrice;
    }

    void year1 (int stores, int totalDeaths, int percentDied, int rats, int landCost,
                int plagueDeaths, int starvationDeaths, int immigrants, int population, int acres) {
        int year1AcresBuy = askHowManyAcresToBuy(landCost, stores);
        int year1AcresSell = askHowManyAcresToSell(acres);
        int year1GrainFeed = askHowMuchGrainToFeedPeople(stores);
        int year1AcresPlant = askHowManyAcresToPlant(acres, population, stores);
        int year1PlagueDeaths = plagueDeaths(population);
        int year1StarvationDeaths = starvationDeaths(population, stores);
        boolean year1Uprising = uprising(population, starvationDeaths);
        int year1Immigrants = immigrants(population, acres, stores);
        int year1Harvest = harvest(stores);
        int year1GrainRats = grainEatenByRats(stores);
        int year1CostLand = newCostOfLand();
    }


}