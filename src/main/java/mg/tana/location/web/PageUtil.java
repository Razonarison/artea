package mg.tana.location.web;

import mg.tana.location.application.service.ChampLibelle;
import mg.tana.location.application.service.FormatNumber;
import mg.tana.location.application.service.Util;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.*;

public final class PageUtil {

    public static List<ChampMeta> getChampsMeta(Class<?> type) {
        List<Class<?>> hierarchy = new ArrayList<>();
        for (Class<?> c = type; c != null && c != Object.class; c = c.getSuperclass()) {
            hierarchy.add(c);
        }
        Collections.reverse(hierarchy);

        List<ChampMeta> metas = new ArrayList<>();

        for (Class<?> c : hierarchy) {
            for (Field f : c.getDeclaredFields()) {
                if (f.isSynthetic() || f.getName().startsWith("$$")) continue;

                String label = f.isAnnotationPresent(ChampLibelle.class)
                        ? f.getAnnotation(ChampLibelle.class).value()
                        : f.getName();

                metas.add(new ChampMeta(f.getName(), label));
            }
        }

        return metas;
    }

    public static List<Object> getValues(Object instance, List<ChampMeta> champs) throws IllegalAccessException {
        if (instance == null) return null;

        List<Object> values = new ArrayList<>();
        Class<?> clazz = instance.getClass();
        for(ChampMeta champ : champs) {
            Field f= getField(clazz, champ.fieldName());
            f.setAccessible(true);

            if (f.isAnnotationPresent(FormatNumber.class)) {
                String objectValue = Util.formatNumber((BigDecimal) f.get(instance));
                values.add(objectValue);
            } else if(f.get(instance) == null) {
                values.add("-");
            }else {
                values.add(f.get(instance));
            }
        }

        return values;
    }

    private static Field getField(Class<?> type, String name) {
        for (Class<?> c = type; c != null && c != Object.class; c = c.getSuperclass()) {
            try {
                return c.getDeclaredField(name);
            } catch (NoSuchFieldException ignored) {}
        }

        throw new RuntimeException("Champ introuvable : " + name);
    }


    public static Map<String, Object> makePageList(List<?> entities, Class<?> type) throws IllegalAccessException {
        List<ChampMeta> metas = getChampsMeta(type);

        List<String> headers = metas.stream()
                .map(ChampMeta::fieldLabel)
                .toList();

        List<List<Object>> rows = new ArrayList<>();
        for (Object e : entities) {
            rows.add(getValues(e, metas));
        }

        Map<String, Object> model = new HashMap<>();
        model.put("headers", headers);
        model.put("rows", rows);
        return model;

    }

}
