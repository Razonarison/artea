package mg.tana.location.application.command;

import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Stream;

public final class Util {

    public static List<Field> getClassFields(Class<?> type) {
        if (type == null) return Collections.emptyList();
        List<Class<?>> hierarchy = new ArrayList<>();
        for (Class<?> c = type; c != null && c != Object.class; c = c.getSuperclass()) {
            hierarchy.add(c);
        }
        Collections.reverse(hierarchy);

        List<Field> result = new ArrayList<>();
        for (Class<?> c : hierarchy) {
            for (Field f : c.getDeclaredFields()) {
                f.setAccessible(true);
                result.add(f);
            }
        }

        return result;
    }

}
