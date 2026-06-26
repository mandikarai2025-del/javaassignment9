package javaassignment9.mandika.Part4;

import java.util.ArrayList;
import java.util.List;

class AuthenticationFailedException extends Exception {
    public AuthenticationFailedException(String message) {
        super(message);
    }
}

public class HotelRegistrationsDataSource extends TouristDataSource {

    
    public HotelRegistrationsDataSource() {
        super("Kathmandu Hotels Registrations");
    }

    @Override
    public List<String> fetchData() throws DataSourceAccessException {

        try {
            if (sourceName.contains("Hotels") && Math.random() < 0.2) {
                throw new AuthenticationFailedException(
                        "Hotel API authentication failed! Did someone forget the password again?");
            }

            List<String> data = new ArrayList<>();
            data.add("Hotel: Yak & Yeti, Guest: Ram Thapa, NP");
            data.add("Hotel: Annapurna, Guest: Alice Smith, AU");

            return data;

        } catch (AuthenticationFailedException e) {
            throw new DataSourceAccessException(
                    "Failed to access hotel registration data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {

        HotelRegistrationsDataSource hotel = new HotelRegistrationsDataSource();

        try {
            List<String> data = hotel.fetchData();

            System.out.println("Data fetched successfully:");
            for (String record : data) {
                System.out.println(record);
            }

        } catch (DataSourceAccessException e) {

            System.out.println("Error: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Reason: " + e.getCause().getMessage());
            }
        }
    }
}