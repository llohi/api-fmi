import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This class is used to test the functionality of other classes.
 * @author J.L.
 */
public class Main {
    public static void main(String[] args)
            throws IOException, ParserConfigurationException, SAXException {


        ServerRequest.getObject(
                FMIUrl.DETAILED_INSTRUCTIONS);

    }
}
