package model.animals.skills;

import model.animals.Animals;

public interface Multiply{

    /**
     * Метод здійнює модуляцію розмноження.
     */
     default void multiply(Animals mammal, Animals female){
        if(checkCompatibility(mammal,female) && generationProbabilityOfSuccessfulConception()){
            female.giveBirthBaby();
            System.out.println("Успішно народила дитину.");
        }
     }

    /** Метод здійснює перевірку можливості спарювання двух тварин.
     */
    default boolean checkCompatibility(Animals mammal, Animals female){
        if(mammal.getSex() == female.getSex()){
            return false;
        }
        if(mammal.getName() !=  female.getName()){
            return  false;
        }
        return true;
    }


    /** Цей метод імітує успішність зачаття нової тварини з вірогідністю 50/50.
     * Як що випаде 1 неуспішно як що 2 успішно.
     */
    private boolean generationProbabilityOfSuccessfulConception(){
        int a = (int) (Math.random()*(1+1)) + 1;

        if(a == 1){
            return false;
        }else {
            return true;
        }
    }
}


