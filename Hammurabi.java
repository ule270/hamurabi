package hammurabi;
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    int year = 0;
    int stores = 2800; //starting grain number in storage
    int population = 95; //starting population
    int immigrants = 5; //number immigrated to make 100.
    int acres = 100; //starting acres of land

    public static void main(String[] args) {
        new Hammurabi().playGame();
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
        return price;
    }
    int askHowManyAcresToSell(int acresOwned) {
        return acresOwned;
    }
    int askHowMuchGrainToFeedPeople(int bushels){
        return bushels;
    }
    int askHowManyAcresToPlant(int acresOwned, int population, int bushels){
        return acresOwned;
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
    int harvest(int acres, int bushelsUsedAsSeed){
        return acres;
    }
    int grainEatenByRats(int bushels){
        return bushels;
    }
    int newCostOfLand(){
        return 5;
    }


    //other methods go here
}