package ru.sonyabeldy.dailyjournal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sonyabeldy.dailyjournal.dao.TimerDAO;
import ru.sonyabeldy.dailyjournal.models.Timer;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
@RequestMapping("/timer")
public class TimerController {

    TimerDAO timerDAO;
    Timer timer = new Timer();

    @Autowired
    public TimerController(TimerDAO timerDAO) {
        this.timerDAO = timerDAO;
    }

    @GetMapping
    public String index() {
        System.out.println("HERE");
        return "timer";
    }
    @PostMapping("/start")
    public String startTimer() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());


        timer.setStartTime(timestamp);
        timerDAO.save(timer);

        System.out.println("Start: " + timestamp);
        return "redirect:/timer";
    }

    @PostMapping("/end")
    public String endTimer() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("End: " + timestamp);


        timer.setEndTime(timestamp);
        timerDAO.addEndTime(timer);
        return "redirect:/timer";
    }
}
