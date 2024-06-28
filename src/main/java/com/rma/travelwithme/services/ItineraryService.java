package com.rma.travelwithme.services;

import com.rma.travelwithme.models.Itinerary;
import com.rma.travelwithme.repositories.ItineraryRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItineraryService {

    private final ItineraryRepository itineraryRepository;

    public ItineraryService(ItineraryRepository itineraryRepository) {
        this.itineraryRepository = itineraryRepository;
    }

    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }

    public Itinerary getItineraryById(Long itineraryId) {
        return itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
    }

    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public Itinerary updateItinerary(Long itineraryId, Itinerary itineraryDetails) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));

//        itinerary.builder()
//                .title(itineraryDetails.getTitle())
//                .description(itineraryDetails.getDescription())
//                .startDate(itineraryDetails.getStartDate())
//                .endDate(itineraryDetails.getEndDate())
//                .location(itineraryDetails.getLocation())
//                .build();
        return itineraryRepository.save(itinerary);
    }

    public void deleteItinerary(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
        itineraryRepository.delete(itinerary);
    }
}