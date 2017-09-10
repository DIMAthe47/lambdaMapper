package core.base;

@FunctionalInterface
public interface Converter<S, T> {
    T convert(S source);
}
