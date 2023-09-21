package controller.animals;

import model.animals.Animals;
import tools.RandomEvent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Generics: ? wildcard генерує тварин.
 * @param <T>
 */
public class GenerationAnimals<T extends Animals>{
    Class<T> clazz;
    List<T> animals = new ArrayList<T>();
    GenerationAnimals(Class<T> clazz)
    {
        this.clazz = clazz;
    }
    public Collection<? extends Animals> generationNewAnimalsRandom() throws InstantiationException, IllegalAccessException {
        for(int i = 0; i < RandomEvent.randomGenerationColl(100); i++){
            T animal = clazz.newInstance();
            animals.add(animal);
        }
        return animals;
    }

    public Collection<? extends Animals> generationNewAnimalsParameters(int collAnimals) throws InstantiationException, IllegalAccessException {

        for(int i = 0; i < collAnimals; i++){
            T animal = clazz.newInstance();
            animals.add(animal);
        }
        return animals;
    }



}
