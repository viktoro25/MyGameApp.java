package model.animals;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import component.AnimalsComponent;
import component.DirectionMovement;
import model.IslandObjectTypes;
import model.animals.skills.Eat;
import model.animals.skills.IsDying;
import model.animals.skills.Move;
import model.animals.skills.Multiply;
import tools.RandomEvent;
import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import static com.almasb.fxgl.dsl.FXGLForKtKt.getPhysicsWorld;

public abstract class Animals implements Eat, IsDying, Multiply, Move {

    private IslandObjectTypes name;
    private AnimalsSex sex;
    private double weight;
    private double movementSpeed;
    private int maxNumberOfAnimalsPerCell;
    private double weightOfFoodConsumption;
    private int satietyHealth;
    private int satietyScale;
    private boolean statusLife;
    private int Y;
    private int X;
    private TreeMap<Object, Integer> tableInFoodAnimal;
    private Entity linckEntity;

    public Animals() {
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

    public Animals(int y, int x) {
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

    public void initEntity() {
        linckEntity = getGameWorld().spawn(name.getName(), getY(), getX());
        linckEntity.addComponent(new AnimalsComponent());
    }

    public Entity getLinckEntity() {
        return linckEntity;
    }

    protected abstract void initPhysics();

    public abstract Animals giveBirthBaby();

    public IslandObjectTypes getName() {
        return name;
    }

    public void setName(IslandObjectTypes name) {
        this.name = name;
    }

    public AnimalsSex getSex() {
        return sex;
    }

    public void setSex(AnimalsSex sex) {
        this.sex = sex;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public int getMaxNumberOfAnimalsPerCell() {
        return maxNumberOfAnimalsPerCell;
    }

    public void setMaxNumberOfAnimalsPerCell(int maxNumberOfAnimalsPerCell) {
        this.maxNumberOfAnimalsPerCell = maxNumberOfAnimalsPerCell;
    }

    public double getWeightOfFoodConsumption() {
        return weightOfFoodConsumption;
    }

    public void setWeightOfFoodConsumption(double weightOfFoodConsumption) {
        this.weightOfFoodConsumption = weightOfFoodConsumption;
    }

    public int getSatietyHealth() {
        return satietyHealth;
    }

    public void setSatietyHealth(int satietyHealth) {
        this.satietyHealth = satietyHealth;
    }

    public int getSatietyScale() {
        return satietyScale;
    }

    public void setSatietyScale(int satietyScale) {
        this.satietyScale = satietyScale;
    }

    public boolean isStatusLife() {
        return statusLife;
    }

    public void setStatusLife(boolean statusLife) {
        this.statusLife = statusLife;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public TreeMap<Object, Integer> getTableInFoodAnimal() {
        return tableInFoodAnimal;
    }

    public void setTableInFoodAnimal(TreeMap<Object, Integer> tableInFoodAnimal) {
        this.tableInFoodAnimal = tableInFoodAnimal;
    }

    @Override
    public void eat(Object food, Object consumer) {
        // Реалізація методу споживання їжі
        // ...
    }

    @Override
    public void isDying() {
        if (getSatietyHealth() <= 0) {
            kill();
        }
    }

    @Override
    public void kill() {
        setStatusLife(false);

        // Видалення тварини з ігрового світу
        if (linckEntity != null) {
            linckEntity.removeFromWorld();
        }

        // Логіка, яка виконується при смерті тварини
        System.out.println(name.getName() + " помер.");

        // Тут можна додати іншу логіку, яка виконується при смерті тварини
    }


//    public void multiply(Animals partner) {
//        if (checkCompatibility(partner) && generationProbabilityOfSuccessfulConception()) {
//            Animals baby = giveBirthBaby();
//            baby.initEntity();
//            System.out.println(getName().getName() + " успішно народила дитину " + baby.getName().getName() + ".");
//        } else {
//            System.out.println(getName().getName() + " і " + partner.getName().getName() + " не змогли спаритися.");
//        }
//    }

    @Override
    public void up() {
        // Реалізація методу руху вверх
        // ...
    }

    @Override
    public void down() {
        // Реалізація методу руху вниз
        // ...
    }

    @Override
    public void left() {
        // Реалізація методу руху вліво
        // ...
    }

    @Override
    public void right() {
        // Реалізація методу руху вправо
        // ...
    }

    @Override
    public void stop() {
        // Реалізація методу зупинки
        // ...
    }

    abstract TreeMap<Object, Integer> creationTableInFoodAnimal();
}
