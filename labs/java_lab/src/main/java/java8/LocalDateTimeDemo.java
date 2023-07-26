package java8;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

public class LocalDateTimeDemo {

    public static void main(String[] args) {

        {
            //   ********* DATE ********
            //Current Date
            LocalDate today = LocalDate.now();
            System.out.println("Current Date=" + today);

            //Creating LocalDate by providing input arguments
            LocalDate firstDay_2014 = LocalDate.of(2014, Month.JANUARY, 1);
            System.out.println("Specific Date=" + firstDay_2014);


            //Try creating date by providing invalid inputs
            //LocalDate feb29_2014 = LocalDate.of(2014, Month.FEBRUARY, 29);
            //Exception in thread "main" java.time.DateTimeException:
            //Invalid date 'February 29' as '2014' is not a leap year

            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalDate todayKolkata = LocalDate.now(ZoneId.of("Asia/Kolkata"));
            System.out.println("Current Date in IST=" + todayKolkata);

            //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
            //LocalDate todayIST = LocalDate.now(ZoneId.of("IST"));

            //Getting date from the base date i.e 01/01/1970
            LocalDate dateFromBase = LocalDate.ofEpochDay(365);
            System.out.println("365th day from base date= " + dateFromBase);

            LocalDate hundredDay2014 = LocalDate.ofYearDay(2014, 100);
            System.out.println("100th day of 2014=" + hundredDay2014);
        }

        System.out.println("************************************");

        {
            //   ********* Time ********
            //Current Time
            LocalTime time = LocalTime.now();
            System.out.println("Current Time=" + time);

            //Creating LocalTime by providing input arguments
            LocalTime specificTime = LocalTime.of(12, 20, 25, 40);
            System.out.println("Specific Time of Day=" + specificTime);


            //Try creating time by providing invalid inputs
            //LocalTime invalidTime = LocalTime.of(25,20);
            //Exception in thread "main" java.time.DateTimeException:
            //Invalid value for HourOfDay (valid values 0 - 23): 25

            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalTime timeKolkata = LocalTime.now(ZoneId.of("Asia/Kolkata"));
            System.out.println("Current Time in IST=" + timeKolkata);

            //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
            //LocalTime todayIST = LocalTime.now(ZoneId.of("IST"));

            //Getting date from the base date i.e 01/01/1970
            LocalTime specificSecondTime = LocalTime.ofSecondOfDay(10000);
            System.out.println("10000th second time= " + specificSecondTime);
        }


        System.out.println("************************************");


        {
            //   ********* DateTime ********
            //Current Date
            LocalDateTime todayTime = LocalDateTime.now();
            System.out.println("Current DateTime=" + todayTime);

            //Current Date using LocalDate and LocalTime
            todayTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
            System.out.println("Current DateTime=" + todayTime);

            //Creating LocalDateTime by providing input arguments
            LocalDateTime specificDate = LocalDateTime.of(2014, Month.JANUARY, 1, 10, 10, 30);
            System.out.println("Specific Date=" + specificDate);

            //Try creating date by providing invalid inputs
            //LocalDateTime feb29_2014 = LocalDateTime.of(2014, Month.FEBRUARY, 28, 25,1,1);
            //Exception in thread "main" java.time.DateTimeException:
            //Invalid value for HourOfDay (valid values 0 - 23): 25

            //Current date in "Asia/Kolkata", you can get it from ZoneId javadoc
            LocalDateTime todayTimeKolkata = LocalDateTime.now(ZoneId.of("Asia/Kolkata"));
            System.out.println("Current Date in IST=" + todayTimeKolkata);

            //java.time.zone.ZoneRulesException: Unknown time-zone ID: IST
            //LocalDateTime todayIST = LocalDateTime.now(ZoneId.of("IST"));

            //Getting date from the base date i.e 01/01/1970
            LocalDateTime dateTimeFromBase = LocalDateTime.ofEpochSecond(10000, 0, ZoneOffset.UTC);
            System.out.println("10000th second time from 01/01/1970= " + dateTimeFromBase);
        }

        System.out.println("************************************");


        {
            //   *********  Instant *********
            // Unix timestamp (Machine readable time format)

            //Current timestamp
            Instant timestamp = Instant.now();
            System.out.println("Current Timestamp = " + timestamp);

            //Instant from timestamp
            Instant specificInsTime = Instant.ofEpochMilli(timestamp.toEpochMilli());
            System.out.println("Specific Time = " + specificInsTime);

            //Duration example
            Duration thirtyDay = Duration.ofDays(30);
            System.out.println(thirtyDay);
        }


        System.out.println("************************************");


        {
            //   *********  Date API Utilities *********

            LocalDate today = LocalDate.now();

            //Get the Year, check if it's leap year
            System.out.println("Year " + today.getYear() + " is Leap Year? " + today.isLeapYear());

            //Compare two LocalDate for before and after
            System.out.println("Today is before 01/01/2015? " + today.isBefore(LocalDate.of(2015, 1, 1)));

            //Create LocalDateTime from LocalDate
            System.out.println("Current Time=" + today.atTime(LocalTime.now()));

            //plus and minus operations
            System.out.println("10 days after today will be " + today.plusDays(10));
            System.out.println("3 weeks after today will be " + today.plusWeeks(3));
            System.out.println("20 months after today will be " + today.plusMonths(20));

            System.out.println("10 days before today will be " + today.minusDays(10));
            System.out.println("3 weeks before today will be " + today.minusWeeks(3));
            System.out.println("20 months before today will be " + today.minusMonths(20));

            //Temporal adjusters for adjusting the dates
            System.out.println("First date of this month= " + today.with(TemporalAdjusters.firstDayOfMonth()));
            LocalDate lastDayOfYear = today.with(TemporalAdjusters.lastDayOfYear());
            System.out.println("Last date of this year= " + lastDayOfYear);

            Period period = today.until(lastDayOfYear);
            System.out.println("Period Format= " + period);
            System.out.println("Months remaining in the year= " + period.getMonths());
        }


        System.out.println("************************************");


        {
            // ********* Date Parsing and Formatting *********
            //Format examples
            LocalDate date = LocalDate.now();
            //default format
            System.out.println("Default format of LocalDate=" + date);
            //specific format
            System.out.println(date.format(DateTimeFormatter.ofPattern("d::MMM::uuuu")));
            System.out.println(date.format(DateTimeFormatter.BASIC_ISO_DATE));


            LocalDateTime dateTime = LocalDateTime.now();
            //default format
            System.out.println("Default format of LocalDateTime=" + dateTime);
            //specific format
            System.out.println(dateTime.format(DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss")));
            System.out.println(dateTime.format(DateTimeFormatter.BASIC_ISO_DATE));

            Instant timestamp2 = Instant.now();
            //default format
            System.out.println("Default format of Instant=" + timestamp2);

            //Parse examples
            LocalDateTime dt = LocalDateTime.parse("27::Apr::2014 21::39::48",
                    DateTimeFormatter.ofPattern("d::MMM::uuuu HH::mm::ss"));
            System.out.println("Default format after parsing = " + dt);
        }


        System.out.println("************************************");


    }
}
