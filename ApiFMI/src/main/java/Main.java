import data.BsWfsElement;
import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class is used to test the functionality of other classes.
 * @author J.L.
 */
public class Main {
    public static void main(String[] args)
            throws IOException, JDOMException, XPathExpressionException, ParserConfigurationException, SAXException {

        // TEST OBSERVED DATA
        String observedUrl = FMIUrl.getObservedURL(23, 61, 24, 62,             // Coordinates
                                                   "2022-09-13T04:00:00Z",     // Start time
                                                   "2022-09-13T05:00:00Z",     // End time
                                                   60,                         // Timestep
                                                   true, true, true);          // Parameters (temperature, windspeed, cloudiness)
        ArrayList<BsWfsElement> observedData = ServerRequest.getData(observedUrl);
        System.out.println("\n"+"-".repeat(30)+"\nTEST OBSERVED DATA\n"+observedUrl+"\n"+"-".repeat(30)+"\n");
        printData(observedData);

        // TEST FORECAST DATA
        String forecastURL = FMIUrl.getForecastURL(61.49911, 23.78712,
                                                   "2022-09-14T16:00:00Z", "2022-09-14T17:00:00Z",
                                                   60,
                                                   true, true);
        ArrayList<BsWfsElement> forecastData = ServerRequest.getData(forecastURL);
        System.out.println("\n"+"-".repeat(30)+"\nTEST FORECAST DATA\n"+forecastURL+"\n"+"-".repeat(30)+"\n");
        printData(forecastData);


        // TEST STATISTICAL DATA
        String statURL = FMIUrl.getStatURL(23, 61, 25, 62,
                                           "2022-09-13T04:00:00Z", "2022-09-13T04:15:00Z",
                                           true, true, true);
        ArrayList<BsWfsElement> statData = ServerRequest.getData(statURL);
        System.out.println("\n"+"-".repeat(30)+"\nTEST STATISTICAL DATA\n"+statURL+"\n"+"-".repeat(30)+"\n");
        printData(statData);
    }

    static void printData(ArrayList<BsWfsElement> data) {
        int i = 0;
        for (BsWfsElement e : data) {
            System.out.println("Data point " + i + ":");
            System.out.println("\t* Position -> " + Arrays.toString(e.getPos()));
            System.out.println("\t* Time -> " + e.getTime());
            System.out.println("\t* Parameter name -> " + e.getParameter_name());
            System.out.println("\t* Parameter value -> " + e.getParameter_value());
            System.out.println();
            i++;
        }
    }
}
