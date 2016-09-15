package maths;

public class RotMatrix {
    class RotationMatrix{
        public double matrix4[];
        /*
            double matrix4[] = {
            a, e, i, 0,
            b, f, j, 0,
            c, g, k, 0,
            d, h, l, 1
            };
         */
        int a, b, c, d, e, f, g, h, i, j, k, l;
        public RotationMatrix(int aa,int bb,int cc,int dd,int ee,int ff,int gg,int hh, int ii, int jj, int kk, int ll){
            a = aa;
            b = bb;
            c = cc;
            d = dd;
            e = ee;
            f = ff;
            g = gg;
            h = hh;
            i = ii;
            j = jj;
            k = kk;
            l = ll;

            double matrix4[] = {
                    a, e, i, 0,
                    b, f, j, 0,
                    c, g, k, 0,
                    d, h, l, 1
            };

        }
    }


    public void rX(){
    }
    public void rY(){

    }
    public void rZ(){

    }
}
