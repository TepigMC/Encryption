package tepigmc.encryption;

import java.util.Arrays;

public class Codix {
  public static Matrix encode(String msg, double[] key) {
    Matrix.print(arrayToMatrix(toCharCodes(msg)));
    Matrix.print(arrayToMatrix(key));
    Matrix.print(arrayToMatrix(toCharCodes(msg)).multiply(arrayToMatrix(key)));
    return arrayToMatrix(toCharCodes(msg)).multiply(arrayToMatrix(key));
  }
  
  public static double[] toCharCodes(String s) {
    double[] codes = new double[s.length()];
    for (int i = 0; i <= s.length()-1; i++) {
      codes[i] = (double) s.charAt(i);
    }
    return codes;
  }
  
  public static Matrix arrayToMatrix(double[] a) {
    int size = (int)Math.ceil(Math.sqrt(a.length));
    a = Arrays.copyOf(a, (int)Math.pow(size, 2.0D));
    double[][] m = new double[size][size];
    for (int i = 0; i <= size-1; i++) {
      for (int j = 0; j <= size-1; j++) {
        m[i][j] = a[(i*size + j)];
      }
    }
    return new Matrix(m);
  }
  
  public static double[] matrixToArray(Matrix m) {
    double[] a = new double[m.getRows() * m.getCols()];
    for (int i = 0; i <= m.getRows()-1; i++) {
      for (int j = 0; j <= m.getCols()-1; j++) {
        a[(i * m.getCols() + j)] = m.getDataAt(i, j);
      }
    }
    return a;
  }
}