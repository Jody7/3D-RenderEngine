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
}
