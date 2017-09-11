package core.base;


import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class Mapper<S, T> {

    public void mapForward(S source, T target) {
        if (parentMapper() != null)
            parentMapper().mapForward(source, target);
        internalForwardMap(source, target);
    }

    public void mapBackward(T source, S target) {
        if (parentMapper() != null)
            parentMapper().mapBackward(source, target);
        internalBackwardMap(source, target);
    }

    protected abstract void internalForwardMap(S source, T target);

    protected abstract void internalBackwardMap(T source, S target);

    protected Mapper<? super S, ? super T> parentMapper() {
        return null;
    }

    public T mapForward(S source, Class<T> targetClass) {
        T target = null;
        try {
            target = targetClass.newInstance();
            this.mapForward(source, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }

    public S mapBackward(T source, Class<S> targetClass) {
        S target = null;
        try {
            target = targetClass.newInstance();
            this.mapBackward(source, target);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }

    //

    public <P1> void propertyMapWithDefault(Supplier<P1> source, Consumer<P1> target, P1 defaultValueForSourceGettersChain) {
        P1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
            temp = defaultValueForSourceGettersChain;
        }
        try {
            target.accept(temp);
        } catch (NullPointerException e) {
        }
    }

    public <P1, P2> void propertyMapWithDefault(Supplier<P1> source, Consumer<P2> target, Converter<P1, P2> converter, P2 defaultValueForSourceGettersChain) {
        P1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
        }
        P2 temp2 = null;
        try {
            temp2 = converter.convert(temp);
        } catch (Exception e) {
            temp2 = defaultValueForSourceGettersChain;
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

    public Converter<S, T> buildForwardConverter(final Class<T> clazz) {
        return new Converter<S, T>() {
            @Override
            public T convert(S source) {
                T t = mapForward(source, clazz);
                return t;
            }
        };
    }

    public Converter<T, S> buildBackwardConverter(final Class<S> clazz) {
        return new Converter<T, S>() {
            @Override
            public S convert(T source) {
                S s = mapBackward(source, clazz);
                return s;
            }
        };
    }
}
