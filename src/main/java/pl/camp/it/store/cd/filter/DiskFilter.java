package pl.camp.it.store.cd.filter;

import pl.camp.it.store.cd.model.Artist;
import pl.camp.it.store.cd.model.Genre;

public class DiskFilter {

    private String lastFindPattern;
    private String year;

    public String getLastFindPattern() {
        return lastFindPattern;
    }

    public void setLastFindPattern(String lastFindPattern) {
        this.lastFindPattern = lastFindPattern;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void reset() {
        this.lastFindPattern = null;
        this.year = null;
    }

    @Override
    public String toString() {
        return "DiskFilter{" +
                "lastFindPattern='" + lastFindPattern + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
