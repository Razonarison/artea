package mg.tana.location;

import mg.tana.location.application.service.Util;
import mg.tana.location.domain.model.User;

import java.util.List;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        User u = new User();
        List<String> fields = Util.getClassFieldsString(User.class);
        for (String s : fields) {
            System.out.println(s);
        }

    }

}
