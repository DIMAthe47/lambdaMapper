package core.step1;

import core.step1.InternalMapper;
import core.step1.Mapper;
import model.simple.A;
import model.simple.B;

public class ABMapper implements Mapper<A, B> {

    InternalMapper internalMapper = new InternalMapper();

    @Override
    public void map(A source, B target) {
//        checkTypeSupplier(() -> source.getA1());
//        checkTypeConsumer((String s) -> target.setB1(s));

        internalMapper.internalMap(() -> source.getA1(), (s) -> target.setB1(s));
        internalMapper.internalMap(() -> source.getA2(), (s) -> target.setB2(s));
    }

    @Override
    public B map(A source, Class<B> targetClass) {
        return internalMapper.map(source, targetClass, this);
    }
}
