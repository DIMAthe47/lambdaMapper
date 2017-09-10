package tests;

import mappers.Entity1Mapper;
import model.entity.Entity1;
import model.entity.Entity1Dto;
import model.entity.Enum1;
import model.entity.Enum2;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Entity1MapperTest {

    @Test
    public void testMapClass() {
        Entity1Mapper mapper = new Entity1Mapper();
        Entity1 entity1 = new Entity1("e1", 47L, new Enum1(1L, "enum1"), new Enum2(2L, "enum2"));
        Entity1Dto entity1Dto = mapper.map(entity1, Entity1Dto.class);
        assertEquals(entity1Dto.getA(), entity1.getA());
        assertEquals(entity1Dto.getB(), entity1.getB());
        assertEquals(entity1Dto.getEnum1Id(), entity1.getEnum1().getId());
        assertEquals(entity1Dto.getEnum2Id(), entity1.getEnum2().getId());
    }
}
