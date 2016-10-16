import maths.Quaternion;
import maths.RotMatrix;
import maths.Vector3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;

public class MainDraw extends JPanel implements KeyListener{

    double camX, camY, camZ;
    double camRX = 0;
    double camRY = 0;

    public void resetBG(){
        this.setBackground(Color.WHITE);
    }

    public void mainTask(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        //QuaternionBasedDemo(g, g2d);
        camX = 0; camY = 0; camZ = 0;
        MatrixBasedDemo(g, g2d);
    }

    public void QuaternionBasedDemo(Graphics g, Graphics2D g2d){
        Quaternion quaternion = new Quaternion();
        int offsetX = 200;
        int offsetY = 200;

        double theta = 0;

        Vector3 object1 = new Vector3(-1, -1, 1);
        Vector3 object2 = new Vector3(-1, 1, 1);
        Vector3 object3 = new Vector3(1, 1, 1);

        Vector3 object4 = new Vector3(-1, -1, -1);
        Vector3 object5 = new Vector3(-1, 1, -1);
        Vector3 object6 = new Vector3(1, 1, -1);


        Vector3[] vectoryArray = new Vector3[]{object1, object2, object3, object4, object5, object6};
        Quaternion.Q[] qArray = new Quaternion.Q[vectoryArray.length];

        Vector3 rotAxis1 = new Vector3(1, 1, 1);

        g.setColor(Color.red);

        while(true){
            draw2d(g);
            theta = theta + 5;
            double radTheta = Math.toRadians(theta);

            //System.out.println(theta);

            for(int i=0; i<vectoryArray.length; i++){
                qArray[i] = quaternion.rotateQuatByVector(radTheta, rotAxis1, vectoryArray[i]);
            }


            Polygon poly1 = new Polygon();
            poly1.addPoint(offsetX + (int)(100*qArray[0].x), offsetY + (int)(100*qArray[0].y));
            poly1.addPoint(offsetX + (int)(100*qArray[1].x), offsetY + (int)(100*qArray[1].y));
            poly1.addPoint(offsetX + (int)(100*qArray[2].x), offsetY + (int)(100*qArray[2].y));



            Polygon poly2 = new Polygon();
            poly2.addPoint(offsetX + (int)(100*qArray[3].x), offsetY + (int)(100*qArray[3].y));
            poly2.addPoint(offsetX + (int)(100*qArray[4].x), offsetY + (int)(100*qArray[4].y));
            poly2.addPoint(offsetX + (int)(100*qArray[5].x), offsetY + (int)(100*qArray[5].y));

            g.drawPolygon(poly1);
            //g.drawPolygon(poly2);

            Utility.wait(100);
        }

    }

