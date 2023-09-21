package controller.animals;

import controller.Controller;
import model.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class AnimalsController implements Controller {

    private List<Animals> animals = new ArrayList<>();

    /** Генерує хаотично тварин.
     * @return Повертає список тварин
     */
    @Override
    public List<Animals> automaticGeneration() throws InstantiationException, IllegalAccessException {
        List<Animals> animals = new ArrayList<>();

        String[] animalTypes = {"Wolf", "Python", "Fox", "Bear", "Eagle", "Horse", "Rabbit"};

        for (String animalType : animalTypes) {
            GenerationAnimals<? extends Animals> generationAnimals = new GenerationAnimals<>(getClassByName(animalType));
            animals.addAll(generationAnimals.generationNewAnimalsRandom());
        }

        return animals;
    }

    private Class<? extends Animals> getClassByName(String name) {
        switch (name) {
            case "Wolf":
                return Wolf.class;
            case "Python":
                return Python.class;
            case "Fox":
                return Fox.class;
            case "Bear":
                return Bear.class;
            case "Eagle":
                return Eagle.class;
            case "Horse":
                return Horse.class;
            case "Rabbit":
                return Rabbit.class;
            default:
                throw new IllegalArgumentException("Unknown animal type: " + name);
        }
    }



    /** Генерує тварин з пареметрами кількості
     * @return Повертає список тварин
     * Коли доавляэмо новий вид тварини необхідно дабавити його в список параметрів.
     */
    @Override
    public List<Animals> parametersGenerationAll(TreeMap<String, Integer> treeMap)
            throws InstantiationException, IllegalAccessException {
        List<Animals> animals = new ArrayList<>();

        for (String key : treeMap.keySet()) {
            Class<? extends Animals> animalClass = getClassByName(key);
            GenerationAnimals<? extends Animals> generationAnimals = new GenerationAnimals<>(animalClass);
            animals.addAll(generationAnimals.generationNewAnimalsParameters(treeMap.get(key)));
        }

        return animals;
    }


}
