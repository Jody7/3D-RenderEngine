import maths.Vector3;

import java.awt.*;

/**
 * Created by Jody on 10/14/2016.
 */
public class Triangle {
    Vector3 p1, p2, p3;
    Vector3 v1, v2, v3;
    int color;
    int color2;
    public int calcColor(int shift, double shading){
        return (int)Math.pow((Math.pow((color >> shift) & 0xFF, 2.4) * shading), 1/2.4);
    }
    public void shading(double shading){
        shading = Math.abs(shading);
        color2 = new Color(calcColor(16, shading), calcColor(8, shading), calcColor(0, shading)).getRGB();
};
    public Triangle(Vector3 _x, Vector3 _y, Vector3 _z){
        p1 = _x; p2 = _y; p3 = _z;
    }

    public double NDotL(Vector3 vertex, Vector3 norm, Vector3 lightPos){
        Vector3 lightDir = new Vector3(lightPos.x - vertex.x, lightPos.y - vertex.y, lightPos.z - vertex.z);

        norm.Normalize();
        lightDir.Normalize();

        return Vector3.Dot(norm, lightDir);
    }

}
