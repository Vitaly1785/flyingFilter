package Filters;

import Flights.Flight;

import java.util.List;

public interface Filter {
    List<Flight> addFilter(List<Flight> flights);
}
