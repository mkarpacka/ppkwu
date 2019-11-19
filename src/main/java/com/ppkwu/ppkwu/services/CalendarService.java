package com.ppkwu.ppkwu.services;

import lombok.NoArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@NoArgsConstructor
public class CalendarService {

    public int month = 11;

    public Ical downloadWeeiaPage() {
        Document doc = null;

        try {
            doc = Jsoup.connect("http://www.weeia.p.lodz.pl/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements active = doc.select("td.active");
        Elements day = active.select("a");
        Elements events = active.select(".calendar-text");

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        month = localDate.getMonthValue();

        List<String> days = new ArrayList<>();
        List<String> eventName = new ArrayList<>();

        for (Element e : day) {
            days.add(e.text());
        }

        for (Element e : events) {
            eventName.add(e.text());
        }

        Ical ical = new Ical();
        ical.write(days, month, eventName);

        return ical;
    }

}
