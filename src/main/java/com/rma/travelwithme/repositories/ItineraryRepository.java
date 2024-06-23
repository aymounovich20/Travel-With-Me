package com.rma.travelwithme.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rma.travelwithme.models.Itinerary;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
    // You can add custom query methods if needed
}

