import org.w3c.dom.DOMStringList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.sql.rowset.spi.XmlWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        File xml = new File("C:\\Users\\NT\\IdeaProjects\\_18_HM\\XML.xml");
        BufferedWriter valid = new BufferedWriter(new FileWriter("Test"));
        if (!xml.exists()) {
            System.out.println("такого файла нет");
        }
        if (!xml.canRead()) {
            System.out.println("файл нельзя прочесть");
        }
        try {

            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("C:\\Users\\NT\\IdeaProjects\\_18_HM\\XML.xml");
            Node root = document.getDocumentElement();
            System.out.println("Shekespere:");
            System.out.println();

            NodeList authors = root.getChildNodes();
            for (int i = 0; i < authors.getLength(); i++) {
                Node author = authors.item(i);
                if (author.getNodeType() != Node.TEXT_NODE) {
                    NodeList authorParams = author.getChildNodes();
                    for (int j = 0; j < authorParams.getLength(); j++) {
                        Node authorsParam = authorParams.item(j);
                        if (authorsParam.getNodeType() != Node.TEXT_NODE) {
                            System.out.println(authorsParam.getNodeName() + ":"
                                    + authorsParam.getChildNodes().item(0).getTextContent());

                            valid.append( authorsParam.getChildNodes().item(0).getTextContent()).append("\n"); }
                    }
                }

                System.out.println();

            }
            valid.close();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            ex.printStackTrace(System.out);
        }

    }



}