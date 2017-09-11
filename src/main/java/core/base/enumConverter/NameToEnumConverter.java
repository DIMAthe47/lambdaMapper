package core.base.enumConverter;

import core.base.Converter;

public class NameToEnumConverter<T extends Enum<T>> implements Converter<String, Enum<T>> {

    private final Class<T> enumClass;

    public NameToEnumConverter(Class<T> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public T convert(String source) {
        for (T e : enumClass.getEnumConstants()) {
            if (e.name().equals(source))
                return e;
        }
        return null;
    }
}
