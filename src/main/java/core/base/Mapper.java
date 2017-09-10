package core.base;


import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Mapper<S, T> {

    public void map(S source, T target) {
        if (parentMapper() != null)
            parentMapper().map(source, target);
        internalForwardMap(source, target);
    }

    protected abstract void internalForwardMap(S source, T target);

    protected abstract void internalBackwardMap(T source, S target);

    protected Mapper<? super S, ? super T> parentMapper() {
        return null;
    }

    protected PropertyMapper propertyMapper = new PropertyMapper();

    public <T1, T2> void propertyMap(Supplier<T1> source, Consumer<T2> target, Converter<T1, T2> converter) {
        propertyMapper.propertyMap(source, target, converter);
    }

    public <T1> void propertyMap(Supplier<T1> source, Consumer<T1> target) {
        propertyMapper.propertyMap(source, target);
    }

    public T map(S source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            this.map(source, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return target;
    }

}
