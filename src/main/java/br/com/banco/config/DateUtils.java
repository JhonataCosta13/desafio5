package br.com.banco.config;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String getCurrentTime(){
        Date time = new Date(System.currentTimeMillis());
        String formatted = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(time);
        return formatted;
    }
}
