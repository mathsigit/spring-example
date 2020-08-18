package com.island.springscheduling.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

@Component
public class SchedulerAsLongRun {

    /*
    Calling python as script via Process
     */
    @Scheduled(initialDelay = 1000, fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void timerDelay() throws IOException, InterruptedException {
        File file = ResourceUtils.getFile("classpath:script/test.py");
        Process proc = Runtime.getRuntime().exec("python "+file.getAbsolutePath());
        BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
        String line = null;
        while ((line = in.readLine()) != null) {
            System.out.println(line);
        }
        in.close();
        proc.waitFor();
    }
}
