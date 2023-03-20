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
        int grain;
        int totalDeaths = 0;
        int percentDied = 0;
        int rats = 0;
        int landCost;
        int plagueDeaths;
        int starvationDeaths;

        // declare local variables here: grain, population, etc.
        // statements go after the declarations
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
        return population;
    }
    int starvationDeaths(int population, int bushelsFedToPeople){
        return population;
    }
    boolean uprising(int population, int howManyPeopleStarved){
        return false;
    }
    int immigrants(int population, int acresOwned, int grainInStorage){
        return population;
    }
    int harvest(int acres){
        return acres;
    }
    int grainEatenByRats(int bushels){
        return bushels;
    }
    int newCostOfLand(){
        return 5;
    }

}