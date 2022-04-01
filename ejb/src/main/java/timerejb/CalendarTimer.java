package timerejb;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.*;
import java.util.Date;

@Singleton
@Startup
public class CalendarTimer {

    @Resource
    private TimerService timerService;

    @PostConstruct
    private void init() {
        TimerConfig timerConfig = new TimerConfig();
        timerConfig.setInfo("CalendarTimer");
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        scheduleExpression
                .hour("*")
                .minute("*")
                .second("10, 30, 50");
        timerService.createCalendarTimer(scheduleExpression, timerConfig);
    }

    @Timeout
    public void execute(Timer timer) {
        System.out.println("Timer Service: " + timer.getInfo());
        System.out.println("Execution time: " + new Date());
        System.out.println("--------------------------------------");
    }

}
