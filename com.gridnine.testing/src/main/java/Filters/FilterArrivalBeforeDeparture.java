package Filters;

import Flights.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterArrivalBeforeDeparture extends FilterDecorator {

    public FilterArrivalBeforeDeparture(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> addFilter(List<Flight> flights) {
        Set<Flight> flightSet = createFilter(super.addFilter(flights));
        return new ArrayList<>(flightSet);
    }

    public Set<Flight> createFilter(List<Flight> flights) {
        Set<Flight> result = new HashSet<>();
        for (int i = 0; i < 1; i++) {
            int finalI = i;
            result = flights.stream().filter(a -> a.getSegments().get(finalI).getArrivalDate()
                    .isAfter(a.getSegments().get(finalI).getDepartureDate())).collect(Collectors.toSet());
        }
        return result;
    }
}

