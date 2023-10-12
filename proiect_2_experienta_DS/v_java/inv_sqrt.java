package v_java;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;

public class inv_sqrt {
    public static double invSqrt(double x) {
        double xhalf = 0.5d * x;
        long i = Double.doubleToLongBits(x);
        i = 0x5fe6ec85e7de30daL - (i >> 1);
        x = Double.longBitsToDouble(i);
        x *= (1.5d - xhalf * x * x);
        x *= (1.5d - xhalf * x * x);
        x *= (1.5d - xhalf * x * x);
        x *= (1.5d - xhalf * x * x);
        
        return x;
    }
    public static void print_table(double[][] tabel) {
         try {
            FileWriter file = new FileWriter("tabel.csv");
            file.write("U (kV),D1 (cm),D2 (cm),λ1exp (pm), λ2exp (pm), λt (pm)\n");
            for (int i = 0; i < 5; i++) {
                file.write(tabel[i][0] + "," + tabel[i][1] + "," + tabel[i][2] + "," + tabel[i][3] + "," + tabel[i][4] + ","  + tabel[i][5] + "\n");
            }
            file.close();
            
        } catch (IOException err) {
            System.out.println("An error occurred.");
            err.printStackTrace();        
        }
    }
    public static void main(String args[]) {
        double[] U  = new double[] {3   , 3.5, 4    , 4.5   , 5     };  // U  (kV)
        double[] D1 = new double[] {2.85, 2.7, 2.5  , 2.45  , 2.35  };  // D1 (cm)
        double[] D2 = new double[] {5   , 4.6, 4.25 , 4.1   , 3.9   };  // D2 (cm)

        /* constante */
        double L  = 13.5; // L (cm)
        double d1 = 2.13 * Math.pow(10, -10);  // d1 (m)
        double d2 = 1.23 * Math.pow(10, -10);  // d2 (m)
        double e  = 1.602 * Math.pow(10, -19); // e (C)
        double m  = 9.109 * Math.pow(10, -31); // m (kg)
        double h  = 6.625 * Math.pow(10, -34); // h (Js)
        
        double[] lambda1 = new double[5];
        double[] lambda2 = new double[5];
        double[] lambdaT = new double[5];

        for (int i = 0; i < 5; i++) {
            lambda1[i] = d1 * D1[i] * Math.pow(10, 12) / (L * 2);
        }
        for (int i = 0; i < 5; i++) {
            lambda2[i] = d2 * D2[i] * Math.pow(10, 12) / (L * 2);
        }
        for (int i = 0; i < 5; i++) {
            double zmeu = 2 * m * e * U[i] * Math.pow(10, 3);
            lambdaT[i] = h * invSqrt(zmeu) * Math.pow(10,12);
        }

        double[][] tabel = new double[5][6];
        for (int i = 0; i < 5; i++) {
            tabel[i][0] = U[i];
            tabel[i][1] = D1[i];
            tabel[i][2] = D2[i];
            tabel[i][3] = lambda1[i];
            tabel[i][4] = lambda2[i];
            tabel[i][5] = lambdaT[i];
        }
        print_table(tabel);
        // Arrays.stream(tabel).map(Arrays::toString).forEach(System.out::println);
       
    }

}
