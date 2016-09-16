import maths.RotMatrix;
import maths.Vector3;

import javax.swing.*;
import java.awt.*;

public class MainThread {
    static Graphics graphics;
    public static JFrame CreateFrame(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
        graphics = frame.getGraphics();
        return frame;
    }

    public static void main(String[] args){
        /*
        JFrame frame = CreateFrame();
        MainDraw main = new MainDraw();
        main.resetBG();
        frame.add(main);

        main.mainTask(graphics);
        */


        RotMatrix rotM = new RotMatrix();
        Vector3 v1 = new Vector3(0,1,0);
        Vector3 v2 = rotM.rX(v1);
        v1.print();
        v2.print();
    }
}
