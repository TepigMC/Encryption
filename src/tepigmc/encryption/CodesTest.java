package tepigmc.encryption;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CodesTest extends junit.framework.TestCase {
  @Before
  public void setUp() {
    
  }

  @After
  public void tearDown() {
    
  }

  @Test
  public void testReverse() {
    assertEquals("!eip ekil I ,iH", Codes.reverse("Hi, I like pie!"));
    assertEquals("Hi, I like pie!", Codes.reverse(Codes.reverse("Hi, I like pie!")));
  }

  @Test
  public void testCaesarShift() {
    assertEquals("uv, v yvxr cvr!", Codes.caesarShift("Hi, I like pie!"));
    assertEquals("wx, x axzt ext!", Codes.caesarShift("Hi, I like pie!", 15));
    assertEquals("hi, i like pie!", Codes.caesarShift(Codes.caesarShift("Hi, I like pie!")));
    assertEquals("hi, i like pie!", Codes.caesarShift(Codes.caesarShift("Hi, I like pie!", 15), -15));
  }

  @Test
  public void testUnicodeShift() {
    assertEquals("Uv9-V-yvxr-}vr.", Codes.unicodeShift("Hi, I like pie!", 13));
    assertEquals("Hi, I like pie!", Codes.unicodeShift("Uv9-V-yvxr-}vr.", -13));
    assertEquals("Hi, I like pie!", Codes.unicodeShift(Codes.unicodeShift("Hi, I like pie!", 13), -13));
  }
}