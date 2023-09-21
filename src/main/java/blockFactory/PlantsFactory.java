package blockFactory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.texture.AnimatedTexture;
import com.almasb.fxgl.texture.AnimationChannel;
import javafx.util.Duration;

import java.util.List;

import static com.almasb.fxgl.dsl.FXGLForKtKt.*;

/** Фабрика текстур рослин. Цей клас особливий та обов'язковий, керуючись документацію движка.
 *  Він має бути статичним та неповторним.
 *  Тут зберігається генерація текстури усіх рослин.
 */
public class PlantsFactory implements EntityFactory {
    private static PlantsFactory plantsFactory;

    /**
     * Створюється як об'єкт один раз, та добавляється як фабрика до списку фабрик.
     */
    public static void startPlantsFactory() {
        if (plantsFactory == null) {
            getGameWorld().addEntityFactory(new PlantsFactory());
        }

    }

    @Spawns("Grass")
    public Entity grassBlock(SpawnData data) {
        return FXGL.entityBuilder(data)
                .at(data.getX(), data.getY())
                .view("plants/Grass.png")
                .buildAndAttach();
    }

    @Spawns("Tree")
    public Entity treeBlock(SpawnData data) {
        return FXGL.entityBuilder(data)
                .at(data.getX(), data.getY())
                .view("plants/Tree.png")
                .buildAndAttach();
    }

    @Spawns("Bush")
    public Entity bushBlock(SpawnData data) {
        return FXGL.entityBuilder(data)
                .at(data.getX(), data.getY())
                .view("plants/Bush.png")
                .buildAndAttach();
    }
}