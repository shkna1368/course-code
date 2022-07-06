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
//         "0 0 * * * *" = the top of every hour of every day.
    //       "*/10 * * * * *" = every ten seconds.
//            "0 0 8-10 * * *" = 8, 9 and 10 o'clock of every day.
       //     "0 0 8,10 * * *" = 8 and 10 o'clock of every day.
         //    "0 0/30 8-10 * * *" = 8:00, 8:30, 9:00, 9:30 and 10 o'clock every day.
         //   "0 0 9-17 * * MON-FRI" = on the hour nine-to-five weekdays
         //   "0 0 0 25 12 ?" = every Christmas Day at midnight



    @Scheduled(cron = "*/10 * * * * *")
    public void scheduleTaskUsingCronExpression() {

        long now = System.currentTimeMillis() / 1000;
        System.out.println(
                "schedule tasks using cron jobs - " + now);
    }

}
