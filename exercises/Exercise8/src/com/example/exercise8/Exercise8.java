package com.example.exercise8;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;
import java.io.FileReader;
public class Exercise8 {
    public static void printDoc(Document doc) {
        doc.getDocumentElement().normalize();
        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

        NodeList nList = doc.getElementsByTagName("Book");
        System.out.println("----------------------------");

        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            System.out.println("\nCurrent Element :");
            System.out.print(nNode.getNodeName());

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                System.out.println("title : "
                        + eElement
                        .getElementsByTagName("title")
                        .item(0)
                        .getTextContent());
                System.out.println("publishedYear : "
                        + eElement
                        .getElementsByTagName("publishedYear")
                        .item(0)
                        .getTextContent());
                System.out.println("numberOfPages : "
                        + eElement
                        .getElementsByTagName("numberOfPages")
                        .item(0)
                        .getTextContent());
                System.out.println("authors : "
                        + eElement
                        .getElementsByTagName("authors")
                        .item(0)
                        .getTextContent());


            }

        }
    }
    public static  void parseXML() {
        try {
            File inputFile = new File("BookShelf.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            System.out.println("----------------------------");
            System.out.println("original book shelf");
            printDoc(doc);

            File inputFile2 = new File("BookShelf.xml");
            Document doc2 = dBuilder.parse(inputFile2);
            System.out.println("----------------------------");
            System.out.println("add new book");
            Element book = doc2.createElement("Book");

            Element title = doc2.createElement("title");
            title.appendChild(doc2.createTextNode("Book G"));
            book.appendChild(title);

            Element publishedYear = doc2.createElement("publishedYear");
            publishedYear.appendChild(doc2.createTextNode("2022"));
            book.appendChild(publishedYear);

            Element numberOfPages = doc2.createElement("numberOfPages");
            numberOfPages.appendChild(doc2.createTextNode("50"));
            book.appendChild(numberOfPages);

            Element authors = doc2.createElement("authors");
            authors.appendChild(doc2.createTextNode("toutou"));
            book.appendChild(authors);

            doc2.appendChild(book);
            System.out.println("----------------------------");
            System.out.println("new book shelf");
            printDoc(doc2);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void parseJson() {
        try {
            Object obj = new JSONParser().parse(new FileReader("BookShelf.json"));
            JSONArray array = (JSONArray) (((JSONObject)obj).get("BookShelf"));
            System.out.println("----------------------------");
            System.out.println("original book shelf Json");
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj2 = (JSONObject)array.get(i);
                System.out.println(obj2.get("title"));
                System.out.println("title : "
                        + obj2.get("title"));
                System.out.println("publishedYear : "
                        + obj2.get("publishedYear"));
                System.out.println("numberOfPages : "
                        + obj2.get("numberOfPages"));
                System.out.println("authors : "
                        + obj2.get("authors"));
            }

            System.out.println("----------------------------");
            System.out.println("add new book");

            JSONObject objnew = new JSONObject();
            objnew.put("title", "Book G");
            objnew.put("publishedYear",2022);
            objnew.put("numberOfPages", 50);
            JSONArray authornew = new JSONArray();
            authornew.add("toutou");
            authornew.add("gezai");
            objnew.put("authors", authornew);
            array.add(objnew);


            System.out.println("----------------------------");
            System.out.println("new book shelf Json");
            for (int i = 0; i < array.size(); i++) {
                JSONObject obj2 = (JSONObject)array.get(i);
                System.out.println(obj2.get("title"));
                System.out.println("title : "
                        + obj2.get("title"));
                System.out.println("publishedYear : "
                        + obj2.get("publishedYear"));
                System.out.println("numberOfPages : "
                        + obj2.get("numberOfPages"));
                System.out.println("authors : "
                        + obj2.get("authors"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        parseXML();
        parseJson();
    }
}
