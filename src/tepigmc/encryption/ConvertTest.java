package tepigmc.encryption;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ConvertTest extends junit.framework.TestCase {
  int[] intArray0;
  String[] stringArray0;
  String baseString0;
  String decString0;

  @Before
  public void setUp() {
    intArray0 = new int[] {72, 105, 44, 32, 73, 32, 108, 105, 107, 101, 32, 112, 105, 101, 33};
    stringArray0 = new String[] {"48","69","2c","20","49","20","6c","69","6b","65","20","70","69","65","21"};
    baseString0 = "48 69 2c 20 49 20 6c 69 6b 65 20 70 69 65 21";
    decString0 = "72 105 44 32 73 32 108 105 107 101 32 112 105 101 33";
  }

  @After
  public void tearDown() {
    
  }

  @Test
  public void testUnicodeToDec_char() {
    assertEquals(72, Convert.unicodeToDec('H'));
  }

  @Test
  public void testUnicodeToDec_string() {
    assertTrue(Convert.compareArrays(intArray0, Convert.unicodeToDec("Hi, I like pie!")));
  }

  @Test
  public void testDecToUnicode_int() {
    assertEquals('H', Convert.decToUnicode(72));
  }

  @Test
  public void testDecToUnicode_array() {
    assertEquals("Hi, I like pie!", Convert.decToUnicode(intArray0));
  }

  @Test
  public void testDecToUnicode_string() {
    assertEquals("Hi, I like pie!", Convert.decToUnicode(decString0));
  }

  @Test
  public void testUnicodeToBase_char() {
    assertEquals("48", Convert.unicodeToBase('H', 16));
  }

  @Test
  public void testUnicodeToBaseArray() {
    assertTrue(Convert.compareArrays(stringArray0, Convert.unicodeToBaseArray("Hi, I like pie!", 16)));
  }

  @Test
  public void testUnicodeToBase() {
    assertEquals(baseString0, Convert.unicodeToBase("Hi, I like pie!", 16));
  }

  @Test
  public void testBaseToUnicodeChar() {
    assertEquals('H', Convert.baseToUnicodeChar("48", 16));
  }

  @Test
  public void testBaseToUnicode() {
    assertEquals("Hi, I like pie!", Convert.baseToUnicode(baseString0, 16));
  }

  @Test
  public void testBaseToUnicode_array() {
    assertEquals("Hi, I like pie!", Convert.baseToUnicode(stringArray0, 16));
  }

  @Test
  public void testDecToBin() {
    assertEquals("100111010", Convert.decToBin(314));
  }

  @Test
  public void testBinToDec() {
    assertEquals(314, Convert.binToDec("100111010"));
  }

  @Test
  public void testDecToHex() {
    assertEquals("13a", Convert.decToHex(314));
  }

  @Test
  public void testHexToDec() {
    assertEquals(314, Convert.hexToDec("13a"));
  }

  @Test
  public void testDecToBase() {
    assertEquals("8q", Convert.decToBase(314, 36));
  }

  @Test
  public void testBaseToDec() {
    assertEquals(314, Convert.baseToDec("8q", 36));
  }

  @Test
  public void testBaseChange() {
    assertEquals("126d", Convert.baseChange("314", 36, 15));
    assertEquals("314", Convert.baseChange("126d", 15, 36));
  }
}