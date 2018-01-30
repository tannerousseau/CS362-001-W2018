package calendar;


import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;


public class TimeTableTest {


    @Test
    public void testTimeTable() {
        TimeTable temp;
        temp = new TimeTable();
        assertNotNull(temp);
    }


    @Test
    public void testPermute() throws Throwable {
        LinkedList<Appt> lappt = new LinkedList<Appt>();
        int arr[];
        Appt appt = new Appt(4, 2, 5, 7, 2018, "title", "description");
        Appt appt2 = new Appt(1, 3, 6, 3, 2018, "title", "description");
        CalDay appt3;
        TimeTable tt = new TimeTable();
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt3 = new CalDay(temp);
        lappt.add(appt);
        appt3.addAppt(appt);
        lappt.add(appt2);
        appt3.addAppt(appt2);
        arr = new int[2];
        arr[0] = 1;
        assertNotNull(tt.permute(lappt, arr));
    }


    @Test
    public void testRecur() throws Throwable {
        LinkedList<Appt> lappt = new LinkedList<Appt>();
        Appt appt = new Appt(4, 2, 5, 7, 2018, "title", "description");
        GregorianCalendar start, end, temp;
        CalDay appt2;
        TimeTable tt = new TimeTable();
        start = new GregorianCalendar();
        start.set(GregorianCalendar.DAY_OF_MONTH, 4);
        start.set(GregorianCalendar.MONTH, 1);
        start.set(GregorianCalendar.YEAR, 2018);
        end = new GregorianCalendar();
        end.set(GregorianCalendar.DAY_OF_MONTH, 11);
        end.set(GregorianCalendar.MONTH, 4);
        end.set(GregorianCalendar.YEAR, 2018);
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 11);
        temp.set(GregorianCalendar.MONTH, 6);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        lappt.add(appt);
        appt2.addAppt(appt);
        lappt.add(appt);
        appt2.addAppt(appt);
        assertNotNull(tt.getApptRange(lappt, start, end));
    }

    @Test
    public void testgetApptRange()  throws Throwable  {
        TimeTable table = new TimeTable();
        LinkedList<CalDay> CalDays = new LinkedList<CalDay>();
        LinkedList<Appt> lappts = new LinkedList<Appt>();
        GregorianCalendar start, end;
        Appt appt1 = new Appt(21, 30, 4, 1, 2018, "title", "description");
        lappts.add(appt1);
        start = new GregorianCalendar();
        start.set(GregorianCalendar.DAY_OF_MONTH, 3);
        start.set(GregorianCalendar.MONTH, 1);
        start.set(GregorianCalendar.YEAR, 2018);
        end = new GregorianCalendar();
        end.set(GregorianCalendar.DAY_OF_MONTH, 4);
        end.set(GregorianCalendar.MONTH, 1);
        end.set(GregorianCalendar.YEAR, 2018);
        CalDays = table.getApptRange(lappts, start, end);
        assertEquals(1, CalDays.size());
    }


    @Test
    public void testDelete() throws Throwable {
        LinkedList<Appt> lappt = new LinkedList<Appt>();
        Appt appt = new Appt(4, 2, 5, 7, 2018, "title", "description");
        CalDay appt2;
        TimeTable tt = new TimeTable();
        GregorianCalendar temp;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 4);
        temp.set(GregorianCalendar.MONTH, 1);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        lappt.add(appt);
        appt2.addAppt(appt);
        assertNull(tt.deleteAppt(lappt, appt));
    }


    @Test
    public void testRecurrenceDaily() throws Throwable{
        GregorianCalendar start, end, temp;
        Appt appt;
        CalDay linkedAppt;
        TimeTable time;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.YEAR, 2018);
        temp.set(GregorianCalendar.MONTH, 7);
        temp.set(GregorianCalendar.DAY_OF_MONTH, 30);
        start = new GregorianCalendar();
        start.set(GregorianCalendar.YEAR, 2017);
        start.set(GregorianCalendar.MONTH, 4);
        start.set(GregorianCalendar.DAY_OF_MONTH, 23);
        end = new GregorianCalendar();
        end.set(GregorianCalendar.YEAR, 2018);
        end.set(GregorianCalendar.MONTH, 2);
        end.set(GregorianCalendar.DAY_OF_MONTH, 2);
        linkedAppt = new CalDay(temp);
        appt = new Appt(5, 35, 5,1, 2018, "Date Night", "Gonna be lit");
        int [] falsearr = new int[0];
        appt.setRecurrence(falsearr, 1, 1,1);
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appt);
        linkedAppt.addAppt(appt);
        assertNotNull(time.getApptRange(listAppt,start,end));
    }

    @Test
    public void testRecurrenceWeekly() throws Throwable{
        GregorianCalendar start, end, temp;
        Appt appt;
        CalDay linkedAppt;
        TimeTable time;
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.YEAR, 2018);
        temp.set(GregorianCalendar.MONTH, 7);
        temp.set(GregorianCalendar.DATE, 30);
        start = new GregorianCalendar();
        start.set(GregorianCalendar.YEAR, 2017);
        start.set(GregorianCalendar.MONTH, 4);
        start.set(GregorianCalendar.DATE, 21);
        end = new GregorianCalendar();
        end.set(GregorianCalendar.YEAR, 2018);
        end.set(GregorianCalendar.MONTH, 2);
        end.set(GregorianCalendar.DATE, 15);
        linkedAppt = new CalDay(temp);
        appt = new Appt(5, 35, 5,1, 2018, "Date Night", "Gonna be lit");
        int [] falsearr = new int[0];
        appt.setRecurrence(falsearr, 1, 1,1);
        time = new TimeTable();
        LinkedList<Appt> listAppt = new LinkedList<Appt>();
        listAppt.add(appt);
        linkedAppt.addAppt(appt);
        assertNotNull(time.getApptRange(listAppt,start,end));
    }

    @Test
    public void testRecurrenceMonthly() throws Throwable{
        LinkedList<Appt> lappt = new LinkedList<Appt>();
        Appt appt;
        appt = new Appt(4, 2, 5, 7, 2018, "title", "description");
        GregorianCalendar start, end, temp;
        CalDay appt2;
        TimeTable tt = new TimeTable();
        start = new GregorianCalendar();
        start.set(GregorianCalendar.DAY_OF_MONTH, 4);
        start.set(GregorianCalendar.MONTH, 1);
        start.set(GregorianCalendar.YEAR, 2018);
        end = new GregorianCalendar();
        end.set(GregorianCalendar.DAY_OF_MONTH, 11);
        end.set(GregorianCalendar.MONTH, 4);
        end.set(GregorianCalendar.YEAR, 2018);
        temp = new GregorianCalendar();
        temp.set(GregorianCalendar.DAY_OF_MONTH, 11);
        temp.set(GregorianCalendar.MONTH, 6);
        temp.set(GregorianCalendar.YEAR, 2018);
        appt2 = new CalDay(temp);
        int [] arr = new int[0];
        appt.setRecurrence(arr, 2, 1, 1);
        lappt.add(appt);
        appt2.addAppt(appt);
        assertNotNull(tt.getApptRange(lappt, start, end));
    }

}



