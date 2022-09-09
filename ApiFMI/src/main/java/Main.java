import org.jdom2.JDOMException;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * This class is used to test the functionality of other classes.
 * @author J.L.
 */
public class Main {
    public static void main(String[] args)
            throws IOException, JDOMException {


        System.out.println("EXAMPLE_REQUEST_A");
        ServerRequest.getObject(
                FMIUrl.EXAMPLE_REQUEST_A);
        System.out.println("\n"+"_".repeat(30));
        System.out.println("EXAMPLE_REQUEST_B");
        ServerRequest.getObject(
                FMIUrl.EXAMPLE_REQUEST_B);
        System.out.println("\n"+"_".repeat(30));

    }
}
