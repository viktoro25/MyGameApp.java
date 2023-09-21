package controller.stones;

import controller.Controller;
import model.stones.Stones;
import tools.ScanPC;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class StonesController implements Controller {
    @Override
    public List<? extends Object> automaticGeneration() {
        List<Stones> plantsList = new ArrayList<>();

        for(int Y = 0; Y < ScanPC.getScanPS().getHeight(); Y++){
            for(int X = 0; X < ScanPC.getScanPS().getWidth(); X++){
                if(Y == 0 || Y == ScanPC.getScanPS().getHeight()-20){
                    plantsList.add(new Stones(Y,X));
                } else if (Y > 0 && X == 0 || Y > 0 && X == ScanPC.getScanPS().getWidth()-20) {
                    plantsList.add(new Stones(Y,X));
                }
            }
        }
        return plantsList;
    }

    @Override
    public List<? extends Object> parametersGenerationAll(TreeMap<String, Integer> treeMap) throws InstantiationException, IllegalAccessException {
        return null;
    }
}
