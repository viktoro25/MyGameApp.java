package tools;

import java.awt.*;

public class ScanPC {
    private static ScanPC scanPC;
    public static ScanPC getScanPS(){
        if(scanPC == null){
            scanPC = new ScanPC();
            initDisplay();
        }
        return scanPC;
    }
    private static double width;
    private static double height;

    public static double getPointSize(int Y,int X) {
        return 0;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    private static void initDisplay(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        width = 800;
        height = 600;

//        width = screenSize.getWidth();
//        height = screenSize.getHeight();
    }
}
