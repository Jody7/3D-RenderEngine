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

        Vector3 v1;
        Vector3 v2;
        Vector3 v3;
        Vector3 v4;

        Vector3 v5;
        Vector3 v6;
        Vector3 v7;
        Vector3 v8;

        Vector3 v9;
        Vector3 v10;
        Vector3 v11;
        Vector3 v12;

        double magnitude = 50;

        double yTheta = Math.toRadians(45);

        while (true){
            i += 2;
            draw2d(g);

            yTheta = Math.toRadians(i/4);

            //draw axis
            g.setColor(Color.blue);
            g.drawLine(0,offsetY,1000,offsetY);
            g.drawLine(offsetX,0,offsetX,1000);



            v1 = rotM.rX(rotM.rY(vec1, yTheta),Math.toRadians(i));
            v2 = rotM.rX(rotM.rY(vec2, yTheta),Math.toRadians(i));
            v3 = rotM.rX(rotM.rY(vec3, yTheta),Math.toRadians(i));
            v4 = rotM.rX(rotM.rY(vec4, yTheta),Math.toRadians(i));

            v5 = rotM.rX(rotM.rY(vec5, yTheta),Math.toRadians(i));
            v6 = rotM.rX(rotM.rY(vec6, yTheta),Math.toRadians(i));
            v7 = rotM.rX(rotM.rY(vec7, yTheta),Math.toRadians(i));
            v8 = rotM.rX(rotM.rY(vec8, yTheta),Math.toRadians(i));

            v9 = rotM.rX(rotM.rY(vec9, yTheta),Math.toRadians(i));
            v10 = rotM.rX(rotM.rY(vec10, yTheta),Math.toRadians(i));
            v11 = rotM.rX(rotM.rY(vec11, yTheta),Math.toRadians(i));
            v12 = rotM.rX(rotM.rY(vec12, yTheta),Math.toRadians(i));

            g.setColor(Color.red);

            Polygon poly1 = new Polygon();
            //poly.addPoint(offsetX, offsetY);
            poly1.addPoint(offsetX + (int)(v1.x*magnitude), offsetY + (int)(v1.y*magnitude));
            poly1.addPoint(offsetX + (int)(v2.x*magnitude), offsetY + (int)(v2.y*magnitude));
            poly1.addPoint(offsetX + (int)(v3.x*magnitude), offsetY + (int)(v3.y*magnitude));
            poly1.addPoint(offsetX + (int)(v4.x*magnitude), offsetY + (int)(v4.y*magnitude));

            Polygon poly2 = new Polygon();

            poly2.addPoint(offsetX + (int)(v5.x*magnitude), offsetY + (int)(v5.y*magnitude));
            poly2.addPoint(offsetX + (int)(v6.x*magnitude), offsetY + (int)(v6.y*magnitude));
            poly2.addPoint(offsetX + (int)(v7.x*magnitude), offsetY + (int)(v7.y*magnitude));
            poly2.addPoint(offsetX + (int)(v8.x*magnitude), offsetY + (int)(v8.y*magnitude));

            Polygon poly3 = new Polygon();

            poly3.addPoint(offsetX + (int)(v9.x*magnitude), offsetY + (int)(v9.y*magnitude));
            poly3.addPoint(offsetX + (int)(v10.x*magnitude), offsetY + (int)(v10.y*magnitude));
            poly3.addPoint(offsetX + (int)(v11.x*magnitude), offsetY + (int)(v11.y*magnitude));
            poly3.addPoint(offsetX + (int)(v12.x*magnitude), offsetY + (int)(v12.y*magnitude));

            g.drawPolygon(poly1);
            g.drawPolygon(poly2);
            g.drawPolygon(poly3);

            Utility.wait(25);
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
