package core.step3;

import model.simple.A;
import model.simple.B;

public class ABMapper extends Mapper<A, B> {

    @Override
    protected void internalForwardMap(A source, B target) {
        propertyMap(() -> source.getA1(), (s) -> target.setB1(s));
        propertyMap(() -> source.getA2(), (s) -> target.setB2(s));
    }

    @Override
    protected void internalBackwardMap(B source, A target) {

    }

}