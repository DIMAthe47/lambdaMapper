package tests;

import mappers.ABMapper;
import mappers.E1DtoMapper;
import model.enumExample.E1;
import model.enumExample.E1Dto;
import model.enumExample.Enum1;
import model.simple.A;
import model.simple.B;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class E1DtoMapperTest {

    @Test
    public void testMapObject() {
        E1DtoMapper mapper = new E1DtoMapper();
        E1 e1 = new E1();
        e1.setEnum1(Enum1.V2);
        E1Dto dto = mapper.mapForward(e1, E1Dto.class);
        assertEquals(Enum1.V2.name(), dto.getEnum1String());
    }

    @Test
    public void testMapClass() {
        E1DtoMapper mapper = new E1DtoMapper();
        E1Dto dto = new E1Dto();
        dto.setEnum1String(Enum1.V2.name());
        E1 e1 = mapper.mapBackward(dto, E1.class);
        assertEquals(Enum1.V2, e1.getEnum1());
    }
}
