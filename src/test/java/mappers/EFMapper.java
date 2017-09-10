package mappers;

import core.base.Mapper;
import model.inheritance.E;
import model.inheritance.F;

public class EFMapper extends Mapper<E, F> {

    @Override
    protected void internalForwardMap(E source, F target) {
        propertyMap(() -> source.getE3(), (s) -> target.setF3(s));
    }

    @Override
    protected void internalBackwardMap(F source, E target) {

    }

    @Override
    protected Mapper<? super E, ? super F> parentMapper() {
        return new EParentFParentMapper();
    }
}
