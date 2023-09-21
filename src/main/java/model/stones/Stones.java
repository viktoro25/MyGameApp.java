package model.stones;

import com.almasb.fxgl.entity.Entity;

import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameWorld;

public class Stones {

    private int Y;
    private int X;
    public Stones(int Y, int X) {
        this.Y = Y;
        this.X = X;
    }

    private Entity linckEntity;

    public void initEntity() {
        linckEntity = getGameWorld().spawn("Stones",X,Y);
    }
}
