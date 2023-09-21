package model.plants;

import blockFactory.PlantsFactory;
import com.almasb.fxgl.entity.Entity;
import model.IslandObjectTypes;
import tools.RandomEvent;

import java.util.TreeMap;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Tree extends Plants{
    /**
     * @setSetMaxNumberOfPlantsPerCell - Кількість рослин на одній клітинці ігрового поля.
     */

    public Tree () {
        setSetMaxNumberOfPlantsPerCell(3);
        int[] coordinatesYX = RandomEvent.randomGenerationOfCoordinates();
        setY(coordinatesYX[1]);
        setX(coordinatesYX[0]);
        setName(IslandObjectTypes.Tree);
    }

    private Entity linckEntity;
    @Override
    public void initEntity() {
        linckEntity = getGameWorld().spawn("Tree",getY(),getX());
    }
}
