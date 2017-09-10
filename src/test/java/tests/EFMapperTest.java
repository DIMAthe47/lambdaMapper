package tests;

import mappers.EFMapper;
import model.inheritance.E;
import model.inheritance.F;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EFMapperTest {

    @Test
    public void testMapClass() {
        EFMapper mapper = new EFMapper();
        E e = new E("e1", "e2", "e3");
        F f = mapper.map(e, F.class);
        assertEquals(e.getE1(), f.getF1());
        assertEquals(e.getE2(), f.getF2());
        assertEquals(e.getE3(), f.getF3());
    }
}
