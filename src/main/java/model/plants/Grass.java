package model.plants;

import blockFactory.PlantsFactory;

import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;
import com.almasb.fxgl.entity.Entity;
import model.IslandObjectTypes;
import tools.RandomEvent;


public class Grass extends Plants{

    /**
     *
     * @setSetMaxNumberOfPlantsPerCell - Кількість рослин на одній клітинці ігрового поля.
     */
 public Grass () {
     setSetMaxNumberOfPlantsPerCell(5);
     int[] coordinatesYX = RandomEvent.randomGenerationOfCoordinates();
     setY(coordinatesYX[1]);
     setX(coordinatesYX[0]);
     setPlantSatietyHealth(100);
     setName(IslandObjectTypes.Grass);
     setWeight(100);
     setPlantsStatusLife(true);

 }
    private Entity linckEntity;
    @Override
    public void initEntity() {
        linckEntity = getGameWorld().spawn("Grass",getY(),getX());
    }
}
