package model.animals;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import tools.RandomEvent;
import model.IslandObjectTypes;

import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;

public class Eagle extends Animals{
    /**
     * Конструктор створення модель Орла.
     * @param y   - кордината У.
     * @param x   - кордината Х.
     */
    public Eagle(int y, int x) {
        setName(IslandObjectTypes.Eagle);
        setSex(RandomEvent.getGenerationSex());
        setWeight(6);
        setMovementSpeed(3);
        setMaxNumberOfAnimalsPerCell(20);
        setWeightOfFoodConsumption(1);
        setSatietyHealth(100);
        setSatietyScale(100);
        setStatusLife(true);
        setY(y);
        setX(x);
        setTableInFoodAnimal(creationTableInFoodAnimal());
    }

    public Eagle() {
        setName(IslandObjectTypes.Eagle);
        setSex(RandomEvent.getGenerationSex());
        setWeight(6);
        setMovementSpeed(3);
        setMaxNumberOfAnimalsPerCell(20);
        setWeightOfFoodConsumption(1);
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
        tableInFoodAnimal.put(IslandObjectTypes.Fox,10);
        tableInFoodAnimal.put(IslandObjectTypes.Rabbit,90);
        tableInFoodAnimal.put(IslandObjectTypes.Mouse,90);
        tableInFoodAnimal.put(IslandObjectTypes.Goat,70);
        tableInFoodAnimal.put(IslandObjectTypes.Sheep,70);
        tableInFoodAnimal.put(IslandObjectTypes.Boar,50);
        tableInFoodAnimal.put(IslandObjectTypes.Buffalo,20);
        tableInFoodAnimal.put(IslandObjectTypes.Duck,10);
        return tableInFoodAnimal;
    }

    /** Цей метод створює новонороджену тварину цього типу.
     */
    @Override
    public Animals giveBirthBaby() {
        return new Eagle(getY(),getX());
    }

    /**
     * Метод та поле особливості двіжка.
     */
    private Entity linckEntity;
    @Override
    public void initEntity() {
        linckEntity = getGameWorld().spawn("Eagle", getY(),getX());
    }

    @Override
    public Entity getLinckEntity(){
        return linckEntity;
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(IslandObjectTypes.Eagle, creationTableInFoodAnimal()) {

            // order of types is the same as passed into the constructor
            @Override
            protected void onCollisionBegin(Entity eagle, Entity creationTableInFoodAnimal) {
                creationTableInFoodAnimal.removeFromWorld();
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
