import Filters.Filter;
import Filters.FilterDepartureUntilCurrentTime;
import Filters.SomeFilter;
import Flights.Flight;
import Flights.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestFilterDepartureUntilCurrentTime {
    private Filter filter;
    private List<Flight> flights;

    @BeforeEach
    public void init() {
        filter = new FilterDepartureUntilCurrentTime(new SomeFilter());
        flights = FlightBuilder.createFlights();
    }


    @Test
    public void testFilter() {
        Assertions.assertNotNull(flights);
        Assertions.assertEquals(5, filter.addFilter(flights).size());
    }
}
