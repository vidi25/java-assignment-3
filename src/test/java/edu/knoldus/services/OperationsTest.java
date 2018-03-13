package edu.knoldus.services;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;


public class OperationsTest {

    private static Operations operations;
    @BeforeClass
    public static void setUp(){
     operations = new Operations();
}

@Test
public void shouldReturnLeapYearsFrom1900(){

    List<Integer> expectedResult = Arrays.asList(1904, 1908, 1912, 1916, 1920, 1924, 1928, 1932, 1936, 1940, 1944, 1948, 1952, 1956, 1960, 1964, 1968, 1972, 1976, 1980, 1984, 1988, 1992, 1996, 2000, 2004, 2008, 2012, 2016);
    List<Integer> actualResult = operations.findAllLeapYearsFrom1900();
    assertEquals("Function did not return all valid leap years",actualResult,expectedResult);
}

@Test
public void shouldReturnSecondsGandhiJiLived(){

Long expectedResult = 2471731200L;
Long actualResult = operations.getSecondsGandhiJiLived();
assertEquals("Function did not return correct seconds GandhiJi lived",actualResult,expectedResult);

}

@Test
public void shouldReturnListOfDayOfWeekOfBirthDateTillDate(){
        LocalDate birthDate = LocalDate.of(1994,8,25);
        List<String> expectedResult = Arrays.asList("THURSDAY", "FRIDAY", "SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "FRIDAY", "SATURDAY", "SUNDAY", "MONDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", "SATURDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "SATURDAY", "SUNDAY", "MONDAY", "TUESDAY", "THURSDAY");
        List<String> actualResult = operations.findDayOfWeekOfBirthDateTillDate(birthDate);
        assertEquals("Did not return correct list of day of week",actualResult,expectedResult);
}

@Test
public void shouldReturnCurrentTimeOfATimeZone(){

        String timeZone = "America/New_York";
    final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
        String expectedResult = LocalTime.now().format(TIME_FORMAT);
        String actualResult = operations.getTimeFromTimeZone(timeZone);
        assertEquals("Did not return correct time",actualResult,expectedResult);
}
@AfterClass
    public static void tearDown(){

}
}
