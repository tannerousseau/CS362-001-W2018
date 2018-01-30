package calendar;

import org.junit.Test;

import static org.junit.Assert.*;

public class ApptTest{
    @Test
    public void testMakeAppt(){
        int startHour = 21;
        int startMinute = 30;
        int startDay = 15;
        int startMonth = 01;
        int startYear = 2018;
        String title = "Birthday Party";
        String description = "This is my birthday party.";
        //Construct a new Appointment object with the initial data
        Appt appt = new Appt(startHour,
                startMinute,
                startDay,
                startMonth,
                startYear,
                title,
                description);

        assertTrue(appt.getValid());
        assertEquals(21, appt.getStartHour());
        assertEquals(30, appt.getStartMinute());
        assertEquals(15, appt.getStartDay());
        assertEquals(01, appt.getStartMonth());
        assertEquals(2018, appt.getStartYear());
        assertEquals("Birthday Party", appt.getTitle());
        assertEquals("This is my birthday party.", appt.getDescription());
    }


    @Test
    public void testMinute(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setStartHour(10);
        assertEquals(10, appt.getStartHour());
    }

    @Test
    public void testHour(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 5, "title", "description");
        appt.setStartHour(10);
        assertEquals(10, appt.getStartHour());
    }


    @Test
    public void testDay(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setStartDay(10);
        assertEquals(10, appt.getStartDay());
    }

    @Test
    public void testMonth(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setStartMonth(10);
        assertEquals(10, appt.getStartMonth());
    }

    @Test
    public void testYear(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setStartYear(10);
        assertEquals(10, appt.getStartYear());
    }


    @Test
    public void testTitle(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setTitle("new title");
        String title;
        title = appt.getTitle();
        assertEquals("new title", title);
    }

    @Test
    public void testNullTitle(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setTitle("");
        String title;
        title = appt.getTitle();
        assertEquals("", title);
    }

    @Test
    public void testDescription(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setDescription("new description");
        String title;
        title = appt.getDescription();
        assertEquals("new description", title);
    }

    @Test
    public void testNullDescription(){
        Appt appt;
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setDescription("");
        String title;
        title = appt.getDescription();
        assertEquals("", title);
    }
    @Test
    public void testgetRecurNum(){
        int num = 2;
        Appt appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        int [] arr = new int [0];
        appt.setRecurrence(arr, 1, 1, 1);
        num = appt.getRecurNumber();
        assertEquals(1, num);
    }

    @Test
    public void testRecurBy(){
        Appt appt;
        int num;
        int [] arr = new int [0];
        appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt.setRecurrence(arr, 1, 1, 1);
        num = appt.getRecurBy();
        assertEquals(1, num);
    }


    @Test
    public void testgetRecurDays(){
        Appt appt = new Appt(1, 2, 3, 4, 2018, "title", "description");
        int [] arr = new int [5];
        appt.setRecurrence(arr, 1, 1, 1);
        arr = appt.getRecurDays();
        assertEquals(0, arr[0]);
    }

    @Test
    public void testCompareTo(){
        Appt appt1, appt2;
        appt1 = new Appt(1, 2, 3, 4, 2018, "title", "description");
        appt2 = new Appt(1, 2, 3, 4, 2018, "title", "description");
        assertEquals(0, appt1.compareTo(appt2));
    }


}