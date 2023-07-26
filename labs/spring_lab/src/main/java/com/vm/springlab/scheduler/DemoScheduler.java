package com.vm.springlab.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
public class DemoScheduler {
    public final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");

    // @Scheduled(initialDelay = 5000, fixedDelay = 1000)
    // @Scheduled(initialDelayString = "${demo-scheduler.initial-delay}", fixedDelayString = "${demo-scheduler.fixed-delay}")

    @Scheduled(cron = "${demo-scheduler.cron}")
    public void backupDepartmentTable(){
        var dateTimeStr = DATE_TIME_FORMATTER.format(LocalDateTime.now());
        var fileName = "department_backup.%s.sql".formatted(dateTimeStr);
        log.warn("Creating department backup file {}", fileName);
    }
}
