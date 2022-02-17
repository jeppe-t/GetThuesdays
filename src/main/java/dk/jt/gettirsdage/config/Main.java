package dk.jt.gettirsdage.config;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Main {

    List<LocalDate> listDaysInMarts = new ArrayList<>();
    LocalDate today = LocalDate.of(2022, 03, 01);
    LocalDate days = today.plusMonths(1);

    //Find days i marts
    public List<LocalDate> daysInMarts() {
        while (today.isBefore(days)) {
            listDaysInMarts.add(today);
            today = today.plusDays(1);
        }
        return listDaysInMarts;
    }
    
    //Convert to stream, loops (Collect days in marts) and prints the result.
    public Stream<LocalDate> toStream() {
        Stream<LocalDate> marts = daysInMarts().stream().filter(n -> n.getDayOfWeek().equals(DayOfWeek.TUESDAY));
        daysInMarts().stream().filter(n -> n.getDayOfWeek().equals(DayOfWeek.TUESDAY)).forEach(System.out::println);
        //Filter koden kan kodes i en Predicate object ligesom nedenstående..
         //Predicate<LocalDate> isWeekday = d -> d.getDayOfWeek().getValue() == weekday;
        //list<Localdate> weekday = listDays.stream().filter(isWeeekday).collect(Collectors.toList());
        return marts;
    }

}
