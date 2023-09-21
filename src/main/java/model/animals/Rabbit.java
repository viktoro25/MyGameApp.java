package model.animals;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import tools.RandomEvent;
import model.IslandObjectTypes;

import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;

public class Rabbit extends Animals{
    /**
     *  Конструктор створення модель зай'ця.
     */

    public Rabbit() {
        setName(IslandObjectTypes.Rabbit);
        setSex(RandomEvent.getGenerationSex());
        setWeight(2);
        setMovementSpeed(2);
        setMaxNumberOfAnimalsPerCell(150);
        setWeightOfFoodConsumption(0.45);
        setSatietyHealth(100);
        setSatietyScale(100);
        setStatusLife(true);
        int[] coordinatesYX = RandomEvent.randomGenerationOfCoordinates();
        setY(coordinatesYX[1]);
        setX(coordinatesYX[0]);
        setTableInFoodAnimal(creationTableInFoodAnimal());
    }

    public Rabbit(int y, int x) {
        setName(IslandObjectTypes.Rabbit);
        setSex(RandomEvent.getGenerationSex());
        setWeight(2);
        setMovementSpeed(2);
        setMaxNumberOfAnimalsPerCell(150);
        setWeightOfFoodConsumption(0.45);
        setSatietyHealth(100);
        setSatietyScale(100);
        setStatusLife(true);
        setY(y);
        setX(x);
        setTableInFoodAnimal(creationTableInFoodAnimal());
    }


    /**
     *
     * @return tableInFoodAnimal таблицю доступних їстот для споживання.
     */
    @Override
    TreeMap<Object, Integer> creationTableInFoodAnimal() {
        TreeMap<Object, Integer> tableInFoodAnimal = new TreeMap<>();

        tableInFoodAnimal.put(IslandObjectTypes.Grass, 100);
        tableInFoodAnimal.put(IslandObjectTypes.Eagle, 20);

        return  tableInFoodAnimal;
    }

    private Entity linckEntity;
    @Override
    public void initEntity(){
        linckEntity = getGameWorld().spawn("Rabbit", getY(),getX());
    }
    @Override
    public Entity getLinckEntity(){
        return linckEntity;
    }

    @Override
    protected void initPhysics() {
        getPhysicsWorld().addCollisionHandler(new CollisionHandler(IslandObjectTypes.Rabbit, IslandObjectTypes.Grass) {

            // order of types is the same as passed into the constructor
            @Override
            protected void onCollisionBegin(Entity rabbit, Entity grass) {
                grass.removeFromWorld();
            }
        });
    }

    @Override
    public Animals giveBirthBaby(){
        return new Rabbit(getY(),getX());
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
