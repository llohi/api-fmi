
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

    // TODO: 8.9.2022 getObject function, which turns XML into a class object.

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
