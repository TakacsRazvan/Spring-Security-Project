package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.dto.RoleDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.Event;
import com.example.demo.model.User;

import java.util.List;

public interface EventService {
    List<EventDto> getAllEvents();
    EventDto createEvent(Event event);

    EventDto updateEvent(Event event);

    void deleteEvent(Event event);
    void deleteById(int id);
    int idFromName(String name);
}
