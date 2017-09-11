package mappers;

import core.base.Mapper;
import model.enumExample.E1;
import model.enumExample.E1Dto;
import model.enumExample.Enum1;

public class E1DtoMapper extends Mapper<E1, E1Dto> {

    @Override
    protected void internalForwardMap(E1 source, E1Dto target) {
        propertyMap(source::getEnum1, target::setEnum1String, buildEnumToNameConverter());
    }

    @Override
    protected void internalBackwardMap(E1Dto source, E1 target) {
        propertyMap(source::getEnum1String, target::setEnum1, buildNameToEnumConverter(Enum1.class));
    }
}