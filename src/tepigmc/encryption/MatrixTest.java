package tepigmc.encryption;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MatrixTest extends junit.framework.TestCase {
  Matrix a;
  Matrix b;
  Matrix c;
  Matrix d;
  Matrix e;

  @Before
  public void setUp() {
    a = new Matrix(new double[][] {
      {1.0,2.0,3.0},
      {2.0,-5.0,1.0}
    });
    b = new Matrix(new double[][] {
      {-3.0,2.0,1.0},
      {4.0,-2.0,0.0},
      {1.0,2.0,3.0}
    });
    c = new Matrix(new double[][] {
      {8.0,4.0,10.0},
      {-25.0,16.0,5.0}
    });
    d = new Matrix(new double[][] {
      {5.0,10.0,15.0},
      {10.0,-25.0,5.0}
    });
    e = new Matrix(new double[][] {
      {-1.5,-1.0,.5},
      {-3.0,-2.5,1.0},
      {2.5,2.0,-.5}
    });
  }

  @After
  public void tearDown() {
    
  }

  @Test
  public void testMultiply() {
    //System.out.println(a.multiply(b));
    assertEquals(c, a.multiply(b));
  }

  @Test
  public void testMultiplyScalar() {
    //System.out.println(a.multiplyScalar(5));
    assertEquals(d, a.multiplyScalar(5));
  }

  @Test
  public void testInverseMatrixIsSquare() throws SquareException {
    //System.out.println(b.inverse());
    assertEquals(e, b.inverse());
  }

  @Test
  public void testInverseMatrixIsNotSquare() throws SquareException {
    boolean thrown = false;
    try {
      assertEquals(e, a.inverse());
    }
    catch (SquareException e) {
      thrown = true;
    }
    assertTrue(thrown);
  }
}