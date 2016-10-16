package maths;

public class Vector3 {

    public double x;
    public double y;
    public double z;
    public double q; // hidden
    public int tX;
    public int tY;
    public int tZ;

    public int getX(){
        return (int) x;
    }
    public int getY(){
        return (int) y;
    }
    public int getZ(){
        return (int) z;
    }
    public void print(){
        System.out.println("[" + " " + x + " " + y + " " + z + "]");
    }
    public Vector3(double x, double y, double z){
        this.x = x; this.y = y; this.z = z;
    }
    public static double Dot(Vector3 a, Vector3 b){
        return ((a.x * b.x) + (a.y * b.y) + (a.z * b.z));
    }
    public void Normalize(){
        double d = Math.sqrt(x*x + y*y + z*z);
        x = x/d;
        y = y/d;
        z = z/d;
    }
    public Vector3 CrossProduct(Vector3 a, Vector3 b, Vector3 c){
        Vector3 ab = new Vector3(b.x - a.x, b.y - a.y, b.z - a.z);
        Vector3 ac = new Vector3(c.x - a.x, c.y - a.y, c.z - a.z);

        Vector3 cp = new Vector3(
                (ab.y * ac.z - ab.z * ac.y), -(ab.x * ac.z - ab.z * ac.x), (ab.x * ac.y - ab.y * ac.x)
        );
        return cp;
    }
}
