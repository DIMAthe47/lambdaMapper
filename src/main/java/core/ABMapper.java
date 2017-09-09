package core;

import model.A;
import model.B;

public class ABMapper extends Mapper<A, B> {
    @Override
    public void map(A source, B target) {
//        checkTypeSupplier(() -> source.getA1());
//        checkTypeConsumer((String s) -> target.setB1(s));

        internalMap(() -> source.getA1(), (s) -> target.setB1(s));
        internalMap(() -> source.getA2(), (s) -> target.setB2(s));
    }
}
