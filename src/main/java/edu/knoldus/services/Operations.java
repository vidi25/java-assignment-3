package edu.knoldus.services;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Operations {

    /**
     * finds day of week of birth date till today's date.
     *
     * @param birthDate localDate object of birthDate
     * @return List of String of day of week
     */
    public List<String> findDayOfWeekOfBirthDateTillDate(LocalDate birthDate) {

        List<String> dayOfWeekList = new ArrayList<>();
        LocalDate currentDate = LocalDate.now();
        List<LocalDate> dates = Stream.iterate(birthDate, date -> date.plusYears(1))
                .limit(ChronoUnit.YEARS.between(birthDate, currentDate))
                .collect(Collectors.toList());
        dates.forEach(date -> dayOfWeekList.add(date.getDayOfWeek().name()));
        return dayOfWeekList;
    }

    /**
     * finds all leap years since 1900.
     *
     * @return list of Integer of leap years
     */
    public List<Integer> findAllLeapYearsFrom1900() {

        List<Integer> leapYearsList = new ArrayList<>();
        LocalDate startDate = LocalDate.of(1900, 01, 01);
        LocalDate endDate = LocalDate.now();
        List<LocalDate> dates = Stream.iterate(startDate, date -> date.plusYears(1))
                .limit(ChronoUnit.YEARS.between(startDate, endDate))
                .collect(Collectors.toList());
        dates.forEach(date -> {
            if (date.isLeapYear()) {
                leapYearsList.add(date.getYear());
            }
        });
        return leapYearsList;
    }

    /**
     * calculates current time of a particular timezone.
     *
     * @param timeZone String of timezone
     * @return String of current time
     */
    public String getTimeFromTimeZone(String timeZone) {

        ZoneId zoneId = ZoneId.of(timeZone);
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
        return ZonedDateTime.of(currentDateAndTime, zoneId).format(TIME_FORMAT);
    }

    /**
     * calculates number of seconds GandhiJi lived.
     *
     * @return seconds of Long type
     */
    public Long getSecondsGandhiJiLived() {

        LocalDate birthDate = LocalDate.of(1869, 10, 2);
        LocalDate deathDate = LocalDate.of(1948, 1, 30);
        return Duration.between(birthDate.atStartOfDay(), deathDate.atStartOfDay()).getSeconds();

    }

}