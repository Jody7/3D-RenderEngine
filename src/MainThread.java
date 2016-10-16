import maths.RotMatrix;
import maths.Vector3;

import javax.swing.*;
import java.awt.*;

public class MainThread {
    static Graphics graphics;
    public static JFrame CreateFrame(){
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);

        graphics = frame.getGraphics();

        return frame;
    }

    public static void main(String[] args){

        JFrame frame = CreateFrame();
        MainDraw main = new MainDraw();
        main.resetBG();
        frame.add(main);
        frame.addKeyListener(main);
        main.mainTask(graphics);
    }
}
