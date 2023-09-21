package model.animals.skills;

import model.animals.Animals;
import model.plants.Plants;
import java.util.Random;
import java.util.TreeMap;

public interface Eat {

    /**
     * Метод здійснює модуляцію споживання їжі твариною.
     * При успішному споживані їжі, тварині добавляться до суми шкали ситості масу спожитої їжі.
     * А тварині або рослі (об'єкту) яку з'їли віднімається життя.
     */
    default void eat(Object food, Object consumer) {
        if (food instanceof Animals && consumer instanceof Animals) {
            Animals consumerAnimals = (Animals) consumer;
            Animals foodAnimal = (Animals) food;

            if (checkFood(foodAnimal.getName(), consumerAnimals.getTableInFoodAnimal())) {
                int foodWeight = (int) foodAnimal.getWeight();
                consumerAnimals.setSatietyScale(consumerAnimals.getSatietyScale() + foodWeight);
                foodAnimal.kill();
            }
        } else if (food instanceof Plants && consumer instanceof Animals) {
            Animals consumerAnimals = (Animals) consumer;
            Plants foodPlant = (Plants) food;

            if (checkFood(foodPlant.getName(), consumerAnimals.getTableInFoodAnimal())) {
                int foodWeight = (int) foodPlant.getWeight();
                consumerAnimals.setSatietyScale(consumerAnimals.getSatietyScale() + foodWeight);
                foodPlant.kill();
            }
        }
    }

    /**
     * Метод здійснює перевірку придатності типу їжі для тварини.
     */
    default boolean checkFood(Object foodType, TreeMap<Object, Integer> tableFood) {
        return tableFood.containsKey(foodType) && checkSuccessEat(tableFood.get(foodType));
    }

    /**
     * Метод здійснює імовірність успішності споживання їжі у відсотках.
     */
    private boolean checkSuccessEat(int percentProbability) {
        int randomNumber = new Random().nextInt(100);
        return randomNumber < percentProbability;
    }
}
