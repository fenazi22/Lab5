package com.example.eventsystem.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class EveSys {
private String  ID , description , capacity;
private LocalDateTime startDate , endDate;
}
