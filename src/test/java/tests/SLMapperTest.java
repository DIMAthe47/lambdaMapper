package tests;

import mappers.ABMapper;
import mappers.SLMapper;
import model.L;
import model.S;
import model.simple.A;
import model.simple.B;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SLMapperTest {

    @Test
    public void testMapObject() {
        SLMapper mapper = new SLMapper();
        S s = new S();
        s.getLongs().addAll(Arrays.asList(2L, 5L, 47L));
        L l = mapper.mapForward(s, L.class);
        assertTrue(l.getStrings().contains("2"));
        assertTrue(l.getStrings().contains("5"));
        assertTrue(l.getStrings().contains("47"));
    }

    @Test
    public void testMapClass() {
        SLMapper mapper = new SLMapper();
        L l = new L();
        l.getStrings().addAll(Arrays.asList("2", "5", "47"));
        S s = mapper.mapBackward(l, S.class);
        assertTrue(s.getLongs().contains(2L));
        assertTrue(s.getLongs().contains(5L));
        assertTrue(s.getLongs().contains(47L));
    }
}
