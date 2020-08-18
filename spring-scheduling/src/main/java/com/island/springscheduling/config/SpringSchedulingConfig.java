package com.island.springscheduling.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSchedulingConfig {
    private String cronExpression;
    private String fixedRate;
    private String fixedDelay;
    private boolean isEnabled;

    @Value("cron.expression")
    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    @Value("fixedRate.in.milliseconds")
    public String getFixedRate() {
        return fixedRate;
    }

    public void setFixedRate(String fixedRate) {
        this.fixedRate = fixedRate;
    }

    @Value("fixedDelay.in.milliseconds")
    public String getFixedDelay() {
        return fixedDelay;
    }

    public void setFixedDelay(String fixedDelay) {
        this.fixedDelay = fixedDelay;
    }

    @Value("${task.enabled:true}")
    public boolean isEnabled() {
        return isEnabled;
    }

}
