package tepigmc.encryption;

import java.util.Arrays;

public class Array {
  public static <T> T[][] arrayConvert(T[] array) {
    int size = (int) Math.ceil(Math.sqrt(array.length));
    array = Arrays.copyOf(array, (int) Math.pow(size, 2.0));
    @SuppressWarnings("unchecked")
    T[][] matrix = (T[][]) new Object[size][size];
    for (int i = 0; i <= size-1; i++) {
      for (int j = 0; j <= size-1; j++) {
        matrix[i][j] = array[(i*size + j)];
      }
    }
    return matrix;
  }
  
  public static <T> T[] arrayConvert(T[][] matrix) {
    @SuppressWarnings("unchecked")
    T[] array = (T[]) new Object[matrix.length * matrix[0].length];
    for (int i = 0; i <= matrix.length-1; i++) {
      for (int j = 0; j <= matrix[0].length-1; j++) {
        array[(i * matrix[0].length + j)] = matrix[i][j];
      }
    }
    return array;
  }
}