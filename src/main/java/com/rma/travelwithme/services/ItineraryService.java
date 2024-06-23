package com.rma.travelwithme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.rma.travelwithme.models.Itinerary;
import com.rma.travelwithme.repositories.ItineraryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ItineraryService {

    @Autowired
    private ItineraryRepository itineraryRepository;

    // Service methods to interact with ItineraryRepository
    public List<Itinerary> getAllItineraries() {
        return itineraryRepository.findAll();
    }
    public Optional<Itinerary> getItineraryById(Long itineraryId) {
        return itineraryRepository.findById(itineraryId);
    }

    public Itinerary createItinerary(Itinerary itinerary) {
        return itineraryRepository.save(itinerary);
    }

    public Itinerary updateItinerary(Long itineraryId, Itinerary itineraryDetails) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
        itinerary.setTitle(itineraryDetails.getTitle());
        itinerary.setDescription(itineraryDetails.getDescription());
        itinerary.setStartDate(itineraryDetails.getStartDate());
        itinerary.setEndDate(itineraryDetails.getEndDate());
        itinerary.setLocation(itineraryDetails.getLocation());
        return itineraryRepository.save(itinerary);
    }

    public void deleteItinerary(Long itineraryId) {
        Itinerary itinerary = itineraryRepository.findById(itineraryId).orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id " + itineraryId));
        itineraryRepository.delete(itinerary);
    }
    // You can add more service methods as needed
}