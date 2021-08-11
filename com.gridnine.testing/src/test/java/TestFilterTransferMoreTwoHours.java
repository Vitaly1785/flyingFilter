import Filters.Filter;
import Filters.FilterTransferMoreTwoHours;
import Filters.SomeFilter;
import Flights.Flight;
import Flights.FlightBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class TestFilterTransferMoreTwoHours {
    private Filter filter;
    private List<Flight> flights;

    @BeforeEach
    public void init() {
        filter = new FilterTransferMoreTwoHours(new SomeFilter());
        flights = FlightBuilder.createFlights();
    }


    @Test
    public void testFilter() {
        Assertions.assertNotNull(flights);
        Assertions.assertEquals(2, filter.addFilter(flights).size());
    }
}
