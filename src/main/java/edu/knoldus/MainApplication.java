package edu.knoldus;

import edu.knoldus.services.Operations;

import java.time.LocalDate;

public class MainApplication {

    public static void main(String[] args) {

        Operations operations = new Operations();
        LocalDate birthDate = LocalDate.of(1994, 8, 25);
        System.out.println("List of days of week = " + operations.findDayOfWeekOfBirthDateTillDate(birthDate));
        System.out.println("List of leap years = " + operations.findAllLeapYearsFrom1900());
        System.out.println("Time of zone America = " + operations.getTimeFromTimeZone("America/New_York"));
        System.out.println("Number of seconds Mahatma Gandhi lived = " + operations.getSecondsGandhiJiLived());
    }
}
