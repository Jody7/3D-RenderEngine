import maths.Vector3;

import javax.swing.*;
import java.awt.*;

public class MainDraw extends JPanel{

    public void resetBG(){
        this.setBackground(Color.WHITE);
    }

    public void mainTask(Graphics g){
        g.setColor(Color.red);
        while (true){
            draw2d(g);
            DrawPoly(g);
            Utility.wait(100);
        }
    }


    public void DrawPoly(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        int offsetX = 100;
        int offsetY = 100;


        //Polygon poly = new Polygon(x, y, x.length);
        //g2d.draw(poly);
    }

    public void draw2d(Graphics g){
        super.paintComponent((Graphics2D)g);
    }

}
