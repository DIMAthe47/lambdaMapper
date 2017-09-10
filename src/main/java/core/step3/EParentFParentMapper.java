package core.step3;

import model.inheritance.EParent;
import model.inheritance.FParent;

public class EParentFParentMapper extends Mapper<EParent, FParent> {

    @Override
    protected void internalForwardMap(EParent source, FParent target) {
        propertyMap(() -> source.getE1(), (s) -> target.setF1(s));
        propertyMap(() -> source.getE2(), (s) -> target.setF2(s));
    }

    @Override
    protected void internalBackwardMap(FParent source, EParent target) {

    }

}
