package mg.tana.location.application.service;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public final class Util {
    public static final String NUMBER_FORMAT = "#,##0.00";

    public static String formatNumber(BigDecimal numberToFormat) {
        DecimalFormatSymbols decimalFormatSymbols  = DecimalFormatSymbols.getInstance(new Locale("fr", "FR"));
        return new DecimalFormat("#,##0.00", decimalFormatSymbols).format(numberToFormat);
    }

}
