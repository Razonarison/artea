package mg.tana.location;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IllegalAccessException {

        DecimalFormatSymbols decimalFormatSymbols  = DecimalFormatSymbols.getInstance(new Locale("fr", "FR"));
        BigDecimal number = new BigDecimal(121212);
        System.out.println("new DecimalFormat(\"#,##0.00\", decimalFormatSymbols).format(number) = " + new DecimalFormat("#,##0.00", decimalFormatSymbols).format(number));
    }

}
