
import org.jdom2.JDOMException;
import org.jdom2.filter.Filters;
import org.jdom2.input.SAXBuilder;
import org.jdom2.Element;

import org.jdom2.Document;
import org.jdom2.xpath.XPathExpression;
import org.jdom2.xpath.XPathFactory;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.zip.GZIPInputStream;

/**
 * Class used to connect to an API with a web address
 * and extract an object of any type.
 * @author J.L.
 */
public class ServerRequest {

    static void getObject(String url) throws IOException, JDOMException {

        // Create document of the XML from the url
        Document doc = new SAXBuilder().build(new URL(url));
        String query = "//*";
        XPathExpression<Element> xpe = XPathFactory.instance().compile(query, Filters.element());

        /*
        for (Element e : xpe.evaluate(doc)) {
            System.out.println(e.getName()+" has "+e.getChildren().size()+" children.");
        }*/

        printChildren(doc.getRootElement(), 0);
    }

    /**
     * Recursive print function to test XML parsing.
     */
    static void printChildren(Element root, int n) {

        for (Element e : root.getChildren()) {
            System.out.print("\t".repeat(n) + e.getName());
            if (e.getText().trim() != "") {
                System.out.print("  ->  " + e.getText() + "\n");
            } else {
                System.out.println();
            }
            printChildren(e, n+1);
        }
    }

    /**
     * Connect to a URL and return its raw data as a String.
     * @param url The web address to the raw data
     * @return Raw data as a string
     */
    static String getRawData(String url) throws IOException {

        StringBuilder result = new StringBuilder();

        // Configure url connection
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept-Encoding", "gzip");

        // Get gzip stream
        InputStream stream = conn.getInputStream();
        InputStream bodyStream = new GZIPInputStream(stream);

        // Decompress gzip to byte array
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int length;
        while ((length = bodyStream.read(buffer)) > 0)
            outStream.write(buffer, 0, length);

        return outStream.toString(StandardCharsets.UTF_8);
    }
}
