package calendar;

import java.util.Calendar;
import java.util.Random;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import org.junit.Test;


import static org.junit.Assert.*;



/**
 * Random Test Generator  for TimeTable class.
 */

public class TimeTableRandomTest {
	private static final long TestTimeout = 60 * 500 * 1; /* Timeout at 30 seconds */
	private static final int NUM_TESTS=1000;

	/**
	 * Return a randomly selected method to be tests !.
	 */
	public static String RandomSelectMethod(Random random){
		String[] methodArray = new String[] {"getApptRange","deleteAppt"};// The list of the of methods to be tested in the Appt class

		int n = random.nextInt(methodArray.length);// get a random number between 0 (inclusive) and  methodArray.length (exclusive)

		return methodArray[n] ; // return the method name
	}

	/**
     * Generate Random Tests that tests TimeTable Class.
     */
	 @Test
	  public void randomtest()  throws Throwable {
		 long startTime = Calendar.getInstance().getTimeInMillis();
		 long elapsed = Calendar.getInstance().getTimeInMillis() - startTime;


		 System.out.println("Start testing...");

		 try {
			 for (int iteration = 0; elapsed < TestTimeout; iteration++) {
				 Appt bappt = new Appt(0, 0, 1, 1, 0, " ", " ");
			 	 LinkedList<Appt> appts = new LinkedList<Appt>();
				 TimeTable table = new TimeTable();
				 long randomseed = System.currentTimeMillis(); //10
				 //			System.out.println(" Seed:"+randomseed );
				 Random random = new Random(randomseed);

				 for (int i = 0; i < NUM_TESTS; i++) {
					 int startHour = ValuesGenerator.getRandomIntBetween(random, -12, 37);
					 int startMinute = ValuesGenerator.getRandomIntBetween(random, -29, 89);
					 int startDay = ValuesGenerator.getRandomIntBetween(random, -5, 35);
					 int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 12);
					 int startYear = ValuesGenerator.getRandomIntBetween(random, 0, 5000);

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

					 if (!appt.getValid()) {
						 bappt = appt;
					 }
					 appts.add(appt);
				 }

				 for (int i = 0; i < NUM_TESTS; i++) {
					 String methodName = TimeTableRandomTest.RandomSelectMethod(random);
					 GregorianCalendar start, end;
					 Appt temp = null;
					 if (methodName.equals("deleteAppt")) {
						 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
							 int index = ValuesGenerator.getRandomIntBetween(random, 0, appts.size() - 1);
							 temp = appts.get(index);
							 table.deleteAppt(appts, temp);
						 }
						 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
							 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 7) {
								 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
									 temp = null;
								 }
								 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
									 appts = null;
								 }
								 table.deleteAppt(appts, temp);
							 }
							 if (ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
								 table.deleteAppt(appts, bappt);
							 }
						 }
					 }
					 if (methodName.equals("getApptRange")) {
						int startDay = ValuesGenerator.RandInt(random);
						int startMonth = ValuesGenerator.getRandomIntBetween(random, 1, 11);
					 	try{
							if(ValuesGenerator.getRandomIntBetween(random, 0, 10) < 6) {
								start = new GregorianCalendar(startDay, startMonth, ValuesGenerator.RandInt(random));
								end = (GregorianCalendar) start.clone();
								end.add(Calendar.YEAR, ValuesGenerator.RandInt(random));
							}
							else{
								end = new GregorianCalendar(startDay, startMonth, ValuesGenerator.RandInt(random));
								start = (GregorianCalendar) end.clone();
								start.add(Calendar.YEAR, ValuesGenerator.RandInt(random));
							}
					 		table.getApptRange(appts, start, end);
						}catch(DateOutOfRangeException e){

						}
					 }
				 }

				 elapsed = (Calendar.getInstance().getTimeInMillis() - startTime);
				 if ((iteration % 10000) == 0 && iteration != 0)
					 System.out.println("elapsed time: " + elapsed + " of " + TestTimeout);

			 }

			 }catch(NullPointerException e) {

		 	}
	 }
}
