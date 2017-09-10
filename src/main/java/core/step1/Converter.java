package core.step1;

@FunctionalInterface
public interface Converter<S, T> {
    //    <P extends S> T convert(P source);
    T convert(S source);
}
