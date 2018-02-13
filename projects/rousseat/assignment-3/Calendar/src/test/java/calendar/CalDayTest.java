package calendar;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalDayTest{

    private LinkedList<Appt> appts;

    @Test
    public void testCalDay(){
        CalDay calDay = new CalDay();
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        calDay = new CalDay(temp);
        assertEquals(4, calDay.getDay());
        assertEquals(1, calDay.getMonth());
        assertEquals(2018, calDay.getYear());
        //assertTrue(calDay.isValid());
    }

    @Test
    public void testAddAppt(){
        Appt appt;
        CalDay appt2;
        appt = new Appt(1, 2, 3, 4, 5, "title", "description");
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        appt2.addAppt(appt);
        assertEquals(1, appt2.getAppts().size());
    }

    @Test
    public void testgetSizeAppts(){
        Appt appt;
        CalDay appt2;
        appt = new Appt(1, 2, 3, 4, 5, "title", "description");
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        appt2.addAppt(appt);
        assertEquals(1, appt2.getSizeAppts());
    }


    @Test
    public void testgetDay(){
        CalDay day;
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        day = new CalDay(temp);
        assertEquals(4, day.getDay());
    }

    @Test
    public void testgetMonth(){
        CalDay day;
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.MONTH, 2);
        day = new CalDay(temp);
        assertEquals(2, day.getMonth());
    }

    @Test
    public void testgetYear(){
        CalDay day;
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.YEAR, 2018);
        day = new CalDay(temp);
        assertEquals(2018, day.getYear());
    }

    @Test
    public void testtoString(){
        Appt appt;
        CalDay appt2;
        appt = new Appt(1, 2, 3, 4, 5, "title", "description");
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        appt2.addAppt(appt);
        assertNotNull(appt2.toString());
    }

}