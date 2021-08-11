package Filters;

import Flights.Flight;

import java.util.List;

public class FilterDecorator implements Filter {
    Filter filter;

    public FilterDecorator(Filter filter) {
        this.filter = filter;
    }

    @Override
    public List<Flight> addFilter(List<Flight> flights) {
        return filter.addFilter(flights);
    }
}
