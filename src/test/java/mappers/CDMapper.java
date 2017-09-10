package mappers;

import core.base.Converter;
import core.base.Mapper;
import model.simple.A;
import model.simple.B;
import model.nested.C;
import model.nested.D;

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
    protected void internalForwardMap(C source, D target) {
        propertyMap(() -> source.getA(), (b) -> target.setB(b), new ABConverter());
//        propertyMap(() -> source.getA(), (b) -> target.setB(b), (a) -> new ABMapper().map(a, B.class));
    }

    @Override
    protected void internalBackwardMap(D source, C target) {

    }

}
