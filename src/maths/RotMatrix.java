package maths;

public class RotMatrix {
    public void rotateMatrixTransform(Vector3 v1, Vector3 v2, Vector3 v3, Vector3 v4){
        int rOffset = 45;

        v1.x = Math.cos(v1.x) * (double)v1.x;
        v2.x = Math.sin(v2.x) * (double)v2.x;
        v3.x = Math.asin(v3.x) * (double)v3.x;
        v4.x = Math.cos(v4.x) * (double)v4.x;
    }
    public void rotMatrix(){

    }
}
