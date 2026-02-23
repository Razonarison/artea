package mg.tana.location.application.service;

import java.lang.reflect.Field;
import java.util.*;

public final class Util {

    public static List<String> getClassFieldsString(Class<?> type) throws IllegalAccessException {
        if (type == null) return Collections.emptyList();
        List<Class<?>> hierarchy = new ArrayList<>();
        for (Class<?> c = type; c != null && c != Object.class; c = c.getSuperclass()) {
            hierarchy.add(c);
        }
        Collections.reverse(hierarchy);

        List<String> result = new ArrayList<>();
        for (Class<?> c : hierarchy) {
            for (Field f : c.getDeclaredFields()) {
                f.setAccessible(true);

                if (f.getName().startsWith("$$")) {
                    continue;
                }

                if (f.isAnnotationPresent(ChampLibelle.class)) {
                    result.add(f.getAnnotation(ChampLibelle.class).value());
                } else {
                    result.add(f.getName());
                }

            }
        }

        return result;
    }

}
