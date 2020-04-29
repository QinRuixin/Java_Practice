package dateTimeDemo;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.lang.System.currentTimeMillis;

/**
 * @author qin
 * @date 2020-04-29
 */
public class LocalDateTimeDemo {

    public static void main(String[] args) {
        LocalDateTime localDateTime1 = LocalDateTime.now();
        System.out.println(localDateTime1);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2020-01-01"+" 12:00:00",dtf);
//        Date date = new Date(currentTimeMillis());
//        LocalDate localDate = LocalDate.now();
//        LocalTime localTime = LocalTime.now();
//        LocalDateTime localDateTime3 = LocalDateTime.of(localDate,localTime);


        System.out.println(localDateTime2);
        System.out.println(localDateTime1.compareTo(localDateTime2));
//        long start = System.currentTimeMillis();
//        int a = 1;
//        for (int i = 0; i < 1000000000; i++) {
//            ++a;
//        }
//        System.out.println(a);
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
    }

}
