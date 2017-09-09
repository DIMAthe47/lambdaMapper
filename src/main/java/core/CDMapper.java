package core;

import model.A;
import model.B;
import model.C;
import model.D;

public class CDMapper extends Mapper<C, D> {

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
        internalMap(() -> source.getA(), (b) -> target.setB(b), new ABConverter());
        internalMap(() -> source.getA(), (b) -> target.setB(b), (a) -> new ABMapper().map(a, B.class));
    }
}
