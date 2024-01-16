package com.example.demo.mapper;

import com.example.demo.dto.EventDto;
import com.example.demo.model.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class EventMapper {

    public EventDto eventEntityToDto(Event event){
        return EventDto.builder()
                .name(event.getName())
                .description(event.getDescription())
                .type(event.getType())
                .contactEmail(event.getContactEmail())
                .build();
    }

    public List<EventDto> eventListEntityToDto(List<Event> events){
        return events.stream()
                .map(event -> eventEntityToDto(event))
                .toList();
    }

    public Event eventDtoToEntity(EventDto eventDto){
        return Event.builder()
                .name(eventDto.name())
                .description(eventDto.description())
                .type(eventDto.type())
                .contactEmail(eventDto.contactEmail())
                .build();
    }

    public List<Event> eventListDtoToEntity(List<EventDto> eventDtos){
        return eventDtos.stream()
                .map(eventDto -> eventDtoToEntity(eventDto))
                .toList();
    }

}
