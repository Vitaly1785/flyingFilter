import Filters.*;
import Flights.Flight;
import Flights.FlightBuilder;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        System.out.println(flights);

        Filter arrivalFilter = new FilterArrivalBeforeDeparture(new SomeFilter());
        System.out.println(arrivalFilter.addFilter(flights));

        Filter departureFilter = new FilterDepartureUntilCurrentTime(arrivalFilter);
        System.out.println(departureFilter.addFilter(flights));

        Filter transferFilter = new FilterTransferMoreTwoHours(departureFilter);
        System.out.println(transferFilter.addFilter(flights));
    }
}
