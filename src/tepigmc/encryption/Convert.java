package tepigmc.encryption;

//import org.apache.commons.codec.binary.Base64;

public class Convert {
  public static int unicodeToDec(char c) {
    return (int) c;
  }

  public static int[] unicodeToDec (String uni) {
    int[] decs = new int[uni.length()];
    for (int i = 0; i <= uni.length()-1; i++) {
      decs[i] = (int) uni.charAt(i);
    }
    return decs;
  }

  public static char decToUnicode(int dec) {
    return (char) dec;
  }

  public static String decToUnicode(int[] decs) {
    String uni = "";
    for (int dec : decs) {
      uni += (char) dec;
    }
    return uni;
  }

  public static String decToUnicode(String decs) throws IllegalArgumentException {
    if (!decs.matches("^(\\d ?)+$")) { throw new IllegalArgumentException("Argument must be a String of ints seperated by a space"); }
    String[] stringArray = decs.split(" ");
    int[] decsArray = new int[stringArray.length];
    for (int i = 0; i <= stringArray.length-1; i++) {
      decsArray[i] = Integer.parseInt(stringArray[i]);
    }
    return decToUnicode(decsArray);
  }

  public static String unicodeToBase(char c, int base) throws IllegalArgumentException {
    if (base > 36) { throw new IllegalArgumentException("Base cannot be greater than 36"); }
    if (base < 2)  { throw new IllegalArgumentException("Base cannot be less than 2");     }
    return Integer.toString((int) c, base);
  }

  public static String[] unicodeToBaseArray (String uni, int base) throws IllegalArgumentException {
    String[] values = new String[uni.length()];
    for (int i = 0; i <= uni.length()-1; i++) {
      values[i] = Integer.toString((int) uni.charAt(i), base);
    }
    return values;
  }

  public static String unicodeToBase (String uni, int base) throws IllegalArgumentException {
    String[] valuesArray = unicodeToBaseArray(uni, base);
    if (valuesArray.length == 0) { return ""; }
    String values = "";
    for (String value : valuesArray) {
      values += value + " ";
    }
    return values.substring(0, values.length()-1);
  }

  public static char baseToUnicodeChar(String value, int base) throws IllegalArgumentException {
    return (char) Integer.parseInt(value, base);
  }

  public static String baseToUnicode(String[] values, int base) throws IllegalArgumentException {
    if (values.length == 0) { return ""; }
    String uni = "";
    for (String value : values) {
      uni += (char) Integer.parseInt(value, base);
    }
    return uni;
  }

  public static String baseToUnicode(String values, int base) throws IllegalArgumentException {
    if (values.length() == 0) { return ""; }
    String[] valuesArray = values.split(" ");
    String uni = "";
    for (String value : valuesArray) {
      uni += (char) Integer.parseInt(value, base);
    }
    return uni;
  }

  public static String decToBin(int dec) {
    return Integer.toBinaryString(dec);
  }

  public static int binToDec(String bin) {
    return Integer.parseInt(bin, 2);
  }

  public static String decToHex(int dec) {
    return Integer.toHexString(dec);
  }

  public static int hexToDec(String hex) {
    return Integer.parseInt(hex, 16);
  }

  public static String decToBase(int dec, int base) throws IllegalArgumentException {
    if (base > 36) { throw new IllegalArgumentException("Base cannot be greater than 36"); }
    if (base < 2)  { throw new IllegalArgumentException("Base cannot be less than 2");     }
    return Integer.toString(dec, base);
  }

  public static int baseToDec(String value, int base) throws IllegalArgumentException {
    if (base > 36) { throw new IllegalArgumentException("Base cannot be greater than 36"); }
    if (base < 2)  { throw new IllegalArgumentException("Base cannot be less than 2");     }
    return Integer.parseInt(value, base);
  }

  public static String baseChange(String value, int base1, int base2) {
    return Integer.toString(Integer.parseInt(value, base1), base2);
  }

  public static void printArray(int[] array)    { System.out.println(arrayToString(array)); }
  public static void printArray(String[] array) { System.out.println(arrayToString(array)); }

  public static String arrayToString(int[] array) {
    if (array.length == 0) { return ""; }
    String arrayString = "";
    for (int a : array) {
      arrayString += a + " ";
    }
    return arrayString.substring(0, arrayString.length()-1);
  }

  public static String arrayToString(String[] array) {
    if (array.length == 0) { return ""; }
    String arrayString = "";
    for (String a : array) {
      arrayString += a + " ";
    }
    return arrayString.substring(0, arrayString.length()-1);
  }

  public static boolean compareArrays(int[] a, int[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i <= a.length-1; i++) {
      if (a[i] != b[i]) { return false; }
    }
    return true;
  }

  public static boolean compareArrays(String[] a, String[] b) {
    if (a.length != b.length) { return false; }
    for (int i = 0; i <= a.length-1; i++) {
      if (!a[i].equals(b[i])) { return false; }
    }
    return true;
  }
}