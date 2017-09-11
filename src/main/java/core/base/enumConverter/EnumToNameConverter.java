package core.base.enumConverter;

import core.base.Converter;

public class EnumToNameConverter implements Converter<Enum<? extends Enum>, String> {

    @Override
    public String convert(Enum<? extends Enum> source) {
        if (source != null)
            return source.name();
        return null;
    }
}
