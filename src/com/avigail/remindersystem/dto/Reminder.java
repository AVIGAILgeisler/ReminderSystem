package com.avigail.remindersystem.dto;

import java.util.Date;
import java.util.Objects;
import java.util.TimerTask;

public class Reminder extends TimerTask {
    private String text;
    private Date reminderDate;
    private boolean isUrgency;
    private boolean isShown;

    public Reminder(String text, Date date, boolean isUrgency) {
        this.text = text;
        this.reminderDate = date;
        this.isUrgency = isUrgency;
        this.isShown=false;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getReminderDate() {
        return reminderDate;
    }

    public void setReminderDate(Date date) {
        this.reminderDate = date;
    }

    public boolean isUrgency() {
        return isUrgency;
    }

    public void setUrgency(boolean urgency) {
        isUrgency = urgency;
    }

    public boolean isShown() {
        return isShown;
    }

    public void setShown(boolean shown) {
        isShown = shown;
    }

    @Override
    public String toString() {
        return "Reminder{" +
                "text='" + text + '\'' +
                ", date=" + reminderDate +
                ", isUrgency=" + isUrgency +
                ", isShown=" + isShown +
                '}';
    }

    @Override
    public void run() {
        if (this.isUrgency==true){
            for (int i = 0; i < 3; i++) {
                try {
                    System.out.println(getReminderDate() + " " + text + " " + isShown);
                    Thread.sleep(3000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                isShown=true;
            }
        }
        else {
            System.out.println(getReminderDate() +  ", " + text + ", " + isShown);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reminder reminder = (Reminder) o;
        return text.equals(reminder.text) && reminderDate.equals(reminder.reminderDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, reminderDate);
    }
}
