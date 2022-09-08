
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import org.w3c.dom.Document;
import javax.xml.parsers.*;
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

    static void getObject(String url) throws ParserConfigurationException, IOException, SAXException {

        Document doc = DocumentBuilderFactory
                        .newInstance()
                        .newDocumentBuilder()
                        .parse(new InputSource(new StringReader(getRawData(url))));


        Element root = doc.getDocumentElement();
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
