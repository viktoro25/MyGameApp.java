import blockFactory.StonesFactory;
import com.almasb.fxgl.app.scene.GameScene;
import com.almasb.fxgl.app.scene.GameView;
import com.almasb.fxgl.app.services.FXGLAssetLoaderService;
import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.texture.Texture;
import component.AnimalsComponent;
import blockFactory.AnimalsFactory;
import blockFactory.PlantsFactory;
import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.GameWorld;
import controller.island.IslandController;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.IslandObjectTypes;
import model.animals.Wolf;
import model.animals.skills.Eat;
import model.island.Island;
import model.plants.Plants;
import model.stones.Stones;
import tools.RandomEvent;
import tools.ScanPC;
import model.animals.Animals;


import static com.almasb.fxgl.dsl.FXGLForKtKt.getGameScene;


public class MyGameApp extends GameApplication {

    private FXGLAssetLoaderService AssetLoader;

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth((int) ScanPC.getScanPS().getWidth());
        gameSettings.setHeight((int) ScanPC.getScanPS().getHeight());
        gameSettings.setTitle("IslandSimulator");
        gameSettings.setVersion("0.1");
    }

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        testStartGame();
        launch(args);
    }

    public static void testStartGame() throws InstantiationException, IllegalAccessException {
        IslandController islandController = new IslandController();
        islandController.createIsland();
    }

    private GameWorld gameWorld;
    private Texture backgroundTexture;
    private GameView backgroundView;

    @Override
    protected void initGame() {
        // Створення ігорового світу.
        AnimalsFactory.startAnimalsFactory();
        PlantsFactory.startPlantsFactory();
        StonesFactory.startStonesFactory();

        gameWorld = new GameWorld();

        for (Object object : Island.getIsland().getObjects()) {
            if (object instanceof Animals) {
                ((Animals) object).initEntity();
                ((Animals) object).getLinckEntity().addComponent(new AnimalsComponent());
            } else if (object instanceof Plants) {
                ((Plants) object).initEntity();
            } else if (object instanceof Stones) {
                ((Stones) object).initEntity();
            }
        }

        backgroundTexture = FXGL.getAssetLoader().loadTexture("background.jpg");
        backgroundView = new GameView(backgroundTexture,-1);
        getGameScene().addGameView(backgroundView);
    }


    @Override
    public void onUpdate(double tpf) {
        for (Object object : Island.getIsland().getObjects()) {
            if (object instanceof Animals) {
                Animals animal = ((Animals) object);
                Entity entity = animal.getLinckEntity();
                entity.getComponent(AnimalsComponent.class).move(
                        RandomEvent.randomGenerationOfTheDirectionOfMovement(),
                        (int) animal.getMovementSpeed()
                );
            }
        }
    }
}

