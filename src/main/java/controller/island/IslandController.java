package controller.island;

import controller.animals.AnimalsController;
import controller.plants.PlantsController;
import controller.stones.StonesController;
import model.island.Island;
import tools.ScanPC;

public class IslandController {


    private static Island island;

    public void createIsland() throws InstantiationException, IllegalAccessException {

        island = Island.getIsland();
        addAnimals();
        addPlants();
        //addStones();
    }

    private void addAnimals() throws InstantiationException, IllegalAccessException {
        AnimalsController animalsController = new AnimalsController();
        island.setAllObjects(animalsController.automaticGeneration());
    }

    private void addPlants() throws InstantiationException, IllegalAccessException {
        PlantsController plantsController = new PlantsController();
        island.setAllObjects(plantsController.automaticGeneration());
    }

    private void addStones(){
        StonesController stonesController = new StonesController();
        island.setAllObjects(stonesController.automaticGeneration());
    }
}
