package core.step1;

import core.step1.InternalMapper;
import core.step1.Mapper;
import model.inheritance.EParent;
import model.inheritance.FParent;

public class EParentFParentMapper1 implements Mapper<EParent, FParent> {

    InternalMapper internalMapper = new InternalMapper();

    @Override
    public void map(EParent source, FParent target) {
        internalMapper.internalMap(() -> source.getE1(), (s) -> target.setF1(s));
        internalMapper.internalMap(() -> source.getE2(), (s) -> target.setF2(s));
    }

    @Override
    public FParent map(EParent source, Class<FParent> targetClass) {
        return internalMapper.map(source, targetClass, this);
    }
}
