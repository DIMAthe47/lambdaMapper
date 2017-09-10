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

//    protected PropertyMapper propertyMapper = new PropertyMapper();

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

    public <P1> void propertyMapWithDefault(Supplier<P1> source, Consumer<P1> target, P1 defaultValue) {
        P1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
            temp = defaultValue;
        }
        try {
            target.accept(temp);
        } catch (NullPointerException e) {
        }
    }

    public <P1, P2> void propertyMapWithDefault(Supplier<P1> source, Consumer<P2> target, Converter<P1, P2> converter, P2 defaultValue) {
        P1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
        }
        P2 temp2 = null;
        try {
            temp2 = converter.convert(temp);
        } catch (Exception e) {
            temp2 = defaultValue;
        }
        try {
            target.accept(temp2);
        } catch (NullPointerException e) {
        }
    }

    public <P1> void propertyMap(Supplier<P1> source, Consumer<P1> target) {
        propertyMapWithDefault(source, target, (P1) null);
    }

    public <P1, P2> void propertyMap(Supplier<P1> source, Consumer<P2> target, Converter<P1, P2> converter) {
        propertyMapWithDefault(source, target, converter, null);
    }

}
