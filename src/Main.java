import com.avigail.remindersystem.dto.Reminder;
import com.avigail.remindersystem.logic.ReminderLogic;

import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws Exception {
        ReminderLogic reminderLogic = new ReminderLogic();

        Date date1 = new Date(2026 - 1900, Calendar.JANUARY, 5, 10, 27);
        Date date2 = new Date(2024- 1900, Calendar.FEBRUARY, 27, 12, 20);
        Date date3 = new Date(2025 - 1900, Calendar.DECEMBER, 20, 12, 0);
        Date date4 = new Date(2030 - 1900, Calendar.APRIL, 20, 12, 0);
        Date date5 = new Date(2010 - 1900, Calendar.DECEMBER, 20, 12, 0);//invalid date test
        Date date6 = new Date(2016 - 1900, Calendar.AUGUST, 20,12 ,0);//invalid date test


        Reminder reminder1 = new Reminder("Reminder to throw trash", date1, false);
        Reminder reminder2 = new Reminder("Don't forget to take your pills", date2, true);
        Reminder reminder3 = new Reminder("BirthDay To my friend ", date3, false);
        Reminder reminder4 = new Reminder("Reminder to make flight online check-in ", date4, true);

        //creating reminders
        reminderLogic.addReminder(reminder1);
        reminderLogic.addReminder(reminder2);
        reminderLogic.addReminder(reminder3);
        reminderLogic.addReminder(reminder4);

        //printing all reminders list
        System.out.println(reminderLogic.getReminders());


    }
}