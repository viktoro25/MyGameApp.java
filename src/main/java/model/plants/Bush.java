package model.plants;

import com.almasb.fxgl.entity.Entity;
import model.IslandObjectTypes;
import tools.RandomEvent;


import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Bush extends Plants{
    /**
     * @setSetMaxNumberOfPlantsPerCell - Кількість рослин на одній клітинці ігрового поля.
     */
    public Bush () {
        setSetMaxNumberOfPlantsPerCell(3);
        int[] coordinatesYX = RandomEvent.randomGenerationOfCoordinates();
        setY(coordinatesYX[1]);
        setX(coordinatesYX[0]);
        setName(IslandObjectTypes.Bush);
    }

    private Entity linckEntity;
    @Override
    public void initEntity() {
        linckEntity = getGameWorld().spawn("Bush",getY(),getX());
    }
}
