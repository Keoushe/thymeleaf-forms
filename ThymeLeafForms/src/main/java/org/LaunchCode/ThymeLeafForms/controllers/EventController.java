package org.LaunchCode.ThymeLeafForms.controllers;

import org.LaunchCode.ThymeLeafForms.data.EventData;
import org.LaunchCode.ThymeLeafForms.models.Event;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

//    private static List<Event> events = new ArrayList<>();

    @GetMapping
    public String handlerOne(Model model){
//        List<String> events = new ArrayList();
//        events.add("Code With Pride");
//        events.add("Strange Code");
//        events.add("Hackathon");
//        model.addAttribute("events",events);
        model.addAttribute("events", EventData.getAll());
        return "events/index";
    }

    // url is /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }


    @PostMapping("create")
    public String createEvent (@ModelAttribute Event newEvent) {
        EventData.add(newEvent);
        return "redirect:";
    }


    @GetMapping("delete")
    public String displayDeleteEventForm(Model model ){
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", EventData.getAll());
        return "events/delete";
    }

    @PostMapping("delete")
    public String processDeleteEventsForm(@RequestParam(required = false) int[] eventIds){
        if(eventIds != null) {
            for (int id : eventIds) {
                EventData.remove(id);
            }
        }
        return "redirect:";
    }
}
