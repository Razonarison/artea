package mg.tana.location;

import mg.tana.location.domain.model.User;
import mg.tana.location.web.PageUtil;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        DecimalFormatSymbols decimalFormatSymbols  = DecimalFormatSymbols.getInstance(new Locale("fr", "FR"));
        BigDecimal number = new BigDecimal(121212);
        System.out.println("new DecimalFormat(\"#,##0.00\", decimalFormatSymbols).format(number) = " + new DecimalFormat("#,##0.00", decimalFormatSymbols).format(number));

        Field[] declaredFields = User.class.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            Class<?> fieldType = declaredField.getType();
            String result=fieldType.getName();
            System.out.println(result);
        }
    }

}
