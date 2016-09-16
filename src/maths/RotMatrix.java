package maths;

public class RotMatrix {
    public class RotationMatrix{

        //http://www.c-jump.com/bcc/common/Talk3/Math/Matrices/Matrices.html

        public double matrix4[];
        /*
            double matrix4[] = {
            a, e, i, 0,
            b, f, j, 0,
            c, g, k, 0,
            0, 0, 0, 1
            };
         */
        double a, b, c, d, e, f, g, h, i;
        public void printString(){
            System.out.println("[" + a + " " + b + " " + c + " " + 0 + "]");
            System.out.println("|" + d + " " + f + " " + f + " " + 0 + "|");
            System.out.println("[" + g + " " + h + " " + i + " " + 0 + "]");
        }
        RotationMatrix(double aa,double bb,double cc,double dd,double ee,double ff,double gg,double hh,double ii){
            a = aa;
            b = bb;
            c = cc;

            d = dd;
            e = ee;
            f = ff;

            g = gg;
            h = hh;
            i = ii;

            double matrix4[] = {
                    a, b, c, 0,
                    d, e, f, 0,
                    g, h, i, 0,
                    0, 0, 0, 1 // i think the padded 0's are for quaternions, which i can implement later
            };

        }
    }

    public RotationMatrix createRotationMatrix(double aa,double bb,double cc,double dd,double ee,double ff,double gg,double hh,double ii){
        return new RotationMatrix(aa, bb, cc, dd, ee, ff, gg, hh, ii);
    }

    public Vector3 rX(Vector3 v1, double theta){
        //double theta = Math.toRadians(45);
        double x,y,z;
        double x2,y2,z2;

        x = v1.x;
        y = v1.y;
        z = v1.z;


        double j,k,l,m,n,o,p,q,r;
        /*
        j   k   l
        m   n   o
        p   q   r
         */

        j = 1; k = 0;               l = 0;
        m = 0; n = Math.cos(theta); o = -Math.sin(theta);
        p = 0; q = Math.sin(theta); r = Math.cos(theta);

        x2 = (x*j) + (y*k) + (z*l);
        y2 = (x*m) + (y*n) + (z*o);
        z2 = (x*p) + (y*q) + (z*r);

        Vector3 v2 = new Vector3(x2, y2, z2);

        return v2;
    }
    public Vector3 rY(Vector3 v1, double theta){
        //double theta = Math.toRadians(45);
        double x,y,z;
        double x2,y2,z2;

        x = v1.x;
        y = v1.y;
        z = v1.z;


        double j,k,l,m,n,o,p,q,r;
        /*
        j   k   l
        m   n   o
        p   q   r
         */

        j = Math.cos(theta); k = 0; l = Math.sin(theta);
                   m = 0; n = 1; o = 0;
        p = -Math.sin(theta); q = 0 ; r = Math.cos(theta);

        x2 = (x*j) + (y*k) + (z*l);
        y2 = (x*m) + (y*n) + (z*o);
        z2 = (x*p) + (y*q) + (z*r);

        Vector3 v2 = new Vector3(x2, y2, z2);

        return v2;
    }

    public void rZ(){

    }
}
