package com.avigail.remindersystem.comparators;

import com.avigail.remindersystem.dto.Reminder;

import java.util.Comparator;

public class SortByDateComparator implements Comparator<Reminder> {

    @Override
    public int compare(Reminder reminder1, Reminder reminder2) {
        if (reminder1.getReminderDate().getTime()<reminder1.getReminderDate().getTime()){
            return -1;
        }
        else return 1;
    }
}
