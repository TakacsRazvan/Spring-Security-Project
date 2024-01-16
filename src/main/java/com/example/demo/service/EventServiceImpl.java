package com.example.demo.service;

import com.example.demo.dto.EventDto;
import com.example.demo.mapper.EventMapper;
import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{

    private final EventRepository eventRepository;
    private final EventMapper eventMapper;
    @Override
    public List<EventDto> getAllEvents() {
        return eventMapper.eventListEntityToDto(eventRepository.findAll());
    }

    @Override
    public EventDto createEvent(Event event) {
        return eventMapper.eventEntityToDto(eventRepository.save(event));
    }

    @Override
    public EventDto updateEvent(Event event) {
        return eventMapper.eventEntityToDto(eventRepository.save(event));
    }

    @Override
    public void deleteEvent(Event event) {
        eventRepository.delete(event);
    }

    @Override
    public void deleteById(int id) {
        eventRepository.deleteById(id);
    }

    @Override
    public int idFromName(String name) {
        return eventRepository.idFromName(name);
    }
}
