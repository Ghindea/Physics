//import org.apache.commons.math4.legacy.stat.regression.SimpleRegression;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class Prelucrare {
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
            file.write("U (kV),1/sqrt(U) (V^-1/2),D1 (cm),D2 (cm),λ1exp (pm), λ2exp (pm), λt (pm)\n");
            for (int i = 0; i < 5; i++) {
                file.write(tabel[i][0] + "," + tabel[i][1] + "," + tabel[i][2] + "," + tabel[i][3] + "," + tabel[i][4] + ","  + tabel[i][5] + ","  + tabel[i][6] + "\n");
            }

            file.close();
            
        } catch (IOException err) {
            System.out.println("An error occurred.");
//            err.printStackTrace();
        }
    }
    public static void clear() {
        try {
            // Executați comanda "clear" pentru a curăța terminalul (aceasta este specifică pentru sistemele Unix/Linux)
            Process process = Runtime.getRuntime().exec("clear");

            // Așteptați ca procesul să se încheie
            int exitCode = process.waitFor();
//            System.out.println("Procesul de curățare a terminalului a fost terminat cu codul de ieșire: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }        /* valori masurate */
    }
    public static void main(String[] args) {
        clear();
        double[] D1 = new double[] {2.85, 2.7, 2.5  , 2.45  , 2.35  };  // D1 (cm)
        double[] D2 = new double[] {5   , 4.6, 4.25 , 4.1   , 3.9   };  // D2 (cm)

        /* constante */
        double[] U  = new double[] {3   , 3.5, 4    , 4.5   , 5     };  // U  (kV)
        double L  = 13.5; // L (cm)
        double d1 = 2.13 * Math.pow(10, -10);  // d1 (m)
        double d2 = 1.23 * Math.pow(10, -10);  // d2 (m)
        double e  = 1.602 * Math.pow(10, -19); // e (C)
        double m  = 9.109 * Math.pow(10, -31); // m (kg)
        double h  = 6.625 * Math.pow(10, -34); // h (Js)

        /* de calculat */
        double[] sqrU    = new double[5];
        double[] lambda1 = new double[5];
        double[] lambda2 = new double[5];
        double[] lambdaT = new double[5];

        for (int i = 0; i < 5; i++) {
            sqrU[i] = invSqrt(U[i] * 1000);
        }
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

        double[][] tabel = new double[5][7];
        for (int i = 0; i < 5; i++) {
            tabel[i][0] = U[i];
            tabel[i][1] = sqrU[i];
            tabel[i][2] = D1[i];
            tabel[i][3] = D2[i];
            tabel[i][4] = lambda1[i];
            tabel[i][5] = lambda2[i];
            tabel[i][6] = lambdaT[i];
        }
        print_table(tabel);

        /* determinarea constantelor de retea */
//        double zme = 2 * e * m;
//
//        SimpleRegression regression = new SimpleRegression(true);
//        double[][] reg = new double[][] {
//                {sqrU[0], D1[0]},
//                {sqrU[1], D1[1]},
//                {sqrU[2], D1[2]},
//                {sqrU[3], D1[3]},
//                {sqrU[4], D1[4]}};
//        regression.addData(reg);
//
//        double d1Correction = (2 * h * L) / (Math.sqrt(zme) * regression.getSlope());
//        System.out.println(d1);
//        System.out.println(d1Correction);
//        System.out.println("slope of D1 = " + String.format("%.5f ", regression.getSlope()));
//        System.out.println("Δd1 = " + String.format("%.15f", Math.abs(d1Correction- d1)));
//
//
//        reg = new double[][] {
//                {sqrU[0], D2[0]},
//                {sqrU[1], D2[1]},
//                {sqrU[2], D2[2]},
//                {sqrU[3], D2[3]},
//                {sqrU[4], D2[4]}};
//        regression.addData(reg);
//
//        double d2Correction = (2 * h * (L)) / (Math.sqrt(zme) * regression.getSlope());
//        System.out.println("slope of D2 = " + String.format("%.5f ", regression.getSlope()));
//        System.out.println("Δd2 = " + String.format("%.15f", Math.abs(d2Correction- d2)));
    }

}
