package core.base;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class PropertyMapper {

    public <T1, T2> void propertyMap(Supplier<T1> source, Consumer<T2> target, Converter<T1, T2> converter) {
        T1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
        }
        T2 temp2 = null;
        try {
            temp2 = converter.convert(temp);
        } catch (NullPointerException e) {
        }
        try {
            target.accept(temp2);
        } catch (NullPointerException e) {
        }
    }

    public <T1> void propertyMap(Supplier<T1> source, Consumer<T1> target) {
        T1 temp = null;
        try {
            temp = source.get();
        } catch (NullPointerException e) {
        }
        try {
            target.accept(temp);
        } catch (NullPointerException e) {
        }
    }
}
