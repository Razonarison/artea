package mg.tana.location;

import mg.tana.location.application.command.Util;
import mg.tana.location.domain.model.User;

import java.lang.reflect.Field;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        User u = new User();
        List<Field> fields = Util.getClassFields(User.class);
        for (Field f : fields) {
            System.out.println(f.getName());
        }

    }

}
