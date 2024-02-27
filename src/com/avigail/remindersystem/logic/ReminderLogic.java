package com.avigail.remindersystem.logic;

import com.avigail.remindersystem.comparators.SortByDateComparator;
import com.avigail.remindersystem.dto.Reminder;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class ReminderLogic {
    private Set<Reminder> reminders;
    private Timer timer;

    public ReminderLogic() {
        this.reminders = new HashSet<>();
        this.timer = new Timer();
    }
    //function that creates a reminder - works!//
    public void addReminder(Reminder reminder) throws Exception {
        isDateLegal(reminder);
        timer.schedule(reminder, reminder.getReminderDate());
        this.reminders.add(reminder);
    }

    public List<Reminder> getReminders(){
        List<Reminder> reminders= organizeRemindersList(this.reminders);
        return reminders;
    }

   //function that get a set of reminders, and return new organized by date List (oldest to newest) - works!//
    private List<Reminder> organizeRemindersList(Set<Reminder> reminders){
        //transferring reminders set to list(organize by date)
        List<Reminder> finalRemindersList = new ArrayList<>(reminders);
        //initialize
        SortByDateComparator sortByDateComparator = new SortByDateComparator();
        //sorting the list by date(earliest to latest)
        Collections.sort(finalRemindersList, sortByDateComparator);

        return finalRemindersList;
    }


    private boolean isDateLegal(Reminder reminder)throws Exception {
        //function to get local date (now)
        Date in = new Date();
        LocalDateTime ldt = LocalDateTime.ofInstant(in.toInstant(), ZoneId.systemDefault());
        Date todayDate = Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant());
        if (reminder.getReminderDate().before(todayDate)){
            throw new Exception("Date isn't legal, it already passed");
        }else {
            return true;
        }
    }
    public void cancelReminders(){
        timer.cancel();
    }

}
