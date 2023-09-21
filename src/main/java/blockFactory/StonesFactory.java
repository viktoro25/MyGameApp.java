package blockFactory;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.shape.Rectangle;

import java.awt.*;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class StonesFactory implements EntityFactory {

    private static StonesFactory stonesFactory;

    /**
     * Створюється як об'єкт один раз, та добавляється як фабрика до списку фабрик.
     */
    public static void startStonesFactory() {
        if (stonesFactory == null) {
            getGameWorld().addEntityFactory(new StonesFactory());
        }
    }

    @Spawns("Stones")
    public Entity stonesBlock(SpawnData data) {
        return FXGL.entityBuilder(data)
                .at(data.getX(), data.getY())
                .viewWithBBox(new Rectangle(25,25))
                .buildAndAttach();
    }
}
