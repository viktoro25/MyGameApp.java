package blockFactory;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import model.animals.Wolf;

import java.awt.*;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

/** Фабрика текстур тварин. Цей клас особливий та обов'язковий, керуючись документацію движка.
 *  Він має бути статичним та неповторним.
 *  Тут зберігається генерація текстури усіх тварин.
 */
public class AnimalsFactory implements EntityFactory {

    private static AnimalsFactory animalsFactory;

    /**9
     * Створюється як об'єкт один раз, та добавляється як фабрика до списку фабрик.
     */
    public static void startAnimalsFactory() {
        if(animalsFactory == null){
            getGameWorld().addEntityFactory(new AnimalsFactory());
        }
    }

    @Spawns("Wolf")
    public Entity newBlockWolf(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Wolf.png")
                .buildAndAttach();
    }

    @Spawns("Python")
    public Entity newBlockPython(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Python.png")
                .buildAndAttach();
    }

    @Spawns("Fox")
    public Entity newBlockFox(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Fox.png")
                .buildAndAttach();
    }

    @Spawns("Bear")
    public Entity newBlockBear(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Bear.png")
                .buildAndAttach();
    }

    @Spawns("Eagle")
    public Entity newBlockEagle(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Eagle.png")
                .buildAndAttach();
    }

    @Spawns("Rabbit")
    public Entity newBlockRabbit(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Rabbit.png")
                .buildAndAttach();
    }

    @Spawns("Horse")
    public Entity newBlockHorse(SpawnData data){
        return  FXGL.entityBuilder(data)
                .at(data.getX(),data.getY())
                .view("animals/Horse.png")
                .buildAndAttach();
    }


}
