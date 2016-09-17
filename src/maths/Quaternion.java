package maths;

public class Quaternion {
    public class Q{
        public double w, x, y, z;
        public void print(){
            System.out.println(w + " " + x + " " + y + " " + z);
        }
        public Q(double aa, double bb, double cc, double dd){
            w = aa;
            x = bb;
            y = cc;
            z = dd;
        }

        public Q conj(){
            return new Q(w, -x, -y, -z);
        }
        public Q multiply (Q q) {
            double W = w*q.w - (x*q.x + y*q.y + z*q.z);

            double x1 = w*q.x + q.w*x + y*q.z - z*q.y;
            double y1 = w*q.y + q.w*y + z*q.x - y*q.z;
            double z1 = w*q.z + q.w*z + x*q.y - y*q.x;

            return new Q(W, x1, y1, z1);
        }

        public double normalize(){
            return Math.sqrt((w*w) + (x*x) + (y*y) + (z*z));
        }

        public Q add(Q q2){
            Q q1 = this;
            return new Q(q1.w + q2.w,q1.x + q2.x,q1.y + q2.y,q1.z + q2.z);
        }

        public Q inverse(){
            double t = (w*w) + (x*x) + (y*y) + (z*z);
            return new Q(w/t, -x/t, -y/t, -z/t);
        }
    }
    public Q rotateQuatByVector(double radTheta, Vector3 v1, Vector3 e){
        Quaternion.Q q1 = createQuaternion(0, e.x, e.y, e.z);
        Quaternion.Q q2 = createQuaternion(
                Math.cos(radTheta/2),
                Math.sin(radTheta/2)*v1.x,
                Math.sin(radTheta/2)*v1.y,
                Math.sin(radTheta/2)*v1.z);

        Quaternion.Q a1 = q2.multiply(q1);
        Quaternion.Q q3 = a1.multiply(q2.conj());

        return q3;
    }
    public Q createQuaternion(double aa, double bb, double cc, double dd){
        return new Q(aa, bb, cc, dd);
    }
}
