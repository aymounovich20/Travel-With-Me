package com.rma.travelwithme.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
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

