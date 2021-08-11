package Filters;

import Flights.Flight;

import java.util.List;

public class SomeFilter implements Filter{
    @Override
    public List<Flight> addFilter(List<Flight> flights) {
        System.out.println("Create new Filter");
        return flights;
    }

}
