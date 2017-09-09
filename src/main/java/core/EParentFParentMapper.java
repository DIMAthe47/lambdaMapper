package core;

import model.*;

public class EParentFParentMapper extends Mapper<EParent, FParent> {

    @Override
    public void map(EParent source, FParent target) {
        internalMap(() -> source.getE1(), (s) -> target.setF1(s));
        internalMap(() -> source.getE2(), (s) -> target.setF2(s));
    }
}
