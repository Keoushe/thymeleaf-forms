package org.LaunchCode.ThymeLeafForms.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("events")
public class EventController {

    public String handlerOne(Model model){
        List<String> events = new ArrayList();
        events.add("Code With Pride");
        events.add("Strange Code");
        events.add("Hackathon");
        model.addAttribute("events",events);
        return "events/index";
    }

    // url is /events/create
    @GetMapping("create")
    public String renderCreateEventForm() {
        return "events/create";
    }

}
