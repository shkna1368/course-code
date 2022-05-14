package net.javaguides.springboot.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    @Scheduled(fixedRate = 1000)
    public void scheduleFixedRateTask() {
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }
//10:15 AM on the 15th day of every month.
  //  @Scheduled(cron = "0 15 10 15 * M")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }

}
