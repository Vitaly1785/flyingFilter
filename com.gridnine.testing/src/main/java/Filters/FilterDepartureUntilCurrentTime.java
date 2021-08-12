package Filters;

import Flights.Flight;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterDepartureUntilCurrentTime extends FilterDecorator {
    public FilterDepartureUntilCurrentTime(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> addFilter(List<Flight> flights) {
        Set<Flight> flightSet = createFilter(super.addFilter(flights));
        return new ArrayList<>(flightSet);
    }

    public Set<Flight> createFilter(List<Flight> flights) {
        Set<Flight> result = new HashSet<>();
        LocalDateTime currentTime = LocalDateTime.now();

            result = flights.stream().filter(a -> a.getSegments().get(0).getDepartureDate()
                    .isAfter(currentTime)).collect(Collectors.toSet());

        return result;
    }
}
