package core.service;

import model.entity.AbstractEntityWithLongId;
import model.entity.Enum1;
import model.entity.Enum2;

import java.util.HashMap;
import java.util.Map;

public class EnumService {

    Map<Class<? extends AbstractEntityWithLongId>, Map<Long, ? extends AbstractEntityWithLongId>> class__id_entity = new HashMap<>();

    <T extends AbstractEntityWithLongId> T getEntityById(Long id, Class<T> clazz) {
        Map<Long, ? extends AbstractEntityWithLongId> id_entity = class__id_entity.get(clazz);
        T entity = (T) id_entity.get(id);
        return entity;
    }

    public EnumService() {
        {
            Enum1[] enums = new Enum1[]{new Enum1(1L, "name11"), new Enum1(2L, "name12")};
            Map<Long, Enum1> id_entity = new HashMap<>();
            for (Enum1 enum1 : enums) {
                id_entity.put(enum1.getId(), enum1);
            }
            class__id_entity.put(Enum1.class, id_entity);
        }
        {
            Enum2[] enums = new Enum2[]{new Enum2(1L, "name21"), new Enum2(2L, "name22")};
            Map<Long, Enum2> id_entity = new HashMap<>();
            for (Enum2 enum2 : enums) {
                id_entity.put(enum2.getId(), enum2);
            }
            class__id_entity.put(Enum2.class, id_entity);
        }
    }
}
