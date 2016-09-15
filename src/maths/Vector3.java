package maths;

public class Vector3 {

    public double x;
    public double y;
    public double z;

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

    public Vector3(int x, int y, int z){
        this.x = x; this.y = y; this.z = z;
    }
}
