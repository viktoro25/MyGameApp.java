package model.plants;

import model.IslandObjectTypes;
import model.plants.skills.PlantsStatusLife;

public abstract class Plants implements PlantsStatusLife {

    /** Plants - абстрактний клас описуючий параменти рослин. Його успадковують всі рослини.
     * @name - Назва рослини.
     * @setMaxNumberOfPlantsPerCell - Максимальна кількість рослин на одній клітинці ігрового поля.
     * @X - Кордината X.
     * @Y - Кордината Y.
     * @plantSatietyHealth - Шкала життя рослини.
     * @plantsStatusLife - Стан рослини, жива або не жива.
     * @weight - Вага рослини.
     */

    private IslandObjectTypes name;
    private int setMaxNumberOfPlantsPerCell;
    private int plantSatietyHealth;
    public abstract void initEntity();
    private int Y;
    private int X;
    private boolean plantsStatusLife;
    private double weight;

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
    public int getSetMaxNumberOfPlantsPerCell() {
        return setMaxNumberOfPlantsPerCell;
    }

    public void setSetMaxNumberOfPlantsPerCell(int setMaxNumberOfPlantsPerCell) {
        this.setMaxNumberOfPlantsPerCell = setMaxNumberOfPlantsPerCell;
    }
    public IslandObjectTypes getName() {
        return name;
    }

    public void setName(IslandObjectTypes name) {
        this.name = name;
    }

    public int getPlantSatietyHealth() {
        return plantSatietyHealth;
    }

    public void setPlantSatietyHealth(int plantSatietyHealth) {
        this.plantSatietyHealth = plantSatietyHealth;
    }

    public boolean isPlantsStatusLife() {
        return plantsStatusLife;
    }

    public void setPlantsStatusLife(boolean plantsStatusLife) {
        if (plantsStatusLife) this.plantsStatusLife = true;
        else this.plantsStatusLife = false;
    }

    @Override
    public void kill() {
        PlantsStatusLife.super.kill();
        setPlantsStatusLife(false);
    }
    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