    public void MatrixBasedDemo(Graphics g, Graphics2D g2d) {

        draw2d(g);

        int offsetX = 200;
        int offsetY = 200;

        RotMatrix rotM = new RotMatrix();

        Triangle t1 = new Triangle(new Vector3(1, 1, 1),
                new Vector3(-1, -1, 1),
                new Vector3(-1, 1, -1));

        Triangle t2 = new Triangle(new Vector3(1, 1, 1),
                new Vector3(-1, -1, 1),
                new Vector3(1, -1, -1));

        Triangle t3 = new Triangle(new Vector3(-1, 1, -1),
                new Vector3(1, -1, -1),
                new Vector3(1, 1, 1));

        Triangle t4 = new Triangle(new Vector3(-1, 1, -1),
                new Vector3(1, -1, -1),
                new Vector3(-1, -1, 1));

        Triangle[] triangles = new Triangle[]{t1, t2, t3, t4};

        double magnitude = 1;

        for(int m = 0; m < 4; m++) {
            ArrayList result = new ArrayList<Triangle>();

            for (Triangle t : triangles) {
                Vector3 m1 =
                        new Vector3((t.p1.x + t.p2.x) / 2, (t.p1.y + t.p2.y) / 2, (t.p1.z + t.p2.z) / 2);
                Vector3 m2 =
                        new Vector3((t.p2.x + t.p3.x) / 2, (t.p2.y + t.p3.y) / 2, (t.p2.z + t.p3.z) / 2);
                Vector3 m3 =
                        new Vector3((t.p1.x + t.p3.x) / 2, (t.p1.y + t.p3.y) / 2, (t.p1.z + t.p3.z) / 2);
                result.add(new Triangle(t.p1, m1, m3));
                result.add(new Triangle(t.p2, m1, m2));
                result.add(new Triangle(t.p3, m2, m3));
                result.add(new Triangle(m1, m2, m3));
            }

            Object[] objectList = result.toArray();
            triangles = Arrays.copyOf(objectList, objectList.length, Triangle[].class);

            for (Triangle t : triangles) {
                t.color = Color.RED.getRGB();
                for (Vector3 v : new Vector3[]{t.p1, t.p2, t.p3}) {
                    double l = Math.sqrt(v.x * v.x + v.y * v.y + v.z * v.z) / Math.sqrt(30000);
                    v.x /= l;
                    v.y /= l;
                    v.z /= l;
                }
            }
        }

        double[] zBuffer = new double[500 * 500];

        double lol = 0;

        while (true) {

            lol = lol + 0.1;

            BufferedImage poly = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);


            for (int q = 0; q < zBuffer.length; q++) {
                zBuffer[q] = -100000000;
            }

            //double funNum = (1.5 * Math.sin(Math.toRadians(i)));

            for(int m = 0; m<triangles.length; m++){
                Vector3 rotatedVec1 = rotM.rotationTransform(triangles[m].p1, camRX, camRY, 0, 0, 0, 0);
                triangles[m].v1 = rotM.translate3d(rotatedVec1, 0, 0, 0);

                Vector3 rotatedVec2 = rotM.rotationTransform(triangles[m].p2, camRX, camRY, 0, 0, 0, 0);
                triangles[m].v2 = rotM.translate3d(rotatedVec2, 0, 0, 0);

                Vector3 rotatedVec3 = rotM.rotationTransform(triangles[m].p3, camRX, camRY, 0, 0, 0, 0);
                triangles[m].v3 = rotM.translate3d(rotatedVec3, 0, 0, 0);
            }


            /*
            Polygon p = new Polygon();

            for(Triangle t : triangles){
                p.reset();
                p.addPoint(offsetX + (int)(t.v1.x * magnitude), offsetY + (int)(t.v1.y * magnitude));
                p.addPoint(offsetX + (int)(t.v2.x * magnitude), offsetY + (int)(t.v2.y * magnitude));
                p.addPoint(offsetX + (int)(t.v3.x * magnitude), offsetY + (int)(t.v3.y * magnitude));
                g2d.drawPolygon(p);
            }
            */

            Vector3 lightPos = new Vector3(0, 10000, 10000);
            int bloop = 0;

            for(Triangle t : triangles){
                bloop ++;
                Vector3 a = t.v1;
                Vector3 b = t.v2;
                Vector3 c = t.v3;

                Vector3 center = new Vector3((a.x + b.x + c.x)/3, (a.y + b.y + c.y)/3, (a.z + b.z + c.z)/3);

                Vector3 crossProduct = a.CrossProduct(a, b, c);

                double ndotl = t.NDotL(center, crossProduct, lightPos);

                //center.print();
                //crossProduct.print();

                //System.out.println(ndotl);

                // do color shading

                t.shading(ndotl);


            }


            for(Triangle t : triangles){

                Vector3 a1 = new Vector3(offsetX + (int)(t.v1.x * magnitude), offsetY + (int)(t.v1.y * magnitude), 0);
                Vector3 a2 = new Vector3(offsetX + (int)(t.v2.x * magnitude), offsetY + (int)(t.v2.y * magnitude), 0);
                Vector3 a3 = new Vector3(offsetX + (int)(t.v3.x * magnitude), offsetY + (int)(t.v3.y * magnitude), 0);

                int minX = (int) Math.max(0, Math.ceil(Math.min(a1.x, Math.min(a2.x, a3.x))));
                int maxX = (int) Math.min(poly.getWidth() - 1,
                        Math.floor(Math.max(a1.x, Math.max(a2.x, a3.x))));
                int minY = (int) Math.max(0, Math.ceil(Math.min(a1.y, Math.min(a2.y, a3.y))));
                int maxY = (int) Math.min(poly.getHeight() - 1,
                        Math.floor(Math.max(a1.y, Math.max(a2.y, a3.y))));

                double triangleArea = (a1.y - a3.y) * (a2.x - a3.x) + (a2.y - a3.y) * (a3.x - a1.x);

                for (int y = minY; y <= maxY; y++) {
                    for (int x = minX; x <= maxX; x++) {
                        double b1 =
                                ((y - a3.y) * (a2.x - a3.x) + (a2.y - a3.y) * (a3.x - x)) / triangleArea;
                        double b2 =
                                ((y - a1.y) * (a3.x - a1.x) + (a3.y - a1.y) * (a1.x - x)) / triangleArea;
                        double b3 =
                                ((y - a2.y) * (a1.x - a2.x) + (a1.y - a2.y) * (a2.x - x)) / triangleArea;
                        if (b1 >= 0 && b1 <= 1 && b2 >= 0 && b2 <= 1 && b3 >= 0 && b3 <= 1) {
                            double depth = b1 * t.v1.z + b2 * t.v2.z + b3 * t.v3.z;
                            int zIndex = y * poly.getWidth() + x;
                            if (zBuffer[zIndex] < depth) {
                                poly.setRGB(x, y, t.color2);
                                zBuffer[zIndex] = depth;
                            }
                        }
                    }
                }

            }

            g2d.drawImage(poly, 0, 0, Color.black, null);

            Utility.wait(10);
        }
    }

    public void DrawPoly(Graphics g){
        Graphics2D g2d = (Graphics2D)g;

        //Polygon poly = new Polygon(x, y, x.length);
        //g2d.draw(poly);
    }

    public void draw2d(Graphics g){
        super.paintComponent(g);
    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyChar() == 'w'){
            camZ = camZ+0.1;
        }
        if(e.getKeyChar() == 's'){
            camZ = camZ-0.1;
        }
        if(e.getKeyChar() == 'a'){
            camX = camX+0.1;
        }
        if(e.getKeyChar() == 'd'){
            camX = camX-0.1;
        }

        if(e.getKeyChar() == 'x'){
            camRX = camRX-0.1;
        }
        if(e.getKeyChar() == 'z'){
            camRX = camRX+0.1;
        }

        if(e.getKeyChar() == 'c'){
            camRY = camRY-0.1;
        }
        if(e.getKeyChar() == 'v'){
            camRY = camRY+0.1;
        }

    }

    public void keyReleased(KeyEvent e) {

    }

}
