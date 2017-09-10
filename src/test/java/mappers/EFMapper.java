package mappers;

import core.base.Mapper;
import model.inheritance.E;
import model.inheritance.F;

public class EFMapper extends Mapper<E, F> {

    @Override
    protected void internalForwardMap(E source, F target) {
        propertyMap(source::getE3, target::setF3);
    }

    @Override
    protected void internalBackwardMap(F source, E target) {

    }

    @Override
    protected Mapper<? super E, ? super F> parentMapper() {
        return new EParentFParentMapper();
    }
}
