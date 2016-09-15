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

    public void rotateMatrixTransform(Vector3 v1, Vector3 v2, Vector3 v3, Vector3 v4){
        int rOffset = 45;

        v1.x = Math.cos(v1.x) * (double)v1.x;
        v2.x = Math.sin(v2.x) * (double)v2.x;
        v3.x = Math.asin(v3.x) * (double)v3.x;
        v4.x = Math.cos(v4.x) * (double)v4.x;
    }
    public void rotMatrix(){

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
