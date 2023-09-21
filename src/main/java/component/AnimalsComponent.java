package component;

import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.TransformComponent;
import model.animals.skills.Move;

/** Цей клас є особливим та обов'язковим відповідно до дукоментації двіжка.
 *  До певних обє'ктів сушності в нашому випадку тварин добавляється компонент.
 *  для його релізаії необхідно успадкувати клас двіжка Component та за бажанням.
 *  можна implements різні інтерфейси навиків. Увага для різноманітних моделей тварин
 *  можна добавити різні компоненти.
 */
public class AnimalsComponent extends Component implements Move {
    // note that this component is injected automatically
    private TransformComponent position;
    private double speed = 0;

    public void move(DirectionMovement directionMovement, int speed){
        this.speed = speed;
        if(directionMovement == DirectionMovement.LEFT) left();
        else if (directionMovement == DirectionMovement.DOWN) down();
        else if (directionMovement == DirectionMovement.RIGHT) right();
        else if (directionMovement == DirectionMovement.UP) up();
        else if (directionMovement == DirectionMovement.STOP) stop();
    }

    @Override
    public void onUpdate(double tpf) {
        speed = tpf * 60;
    }

    public void up() {
        position.translateY(-speed);
    }

    public void down() {
        position.translateY(speed);
    }

    public void left() {
        position.translateX(-speed);
    }

    public void right() {
        position.translateX(speed);
    }

    public void stop(){}
}
