package controller.plants;
import model.plants.Plants;
import tools.RandomEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenerationPlants <T extends Plants>{

    Class<T> clazz;
    List<T> plants = new ArrayList<T>();

    GenerationPlants(Class<T> clazz){
        this.clazz = clazz;
    }

    public Collection<? extends Plants> generationNewPlantsRandom() throws InstantiationException, IllegalAccessException {
        for(int i = 0; i < RandomEvent.randomGenerationColl(100); i++){
            T plant = clazz.newInstance();
            plants.add(plant);
        }
        return plants;
    }

    public Collection<? extends Plants> generationNewPlantsParameters(int collPlants) throws InstantiationException, IllegalAccessException {
        for(int i = 0; i < collPlants; i++){
            T plant = clazz.newInstance();
            plants.add(plant);
        }
        return plants;
    }
}
