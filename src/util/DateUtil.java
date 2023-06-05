package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {
    public static String now(String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        return dateFormat.format((Calendar.getInstance().getTime()));
    }

    public static String now() {
        return now("yyyy.MM.dd.hh.mm.ss");
    }
}
