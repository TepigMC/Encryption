package tepigmc.encryption;

public class Codes {
  public static String reverse(String msg) {
    String reversed = "";
    for (int i = msg.length()-1; i >= 0; i--) {
      reversed += msg.charAt(i);
    }
    return reversed;
  }

  public static String caesarShift(String msg) {
    return caesarShift(msg, 13);
  }

  public static String caesarShift(String msg, int shift) {
    String letters = "abcdefghijklmnopqrstuvwxyz";
    String shifted = "";
    msg = msg.toLowerCase();
    for (int i = 0; i <= msg.length()-1; i++) {
      String character = msg.substring(i, i+1);
      int pos = letters.indexOf(character);
      if (pos > -1) {
        pos += shift;
        while (pos >= letters.length()) { pos -= letters.length(); }
        while (pos < 0) { pos += letters.length(); }
        shifted += letters.charAt(pos);
      }
      else {
        shifted += character;
      }
    }
    return shifted;
  }

  public static String unicodeShift(String msg, int shift) {
    String shifted = "";
    for (int i = 0; i <= msg.length()-1; i++) {
      char character = msg.charAt(i);
      shifted += (char) (((int) character) + shift);
    }
    return shifted;
  }

  public static String scramble(String msg, int size) {
    if (msg == "" || size == 1) { return msg; }
    char[][] msgArray = new char[(int) Math.ceil(msg.length() / size)][size];
    String scrambled = "";
    for (int c = 0; c <= msgArray.length-1; c++) {
      for (int r = 0; r <= msgArray[0].length-1; r++) {
        scrambled += msg.charAt(c*size+r);
      }
    }
    return scrambled;
  }
}