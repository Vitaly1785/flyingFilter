package Filters;

import Flights.Flight;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FilterTransferMoreTwoHours extends FilterDecorator {
    public FilterTransferMoreTwoHours(Filter filter) {
        super(filter);
    }

    @Override
    public List<Flight> addFilter(List<Flight> flights) {
        Set<Flight> flightSet = createFilter(super.addFilter(flights));
        return new ArrayList<>(flightSet);
    }

    public Set<Flight> createFilter(List<Flight> flights) {
        // the logic is that flights with less than 2 segments do not have transfers, respectively, are cut off by this filter
        Set<Flight> flightSet = flights.stream().filter(a -> a.getSegments().size() >= 2).collect(Collectors.toSet());
        Set<Flight> result = new HashSet<>();

            result = flightSet.stream().filter(a -> a.getSegments().get(1).getArrivalDate()
                            .isBefore(a.getSegments().get(1).getDepartureDate().plusHours(2)))
                    .collect(Collectors.toSet());

        return result;
    }
}
