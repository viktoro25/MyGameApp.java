package controller.plants;

import controller.Controller;
import controller.animals.GenerationAnimals;
import model.animals.*;
import model.plants.Bush;
import model.plants.Grass;
import model.plants.Plants;
import model.plants.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class PlantsController implements Controller {

    /**
     * Хаотично генерує рослини.
     *
     * @return
     */

    private List<Plants> plants = new ArrayList<>();

    public List<Plants> automaticGeneration() throws InstantiationException, IllegalAccessException {
        List<Plants> plants = new ArrayList<>();

        String[] plantTypes = {"Grass", "Bush", "Tree"};

        for (String plantType : plantTypes) {
            GenerationPlants<? extends Plants> generationPlants = new GenerationPlants<>(getClassByName(plantType));
            plants.addAll(generationPlants.generationNewPlantsRandom());
        }

        return plants;
    }

    @Override
    public List<? extends Object> parametersGenerationAll(TreeMap<String, Integer> treeMap) throws InstantiationException, IllegalAccessException {
        for (String key : treeMap.keySet()) {
            Class<? extends Plants> plantClass = getClassByName(key);
            GenerationPlants<? extends Plants> generationPlants = new GenerationPlants<>(plantClass);
            plants.addAll(generationPlants.generationNewPlantsParameters(treeMap.get(key)));
        }
        return plants;
    }

    private Class<? extends Plants> getClassByName(String name) {
        switch (name) {
            case "Grass":
                return Grass.class;
            case "Bush":
                return Bush.class;
            case "Tree":
                return Tree.class;
            default:
                throw new IllegalArgumentException("Unknown plant type: " + name);
        }
    }
}