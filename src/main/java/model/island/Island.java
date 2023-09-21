package model.island;

import java.util.ArrayList;
import java.util.List;

public class Island {

    private static Island island;
    public static Island getIsland(){
        if(island == null){
            island = new Island();
        }
        return island;
    }

    private List<Object> objects = new ArrayList<>();

    public List<Object> getObjects() {
        return objects;
    }

    public void setAllObjects(List<? extends Object> listObject) {
        objects.addAll(listObject);
    }
}
