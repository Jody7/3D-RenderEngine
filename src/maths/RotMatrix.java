package maths;

public class RotMatrix {
    class RotationMatrix{

        //http://www.c-jump.com/bcc/common/Talk3/Math/Matrices/Matrices.html

        public double matrix4[];
        /*
            double matrix4[] = {
            a, e, i, 0,
            b, f, j, 0,
            c, g, k, 0,
            d, h, l, 1
            };
         */
        int a, b, c, d, e, f, g, h, i;
        public RotationMatrix(int aa,int bb,int cc,int dd,int ee,int ff,int gg,int hh, int ii){
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


    public void rX(RotationMatrix rotM){
        RotationMatrix rotNew = new RotationMatrix(0, 0, 0, 0, 0, 0, 0, 0, 0);

        double a,b,c,d,e,f,g,h,i;
        double j,k,l,m,n,o,p,q,r;
        /*
        j   k   l
        m   n   o
        p   q   r
         */

        a = rotM.a; b = rotM.b; c = rotM.c;
        d = rotM.d; e = rotM.e; f = rotM.f;
        g = rotM.g; h = rotM.h; i = rotM.i;

        j = 1;


    }
    public void rY(){

    }
    public void rZ(){

    }
}
