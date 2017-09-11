package mappers;


import core.base.Mapper;
import model.L;
import model.S;

public class SLMapper extends Mapper<S, L> {
    @Override
    protected void internalForwardMap(S source, L target) {
        propertyMap(source::getLongs, target::getStrings, longNumber -> longNumber.toString());
    }

    @Override
    protected void internalBackwardMap(L source, S target) {
        propertyMap(source::getStrings, target::getLongs, longString -> Long.parseLong(longString));
    }
}
