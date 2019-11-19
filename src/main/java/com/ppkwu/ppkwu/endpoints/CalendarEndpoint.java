package com.ppkwu.ppkwu.endpoints;

import com.ppkwu.ppkwu.services.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@RestController
@RequestMapping("/api/")
public class CalendarEndpoint {

    private CalendarService calendarService;

    @Autowired public CalendarEndpoint(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("weeia-calendar/current-month") public ResponseEntity<?> getCurrentCalendar() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int month = localDate.getMonthValue();
        calendarService.downloadWeeiaPage(month);

        File file = new File("calendar" + month + ".ics");
        Resource fileSystemResource = new FileSystemResource(file);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/calendar")).body(fileSystemResource);
    }

    @GetMapping("weeia-calendar/next-month") public ResponseEntity<?> getNextMontCalendar() {
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int nextMonth = localDate.getMonthValue() + 1;
        calendarService.downloadWeeiaPage(nextMonth);

        File file = new File("calendar" + nextMonth + ".ics");
        Resource fileSystemResource = new FileSystemResource(file);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/calendar")).body(fileSystemResource);
    }
}
