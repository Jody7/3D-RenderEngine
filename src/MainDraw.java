import maths.RotMatrix;
import maths.Vector3;

import javax.swing.*;
import java.awt.*;

public class MainDraw extends JPanel{

    public void resetBG(){
        this.setBackground(Color.WHITE);
    }

    public void mainTask(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        int offsetX = 150;
        int offsetY = 150;

        g.setColor(Color.red);
        int i = 0;
        RotMatrix rotM = new RotMatrix();
        Vector3 vec1 = new Vector3(0,0,0);
        Vector3 vec2 = new Vector3(0,1,0);
        Vector3 vec3 = new Vector3(1,1,0);
        Vector3 vec4 = new Vector3(1,0,0);

        Vector3 vec5 = new Vector3(0,0,1);
        Vector3 vec6 = new Vector3(0,1,1);
        Vector3 vec7 = new Vector3(1,1,1);
        Vector3 vec8 = new Vector3(1,0,1);

        Vector3 vec9= new Vector3(0,0,0);
        Vector3 vec10 = new Vector3(0,0,1);
        Vector3 vec11 = new Vector3(0,1,1);
        Vector3 vec12 = new Vector3(0,1,0);

        double magnitude = 50;

        double yTheta = Math.toRadians(45);

        Vector3[] vecArray = new Vector3[12];
        Vector3[] pointArray = new Vector3[]{vec1,vec2,vec3,vec4,vec5,vec6,vec7,vec8,vec9,vec10,vec11,vec12};

        while (true){
            i += 2;
            draw2d(g);

            yTheta = Math.toRadians(i);

            //draw axis
            g.setColor(Color.blue);
            g.drawLine(0,offsetY,1000,offsetY);
            g.drawLine(offsetX,0,offsetX,1000);

            for(int M=0; M<12; M++) {
                double rad = Math.toRadians(i);
                vecArray[M] = rotM.rotationTransform(pointArray[M], rad, yTheta/2, yTheta/2);
            }

            g.setColor(Color.red);

            Polygon poly1 = new Polygon();
            //poly.addPoint(offsetX, offsetY);
            poly1.addPoint(offsetX + (int)(vecArray[0].x*magnitude), offsetY + (int)(vecArray[0].y*magnitude));
            poly1.addPoint(offsetX + (int)(vecArray[1].x*magnitude), offsetY + (int)(vecArray[1].y*magnitude));
            poly1.addPoint(offsetX + (int)(vecArray[2].x*magnitude), offsetY + (int)(vecArray[2].y*magnitude));
            poly1.addPoint(offsetX + (int)(vecArray[3].x*magnitude), offsetY + (int)(vecArray[3].y*magnitude));

            Polygon poly2 = new Polygon();

            poly2.addPoint(offsetX + (int)(vecArray[4].x*magnitude), offsetY + (int)(vecArray[4].y*magnitude));
            poly2.addPoint(offsetX + (int)(vecArray[5].x*magnitude), offsetY + (int)(vecArray[5].y*magnitude));
            poly2.addPoint(offsetX + (int)(vecArray[6].x*magnitude), offsetY + (int)(vecArray[6].y*magnitude));
            poly2.addPoint(offsetX + (int)(vecArray[7].x*magnitude), offsetY + (int)(vecArray[7].y*magnitude));

            Polygon poly3 = new Polygon();

            poly3.addPoint(offsetX + (int)(vecArray[8].x*magnitude), offsetY + (int)(vecArray[8].y*magnitude));
            poly3.addPoint(offsetX + (int)(vecArray[9].x*magnitude), offsetY + (int)(vecArray[9].y*magnitude));
            poly3.addPoint(offsetX + (int)(vecArray[10].x*magnitude), offsetY + (int)(vecArray[10].y*magnitude));
            poly3.addPoint(offsetX + (int)(vecArray[11].x*magnitude), offsetY + (int)(vecArray[11].y*magnitude));

            g.drawPolygon(poly1);
            g.drawPolygon(poly2);
            g.drawPolygon(poly3);

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
