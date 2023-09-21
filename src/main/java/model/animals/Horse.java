package model.animals;

import blockFactory.AnimalsFactory;
import com.almasb.fxgl.dsl.EntityBuilder;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.physics.CollisionHandler;
import tools.RandomEvent;
import model.IslandObjectTypes;

import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;

public class Horse extends Animals{
    /**
     * Конструктор створення модель Коня.

     * @param y   - кордината У.
     * @param x   - кордината Х.
     */
    public Horse(int y, int x) {
        setName(IslandObjectTypes.Horse);
        setSex(RandomEvent.getGenerationSex());
        setWeight(400);
        setMovementSpeed(4);
        setMaxNumberOfAnimalsPerCell(20);
        setWeightOfFoodConsumption(60);
        setSatietyHealth(100);
        setSatietyScale(100);
        setStatusLife(true);
        setY(y);
        setX(x);
        setTableInFoodAnimal(creationTableInFoodAnimal());
    }

    public Horse() {
        setName(IslandObjectTypes.Horse);
        setSex(RandomEvent.getGenerationSex());
        setWeight(400);
        setMovementSpeed(4);
        setMaxNumberOfAnimalsPerCell(20);
        setWeightOfFoodConsumption(60);
        setSatietyHealth(100);
        setSatietyScale(100);
        setStatusLife(true);
        int[] coordinatesYX = RandomEvent.randomGenerationOfCoordinates();
        setY(coordinatesYX[1]);
        setX(coordinatesYX[0]);
        setTableInFoodAnimal(creationTableInFoodAnimal());
    }
    /**
     * @return tableInFoodAnimal таблицю доступних їстот для споживання.
     */
    @Override
    TreeMap<Object, Integer> creationTableInFoodAnimal() {
        TreeMap<Object, Integer> tableInFoodAnimal = new TreeMap<>();
        tableInFoodAnimal.put(IslandObjectTypes.Grass,100);
        tableInFoodAnimal.put(IslandObjectTypes.Eagle,20);
        return tableInFoodAnimal;
    }

    /** Цей метод створює новонороджену тварину цього типу.
     */
    @Override
    public Animals giveBirthBaby() {
        return new Horse(getY(),getX());
    }

    /**
     * Метод та поле особливості двіжка.
     */
    private Entity linckEntity;
    @Override
    public void initEntity() {
        linckEntity = getGameWorld().spawn("Horse", getY(),getX());
    }

    @Override
    public Entity getLinckEntity(){
        return linckEntity;
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(IslandObjectTypes.Horse, creationTableInFoodAnimal()) {

            // order of types is the same as passed into the constructor

            @Override
            protected void onCollisionBegin(Entity horse, Entity creationTableInFoodAnimal) {
                getGameWorld().removeEntity(creationTableInFoodAnimal);

                // additional code to do something after the grass is removed
            }
        });
    }

    @Override
    public boolean checkFood(Object foodType, TreeMap<Object, Integer> tableFood) {
        return super.checkFood(foodType, tableFood);
    }

    @Override
    public void onDeath() {

    }

    @Override
    public boolean isAlive() {
        return false;
    }

    @Override
    public void setAlive(boolean alive) {

    }

    @Override
    public void multiply(Animals mammal, Animals female) {
        super.multiply(mammal, female);
    }

    @Override
    public boolean checkCompatibility(Animals mammal, Animals female) {
        return super.checkCompatibility(mammal, female);
    }
}
