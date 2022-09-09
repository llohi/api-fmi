/**
 * This class is used to generate the urls to fetch data
 * from the Finnish Meteorological Institute (FMI).
 * @author J.L.
 */
public class FMIUrl {

    static String DETAILED_INSTRUCTIONS = "http://opendata.fmi.fi/wfs?service=WFS&"+
                                          "version=2.0.0&request=describeStoredQueries";

    // delete this later
    static String EXAMPLE_REQUEST_A = "https://opendata.fmi.fi/wfs?request=getFeature&version=2.0.0"+
                                    "&storedquery_id=fmi::observations::weather::simple&bbox=23,61,24,62"+
                                    "&timestep=30&parameters=t2m";

    static String EXAMPLE_REQUEST_B = "https://opendata.fmi.fi/wfs?"+
            "request=getFeature&version=2.0.0&storedquery_id=fmi::forecast::harmonie::surface::point::simple"+
            "&latlon=61.49911,23.79712&timestep=30&starttime=2022-09-08T06:00:00Z&"+
            "&endtime=2022-09-09T06:00:00Z&parameters=temperature,windspeedms";

}
