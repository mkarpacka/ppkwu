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

@RestController
@RequestMapping("/api/")
public class CalendarEndpoint {

    private CalendarService calendarService;

    @Autowired public CalendarEndpoint(CalendarService calendarService) {
        this.calendarService = calendarService;
    }

    @GetMapping("get-weeia") public ResponseEntity<?> getWeeia() {

        calendarService.downloadWeeiaPage();

        File file = new File("calendar" + calendarService.month + ".ics");
        Resource fileSystemResource = new FileSystemResource(file);
        return ResponseEntity.ok().contentType(MediaType.parseMediaType("text/calendar")).body(fileSystemResource);
    }
}
