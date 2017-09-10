package core.step1;

import model.simple.A;
import model.simple.B;
import model.nested.C;
import model.nested.D;

public class CDMapper implements Mapper<C, D> {

    InternalMapper internalMapper = new InternalMapper();

    class ABConverter implements Converter<A, B> {
        @Override
        public B convert(A source) {
            ABMapper abMapper = new ABMapper();
            B b = abMapper.map(source, B.class);
            return b;
        }
    }

    @Override
    public void map(C source, D target) {
        internalMapper.internalMap(() -> source.getA(), (b) -> target.setB(b), new ABConverter());
        internalMapper.internalMap(() -> source.getA(), (b) -> target.setB(b), (a) -> new ABMapper().map(a, B.class));
    }

    @Override
    public D map(C source, Class<D> targetClass) {
        return internalMapper.map(source, targetClass, this);
    }
}
