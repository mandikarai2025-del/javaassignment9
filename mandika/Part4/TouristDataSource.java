package javaassignment9.mandika.Part4;

import java.util.List;

class DataSourceAccessException extends Exception {
    public DataSourceAccessException(String message) {
        super(message);
    }
}

abstract class TouristDataSource {

    String sourceName;

    public TouristDataSource(String sourceName) {
        this.sourceName = sourceName;
    }

    abstract List<String> fetchData() throws DataSourceAccessException;
}