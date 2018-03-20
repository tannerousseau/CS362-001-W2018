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
        Appt appt1, appt2, appt3, appt4, appt5;
        TimeTable table = new TimeTable();
        GregorianCalendar start = new GregorianCalendar(2018, 4, 3);
        GregorianCalendar end = new GregorianCalendar(2018, 5, 4);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appt1 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt2 = new Appt(13, 10, 3, 4, 2018, "title", "description");
        appt3 = new Appt(14, 10, 3, 4, 2018, "title", "description");
        appt4 = new Appt(15, 10, 3, 4, 2018, "title", "description");
        int [] arr = {3,2,1,0};
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        appts.add(appt4);
        LinkedList<Appt> raw = table.permute(appts,arr);
        String expected = "[" + "\t4/3/2018 at 12:10pm ,title, description\n" +
                ", \t4/3/2018 at 1:10pm ,title, description\n" +
                ", \t4/3/2018 at 2:10pm ,title, description\n" +
                ", \t4/3/2018 at 3:10pm ,title, description\n" +
                "]";
        assertEquals(expected, raw.toString());
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
        Appt appt1, appt2, appt3, appt4, appt5;
        TimeTable table = new TimeTable();
        GregorianCalendar start = new GregorianCalendar(2018, 4, 3);
        GregorianCalendar end = new GregorianCalendar(2018, 5, 4);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appt1 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt2 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt3 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt4 = new Appt(16, 10, 3, 4, 2018, "title", "description");
        appt5 = new Appt(14, 10, 3, 5, 2018, "title", "description");
        int [] arr = {0, 1, 2, 4};
        int [] empty = {};
        appt1.setRecurrence(arr, 1, 1, 6);
        appt2.setRecurrence(empty, 1, 1, 6);
        appt3.setRecurrence(arr, 1, 1, 3);
        appt4.setRecurrence(arr, 2, 1, 6);

        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        appts.add(appt4);
        appts.add(appt5);

        LinkedList<CalDay> list = table.getApptRange(appts, start, end);
        String expected = "[\t --- 4/3/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 4:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/4/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/5/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/6/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/7/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/8/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/9/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/10/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/11/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/12/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/13/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/14/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/15/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/16/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/17/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/18/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/19/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/20/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/21/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/22/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/23/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/24/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 4/25/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/26/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/27/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/28/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/29/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/30/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 4/31/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 12:10pm ,title, description\n" +
                " \n" +
                ", \t --- 5/1/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 5/2/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\n" +
                ", \t --- 5/3/2018 --- \n" +
                " --- -------- Appointments ------------ --- \n" +
                "\t4/3/2018 at 4:10pm ,title, description\n" +
                " \n" + "]";
        assertEquals(expected, list.toString());
    }


    @Test
    public void testDelete() throws Throwable {
        Appt appt1, appt2, appt3, appt4, appt5;
        TimeTable table = new TimeTable();
        GregorianCalendar start = new GregorianCalendar(2018, 4, 3);
        GregorianCalendar end = new GregorianCalendar(2018, 5, 4);
        LinkedList<Appt> appts = new LinkedList<Appt>();
        appt1 = new Appt(12, 10, 3, 4, 2018, "title", "description");
        appt2 = new Appt(16, 10, 3, 4, 2018, "title", "description");
        appt3 = new Appt(2, 10, 3, 4, 2018, "title", "description");
        appt4 = new Appt(16, 10, 3, 4, 2018, "title", "description");
        appt5 = new Appt(-1, 10, 3, 5, 2018, "title", "description");
        LinkedList<Appt> raw = table.deleteAppt(appts, appt1);
        assertEquals(null, raw);
        appts.add(appt1);
        appts.add(appt2);
        appts.add(appt3);
        appts.add(appt4);
        appts.add(appt5);
        String expected = " ";
        raw = table.deleteAppt(appts, appt2);
        expected = "[" + "\t4/3/2018 at 12:10pm ,title, description\n" +
                ", \t4/3/2018 at 2:10am ,title, description\n" +
                ", \t4/3/2018 at 4:10pm ,title, description\n" +
                ", null" + "]";
        assertEquals(expected, raw.toString());
        raw = table.deleteAppt(appts, appt2);
        assertEquals(null, raw);
        raw = table.deleteAppt(null, appt2);
        assertEquals(null, raw);
        raw = table.deleteAppt(appts, appt5);
        assertEquals(null, raw);

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



