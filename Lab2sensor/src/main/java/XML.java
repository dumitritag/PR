import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class XML extends DefaultHandler{
    private String string;

    public XML(String string) {
        this.string = string;
    }

    public void execute() throws IOException, SAXException, ParserConfigurationException {
        DOMParser parser = new DOMParser();
        parser.parse(new InputSource(new java.io.StringReader(string)));
        Document doc = parser.getDocument();
        String id = doc.getDocumentElement().getAttribute("id");
        String textContent = doc.getDocumentElement().getTextContent();
        int type = Integer.parseInt(textContent.substring(0, 1));
        Double value = Double.parseDouble(textContent.substring(1, textContent.length()));
        switch (type) {
            case 0:
            {
                System.out.println("Temperature:");
                System.out.println("Device: " +id + " - " + value+" °C");
                System.out.println();
                break;
            }
            case 1:
            {
                System.out.println("Humidity");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
            case 2:
            {
                System.out.println("Motion");
                System.out.println("Device: " + id + " - " + value + " m/s");
                System.out.println();
                break;
            }
            case 3:
            {
                System.out.println("Alien Presence");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
            case 4:
            {
                System.out.println("Dark Matter");
                System.out.println("Device: " + id + " - " + value);
                System.out.println();
                break;
            }
        }


    }

}
