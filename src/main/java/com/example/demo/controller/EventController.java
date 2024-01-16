package com.example.demo.controller;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Event;
import com.example.demo.model.EventType;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventService eventService;

    @GetMapping
    public String displayAllEvents(Model model) {
        model.addAttribute("events", eventService.getAllEvents());
        return "events/index";
    }

    @GetMapping("/create")
    public String renderCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", EventType.values());
        return "events/create";
    }

    @PostMapping("/create")
    public String processCreateEventForm(@ModelAttribute Event newEvent) {

        EventDto eventDto = eventService.createEvent(newEvent);
        return "redirect:/events";
    }

    @GetMapping("/delete")
    public String renderDeleteEventForm(Model model) {
        model.addAttribute("title", "Delete Events");
        model.addAttribute("events", eventService.getAllEvents());
        return "events/delete";
    }

    @PostMapping("/delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if (eventIds != null) {
            for (int id : eventIds) {
                eventService.deleteById(id);
            }
        }
        return "redirect:/events";
    }
}
