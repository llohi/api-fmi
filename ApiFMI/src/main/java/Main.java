import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;

/**
 * This class is used to test the functionality of other classes.
 * @author J.L.
 */
public class Main {
    public static void main(String[] args)
            throws IOException, JDOMException, XPathExpressionException, ParserConfigurationException, SAXException {

        // TEST OBSERVED DATA

        ServerRequest.getObservationData(
                FMIUrl.getObservedURL(
                        true, true, true,
                        23, 61, 24, 62,
                        "2022-09-13T04:00:00Z", "2022-09-13T05:00:00Z", 30));


        // TEST FORECAST DATA
        /*
        ServerRequest.getObject(
                FMIUrl.getForecastURL(61.49911, 23.78712,
                        "2022-09-13T10:00:00Z", "2022-09-13T11:00:00Z", 30,
                        true, true));

         */

        // TEST STATISTICAL DATA
        /*
        ServerRequest.getObject(
                FMIUrl.getStatURL(23, 61, 25, 62,
                        "2022-09-13T04:00:00Z", "2022-09-13T05:00:00Z",
                        true, true, true));
        */
    }
}
