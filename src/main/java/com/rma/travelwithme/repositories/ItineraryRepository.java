package com.rma.travelwithme.repositories;

import com.rma.travelwithme.models.Itinerary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItineraryRepository extends JpaRepository<Itinerary, Long> {
}

