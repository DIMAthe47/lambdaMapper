package service;

import core.base.Converter;
import model.entity.AbstractEntityWithLongId;

public class EnumServiceConverters {

    EnumService enumService = new EnumService();

    public <T extends AbstractEntityWithLongId> Converter<Long, T> getConverterFromId(Class<T> clazz) {
        return new Converter<Long, T>() {
            @Override
            public T convert(Long source) {
                T t = enumService.getEntityById(source, clazz);
                return t;
            }
        };
    }

    class ConverterFromEntity implements Converter<AbstractEntityWithLongId, Long> {
        @Override
        public Long convert(AbstractEntityWithLongId source) {
            if (source == null)
                return null;
            return source.getId();
        }
    }

    private final ConverterFromEntity converterFromEntity = new ConverterFromEntity();

    public Converter<AbstractEntityWithLongId, Long> getConverterFromEntity() {
        return converterFromEntity;
    }
}
