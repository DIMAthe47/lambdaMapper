package mappers;

import core.base.Mapper;
import model.simple.A;
import model.simple.B;

public class ABMapper extends Mapper<A, B> {

    @Override
    protected void internalForwardMap(A source, B target) {
        propertyMap(source::getA1, target::setB1);
        propertyMap(source::getA2, target::setB2);
    }

    @Override
    protected void internalBackwardMap(B source, A target) {

    }

}