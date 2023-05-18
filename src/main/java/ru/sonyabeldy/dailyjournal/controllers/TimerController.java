package ru.sonyabeldy.dailyjournal.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@Controller
@RequestMapping("/timer")
public class TimerController {

    @GetMapping
    public String index() {
        System.out.println("HERE");
        return "timer";
    }
    @PostMapping("/start")
    public String startTimer() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("Start: " + timestamp);
        return "redirect:/timer";
    }

    @PostMapping("/end")
    public String endTimer() {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        System.out.println("End: " + timestamp);
        return "redirect:/timer";
    }
}
