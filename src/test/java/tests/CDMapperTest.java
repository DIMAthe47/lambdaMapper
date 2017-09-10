package tests;

import mappers.CDMapper;
import model.simple.A;
import model.nested.C;
import model.nested.D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDMapperTest {

    @Test
    public void testMapClass() {
        CDMapper mapper = new CDMapper();
        C c = new C(new A("a1", "a2"));
        D d = mapper.mapForward(c, D.class);
        assertEquals(d.getB().getB1(), c.getA().getA1());
        assertEquals(d.getB().getB2(), c.getA().getA2());
    }
}
