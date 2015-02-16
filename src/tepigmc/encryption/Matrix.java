package tepigmc.encryption;

//http://www.codeproject.com/Articles/405128/Matrix-operations-in-Java
import java.util.Arrays;

public class Matrix {
  private double[][] data;
  private int rows;
  private int cols;

  public Matrix(double[][] d) {
    this.data = d;
    this.rows = d.length;
    this.cols = d[0].length;
  }

  public Matrix(int r, int c) {
    this.data = new double[r][c];
    this.rows = r;
    this.cols = c;
  }

  public Matrix(int r, int c, int f) {
    this.data = fill(r, c, f);
    this.rows = r;
    this.cols = c;
  }

  public double[][] getData() { return this.data; }
  public double getDataAt(int r, int c) { return this.data[r][c]; }
  public int getRows() { return this.rows; }
  public int getCols() { return this.cols; }

  public void setData(double[][] d) { this.data = d; }
  public void setDataAt(int r, int c, double d) {
    double[][] newData = this.getData();
    newData[r][c] = d;
    this.setData(newData);
  }

  public Matrix multiply(Matrix b) {
    if (this.getCols() != b.getRows() || this.getData() == null || b.getData() == null) { return null; }
    Matrix c = new Matrix(this.getRows(), b.getCols());
    for(int cArB = 0; cArB <= this.getCols()-1; cArB++) {
      for(int rowA = 0; rowA <= this.getRows()-1; rowA++) {
        for(int colB = 0; colB <= b.getCols()-1; colB++) {
          c.setDataAt(rowA, colB, c.getDataAt(rowA, colB) + this.data[rowA][cArB] * b.data[cArB][colB]);
        }
      }
    }
    return c;
  }

  public Matrix multiplyScalar(double s) {
    double[][] a = this.getData();
    for(int i = 0; i <= this.getRows()-1; i++) {
      for(int j = 0; j <= this.getCols()-1; j++) {
        a[i][j] *= s;
      }
    }
    return new Matrix(a);
  }

  public Matrix inverse() throws SquareException {
    return transpose(cofactor(this)).multiplyScalar(1.0 / determinant(this));
  }

  private static Matrix transpose(Matrix a) {
    Matrix t = new Matrix(a.rows, a.cols);
    for (int i = 0; i <= a.rows-1; i++) {
      for (int j = 0; j <= a.cols-1; j++) {
        t.data[j][i] = a.data[i][j];
      }
    }
    return t;
  }

  public static double determinant(Matrix a) throws SquareException {
    if (!a.isSquare()) {
      throw new SquareException("Matrix must be square");
    }
    if (a.size() == 1) {
	  return a.getDataAt(0, 0);
    }
    if (a.size() == 2) {
      return (a.data[0][0] * a.data[1][1]) - (a.data[0][1] * a.data[1][0]);
    }
    double sum = 0.0;
    for (int i = 0; i <= a.cols-1; i++) {
      sum += changeSign(i) * a.data[0][i] * determinant(createSubMatrix(a, 0, i));
    }
    return sum;
  } 

  private static Matrix createSubMatrix(Matrix a, int excludeRow, int excludeCol) {
    Matrix b = new Matrix(a.rows-1, a.cols-1);
    int r = -1;
    for (int i = 0; i <= a.rows-1; i++) {
      if (i == excludeRow) { continue; }
      r++;
      int c = -1;
      for (int j = 0; j <= a.cols-1; j++) {
        if (j == excludeCol) { continue; }
        b.data[r][++c] = a.data[i][j];
      }
    }
    return b;
  }

  private static Matrix cofactor(Matrix a) throws SquareException {
    Matrix b = new Matrix(a.rows, a.cols);
    for (int i = 0; i <= a.rows-1; i++) {
        for (int j = 0; j <= a.cols-1; j++) {
            b.data[i][j] = changeSign(i) * changeSign(j) * determinant(createSubMatrix(a, i, j));
        }
    }
    return b;
  }

  public boolean isSquare() {
    return this.rows == this.cols;
  }

  public int size() /*throws SquareException*/ {
    /*if (!this.isSquare()) {
      throw new SquareException("Matrix must be square");
    }*/
    return this.rows;
  }

  private static int changeSign(int i) {
    if (i%2 == 0) { return 1; }
    else { return -1; }
  }

  public static double[][] fill(int rows, int cols, double value) {
    double a[][] = new double[rows][cols];
    for(int i = 0; i <= rows-1; i++) {
      Arrays.fill(a[i], value);
    }
    return a;
  }

  public static boolean compare(Matrix a, Matrix b) {
    if (a.rows != b.rows || a.cols != b.cols) {
      return false;
    }
    for(int i = 0; i <= a.rows-1; i++) {
      for(int j = 0; j <= a.cols-1; j++) {
        if (a.data[i][j] != b.data[i][j]) { return false; }
      }
    }
    return true;
  }

  public static void print(Matrix a) {
    for(int i = 0; i <= a.rows-1; i++) {
      System.out.println("");
      for(int j = 0; j <= a.cols-1; j++) {
        System.out.print(a.getDataAt(i, j) + " ");
      }
    }
  }

  public static Matrix arrayToMatrix(double[] a) {
    int size = (int) Math.ceil(Math.sqrt(a.length));
    a = Arrays.copyOf(a, (int) Math.pow(size, 2));
    double[][] m = new double[size][size];
    for (int i = 0; i <= size-1; i++) {
      for (int j = 0; j <= size-1; j++) {
        m[i][j] = a[i*size + j];
      }
    }
    return new Matrix(m);
  }

  public static double[] matrixToArray(Matrix m) {
    double[] a = new double[m.getRows() * m.getCols()];
    for (int i = 0; i <= m.getRows()-1; i++) {
      for (int j = 0; j <= m.getCols()-1; j++) {
        a[i*m.getCols() + j] = m.getDataAt(i, j);
      }
    }
    return a;
  }

  //overrides default equals() method
  public boolean equals(Object obj) {
    Matrix m = (Matrix)obj;
    if (m.getRows() != this.getRows() || m.getCols() != this.getCols()) {
      return false;
    }
    for (int i = 0; i <= this.getRows()-1; i++) {
      for (int j = 0; j <= this.getCols()-1; j++) {
        if (this.getDataAt(i, j) != m.getDataAt(i, j)) {
          return false;
        }
      }
    }
    return true;
  }

  //overrides default toString() method
  public String toString() {
    String s = "";
    for(int i = 0; i <= this.getRows()-1; i++) {
      for(int j = 0; j <= this.getCols()-1; j++) {
        s += this.getDataAt(i, j) + " ";
      }
      s += "\n";
    }
    return s;
  }
}