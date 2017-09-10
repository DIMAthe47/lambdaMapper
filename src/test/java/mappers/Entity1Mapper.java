package mappers;

import core.base.Mapper;
import service.EnumServiceConverters;
import model.entity.Entity1;
import model.entity.Entity1Dto;
import model.entity.Enum1;
import model.entity.Enum2;

public class Entity1Mapper extends Mapper<Entity1, Entity1Dto> {

    EnumServiceConverters enumServiceConverters = new EnumServiceConverters();

    @Override
    protected void internalForwardMap(Entity1 source, Entity1Dto target) {
        propertyMap(() -> source.getA(), (a) -> target.setA(a));
        propertyMap(() -> source.getB(), (b) -> target.setB(b));
        propertyMap(() -> source.getEnum1(), (id) -> target.setEnum1Id(id), enumServiceConverters.getConverterFromEntity());
//        propertyMap(() -> source.getEnum1(), (id) -> target.setEnum1Id(id), enumServiceConverters.getConverterFromEntity());
        propertyMap(() -> source.getEnum2(), (id) -> target.setEnum2Id(id), enumServiceConverters.getConverterFromEntity());
    }

    @Override
    protected void internalBackwardMap(Entity1Dto source, Entity1 target) {
        propertyMap(() -> source.getA(), (a) -> target.setA(a));
        propertyMap(() -> source.getB(), (b) -> target.setB(b));
        propertyMap(() -> source.getEnum1Id(), (e) -> target.setEnum1(e), enumServiceConverters.getConverterFromId(Enum1.class));
        propertyMap(() -> source.getEnum2Id(), (e) -> target.setEnum2(e), enumServiceConverters.getConverterFromId(Enum2.class));
    }

}
