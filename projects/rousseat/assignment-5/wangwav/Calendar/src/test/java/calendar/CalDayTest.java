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
        GregorianCalendar temp = new GregorianCalendar();
        CalDay calDay = new CalDay(temp);
        Calendar date = Calendar.getInstance();
        assertEquals(true, calDay.isValid());
        assertEquals(date.get(Calendar.DAY_OF_MONTH), calDay.getDay());
        assertEquals(date.get(Calendar.MONTH), calDay.getMonth());
        assertEquals(date.get(Calendar.YEAR), calDay.getYear());
    }

    @Test
    public void testAddAppt() {
        Appt appt1, appt2, appt3, appt4;
        GregorianCalendar date = new GregorianCalendar(2018, 4, 3);
        CalDay calDay = new CalDay(date);
        appt1 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt2 = new Appt(16, 10, 3, 4, 2018, "title", "description");
        appt3 = new Appt(14, 10, 3, 4, 2018, "title", "description");
        appt4 = new Appt(18, 10, 3, 4, 2018, "title", "description");
        calDay.addAppt(appt1);
        calDay.addAppt(appt2);
        calDay.addAppt(appt3);
        calDay.addAppt(appt4);
        String list = "\t --- 4/3/2018 --- \n" + " --- -------- Appointments ------------ --- \n" + "\t4/3/2018 at 12:10pm ,title, description\n" + " \t4/3/2018 at 2:10pm ,title, description\n" + " \t4/3/2018 at 4:10pm ,title, description\n" + " \t4/3/2018 at 6:10pm ,title, description\n" + " \n";
        assertEquals(list, calDay.toString());
        assertEquals(4, calDay.getSizeAppts());
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
    public void testIterator(){
        CalDay calDay = new CalDay();
        GregorianCalendar date = new GregorianCalendar(2018, 4, 3);
        assertEquals(null, calDay.iterator());
        calDay = new CalDay(date);
        assertEquals(true, calDay.isValid());
        assertNotEquals(null, calDay.iterator());
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