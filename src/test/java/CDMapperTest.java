import core.ABMapper;
import core.CDMapper;
import model.A;
import model.B;
import model.C;
import model.D;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CDMapperTest {

    @Test
    public void testMapClass() {
        CDMapper mapper = new CDMapper();
        C c = new C(new A("a1", "a2"));
        D d = mapper.map(c, D.class);
        assertEquals(d.getB().getB1(), c.getA().getA1());
        assertEquals(d.getB().getB2(), c.getA().getA2());
    }
}
