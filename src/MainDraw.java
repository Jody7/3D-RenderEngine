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

        int offsetX = 200;
        int offsetY = 200;

        g.setColor(Color.red);
        int i = 0;
        RotMatrix rotM = new RotMatrix();
        Vector3 vec1 = new Vector3(-1,-1,-1);
        Vector3 vec2 = new Vector3(-1,1,-1);
        Vector3 vec3 = new Vector3(1,1,-1);
        Vector3 vec4 = new Vector3(1,-1,-1);

        Vector3 vec5 = new Vector3(-1,-1,1);
        Vector3 vec6 = new Vector3(-1,1,1);
        Vector3 vec7 = new Vector3(1,1,1);
        Vector3 vec8 = new Vector3(1,-1,1);

        Vector3 vec9= new Vector3(1,-1,-1);
        Vector3 vec10 = new Vector3(1,-1,1);
        Vector3 vec11 = new Vector3(1,1,1);
        Vector3 vec12 = new Vector3(1,1,-1);

        Vector3 vec13= new Vector3(-1,-1,-1);
        Vector3 vec14 = new Vector3(-1,-1,1);
        Vector3 vec15 = new Vector3(-1,1,1);
        Vector3 vec16 = new Vector3(-1,1,-1);

        double magnitude = 50;

        double yTheta = Math.toRadians(45);

        Vector3[] vecArray = new Vector3[16];
        Vector3[] pointArray = new Vector3[]{vec1,vec2,vec3,vec4,vec5,vec6,vec7,vec8,vec9,vec10,vec11,vec12,vec13,vec14,vec15,vec16};

        while (true){


            System.out.println(magnitude);
            i += 2;
            draw2d(g);
            //magnitude = 45 + (25 * Math.sin(Math.toRadians(i)));
            yTheta = Math.toRadians(i);

            //draw axis
            g.setColor(Color.blue);
            g.drawLine(0,offsetY,1000,offsetY);
            g.drawLine(offsetX,0,offsetX,1000);

            double funNum = (1.5 * Math.sin(Math.toRadians(i)));

            System.out.println(funNum);
            for(int M=0; M<pointArray.length; M++) {
                double rad = Math.toRadians(i);
                Vector3 rotatedVec = rotM.rotationTransform(pointArray[M], rad, yTheta/2, yTheta/2); // rotate
                vecArray[M] = rotM.translate3d(rotatedVec, funNum, funNum, 0); // bring to desired position
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

            Polygon poly4 = new Polygon();

            poly4.addPoint(offsetX + (int)(vecArray[12].x*magnitude), offsetY + (int)(vecArray[12].y*magnitude));
            poly4.addPoint(offsetX + (int)(vecArray[13].x*magnitude), offsetY + (int)(vecArray[13].y*magnitude));
            poly4.addPoint(offsetX + (int)(vecArray[14].x*magnitude), offsetY + (int)(vecArray[14].y*magnitude));
            poly4.addPoint(offsetX + (int)(vecArray[15].x*magnitude), offsetY + (int)(vecArray[15].y*magnitude));

            g.drawPolygon(poly1);
            g.drawPolygon(poly2);
            g.drawPolygon(poly3);
            g.drawPolygon(poly4);

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
