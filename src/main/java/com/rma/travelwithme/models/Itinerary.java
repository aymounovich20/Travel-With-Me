package com.rma.travelwithme.models;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itineraries")
public class Itinerary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itineraryId;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;

    // Getters and setters

    // You can add additional constructors and methods as needed
}

