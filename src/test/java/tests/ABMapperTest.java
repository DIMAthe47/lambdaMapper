package tests;

import mappers.ABMapper;
import model.simple.A;
import model.simple.B;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ABMapperTest {

    @Test
    public void testMapObject() {
        ABMapper abMapper = new ABMapper();
        A a = new A("a1", "a2");
        B b = new B("b1", "b2");
        abMapper.mapForward(a, b);
        assertEquals(b.getB1(), a.getA1());
        assertEquals(b.getB2(), a.getA2());
    }

    @Test
    public void testMapClass() {
        ABMapper abMapper = new ABMapper();
        A a = new A("a1", "a2");
        B b = abMapper.mapForward(a, B.class);
        assertEquals(b.getB1(), a.getA1());
        assertEquals(b.getB2(), a.getA2());
    }
}
