package com.island.springscheduling.component;

import com.island.springscheduling.config.SpringSchedulingConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private SpringSchedulingConfig springSchedulingConfig;

    @Scheduled(fixedRateString = "${fixedRate.in.milliseconds}")
    public void timerRate() {
        if(springSchedulingConfig.isEnabled()) {
            System.out.println(dateFormat.format(new Date()));
        }
    }

    //Delay 1 second at first time.
    @Scheduled(initialDelay = 1000, fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void timerInit() {
        if(springSchedulingConfig.isEnabled()) {
            System.out.println("init : " + dateFormat.format(new Date()));
        }
    }

    //Executing as cron job.
    @Scheduled(cron = "${cron.expression}")
    public void timerCron() {
        if(springSchedulingConfig.isEnabled()) {
            System.out.println("current time : " + dateFormat.format(new Date()));
        }
    }
}
