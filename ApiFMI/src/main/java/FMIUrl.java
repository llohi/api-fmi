/**
 * This class is used to generate the urls to fetch data
 * from the Finnish Meteorological Institute (FMI).
 * @author J.L.
 */
public class FMIUrl {

    static String DETAILED_INSTRUCTIONS = "http://opendata.fmi.fi/wfs?service=WFS&"+
                                          "version=2.0.0&request=describeStoredQueries";
    static String ROOT = "https://opendata.fmi.fi/wfs?request=getFeature&version=2.0.0";

    // delete these later
    static String EXAMPLE_REQUEST_A = "https://opendata.fmi.fi/wfs?request=getFeature&version=2.0.0"+
                                    "&storedquery_id=fmi::observations::weather::simple&bbox=23,61,24,62"+
                                    "&timestep=30&parameters=t2m";

    static String EXAMPLE_REQUEST_B = "https://opendata.fmi.fi/wfs?"+
            "request=getFeature&version=2.0.0&storedquery_id=fmi::forecast::harmonie::surface::point::simple"+
            "&latlon=61.49911,23.79712&timestep=30&starttime=2022-09-08T06:00:00Z&"+
            "&endtime=2022-09-09T06:00:00Z&parameters=temperature,windspeedms";

    /**
     * This method returns an url formatted according to the parameters
     * to fetch data from the FMI api.
     * @param temp does user want temperature data
     * @param obs_wind does user want observed wind data
     * @param obs_cloud does user want observed cloudiness data
     * @param pred_wind does user want predicted wind data
     * @param pred_temp does user want predicted temperature data
     * @param x_min minimum x coordinate
     * @param y_min minimum y coordinate
     * @param x_max maximum x coordinate
     * @param y_max maximum y coordinate
     * @param timestep the timestep that seperates the data
     * @return the formatted url as a String
     */
    static String getURL(boolean temp, boolean obs_wind, boolean obs_cloud,
                         boolean pred_wind, boolean pred_temp,
                         int x_min, int y_min, int x_max, int y_max,
                         int timestep) {
        // TODO: 13.9.2022 Add start_time and end_time parameters

        String url = ROOT;

        // Configure data format
        url += "&storedquery_id=fmi::observations::weather::simple";

        // Add coordinates
        url += "&bbox="+x_min+","+y_min+","+x_max+","+y_max;

        // Add timestep
        url += "&timestep="+timestep;

        // Add parameters
        url += "&parameters=";

        if (temp)
            url += "t2m,";

        if (obs_wind)
            url += "ws_10min,";

        if (obs_cloud)
            url += "n_man,";

        return url.substring(0, url.length() - 1);  // Remove extra comma
    }


}
