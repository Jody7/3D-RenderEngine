import maths.RotMatrix;
import maths.Vector3;

import javax.swing.*;
import java.awt.*;

public class MainDraw extends JPanel{

    public void resetBG(){
        this.setBackground(Color.WHITE);
    }

    public void mainTask(Graphics g){
        int offsetX = 100;
        int offsetY = 100;

        g.setColor(Color.red);
        int i = 0;
        RotMatrix rotM = new RotMatrix();
        Vector3 vec1 = new Vector3(1,1,0);
        Vector3 vec2 = new Vector3(1,0,0);

        Vector3 v1;
        Vector3 v2;

        double magnitude = 50;

        while (true){
            i++;
            draw2d(g);

            v1 = rotM.rX(vec1, Math.toRadians(i));
            g.drawLine(offsetX, offsetY, offsetX + (int)(v1.x*magnitude), (int)(offsetY + v1.y*magnitude));

            v2 = rotM.rX(vec2, Math.toRadians(i));
            g.drawLine(offsetX, offsetY, offsetX + (int)(v2.x*magnitude), (int)(offsetY + v2.y*magnitude));

            Utility.wait(10);
        }
    }


    public void DrawPoly(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        //Polygon poly = new Polygon(x, y, x.length);
        //g2d.draw(poly);
    }

    public void draw2d(Graphics g){
        super.paintComponent((Graphics2D)g);
    }

}
