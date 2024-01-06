
package booooooooook;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.w3c.dom.Attr;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Booooooooook {
    static String  filename = "C:\\Users\\dell\\Documents\\NetBeansProjects\\Booooooooook\\src\\booooooooook\\book.xml";
    static DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    public static void main(String[] args) throws SAXException, TransformerException, ParserConfigurationException, IOException {
        boolean flag =true;
        int choise =-1;
        Scanner scan = new Scanner(System.in);
        Scanner string_scan = new Scanner(System.in);
        while (flag){
            System.out.println("XML Operation Menu:");
            System.out.println("====================");
            System.out.println("1-Add Node");
            System.out.println("2-Display All");
            System.out.println("3-Search By Title");
            System.out.println("4-Search By Author");
            System.out.println("5-Search By ID");
            System.out.println("6-Delete By ID");
            System.out.println("7-Exit");

            System.out.print("Enter Your Choice:");
            choise = scan.nextInt();

            switch (choise){
                case 1:
                    addNode();
                    break;
                case 2:
                    DisplayAll();
                    break;
                case 3:
                    System.out.println("Enter Title");
                    SearchByTitle(string_scan.nextLine());
                    break;
                case 4:
                    System.out.println("Enter The Author");
                    SearchByAuthor(string_scan.nextLine());
                    break;
                case 5:
                    System.out.println("Enter ID");
                    SearchByID(string_scan.nextLine());
                case 6:
                        System.out.println("Enter ID");
                        deleteBook(string_scan.nextLine());
                        
                case 7:
                    flag=false;
                    break;
            }
        }
    }
    public static void addNode()
            
    {
        Scanner sc = new Scanner(System.in);
        try {
     DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
     DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
     Document doc = docBuilder.newDocument();

   
     Element rootElement = doc.createElement("Catalogue");
     doc.appendChild(rootElement);
     
     System.out.print("Enter number of Books: ");
     int n = sc.nextInt();
     for(int i=1;i<=n;i++)
     {
    
     Element book = doc.createElement("Book");
     rootElement.appendChild(book);

 

     System.out.print("Enter ID of Book " +i+" :");
     String id = sc.next();
     Attr attr = doc.createAttribute("ID");
     attr.setValue(id);
     book.setAttributeNode(attr);

     
     Element author = doc.createElement("Author");
     System.out.print("Enter the Book Author:");
     String auth = sc.next();
     author.setTextContent(auth);
        book.appendChild(author);
     
     Element title = doc.createElement("Title");
     System.out.print("Enter the Book Title:");
     String tit = sc.next();
     title.setTextContent(tit);
        book.appendChild(title);

     Element genre = doc.createElement("Genre");
     System.out.print("Enter Book Genre:");
     String gn = sc.next();
     genre.setTextContent(gn);
     book.appendChild(genre);

     Element price = doc.createElement("Price");
     System.out.print("Enter the price:");
     String pr = sc.next();
     price.setTextContent(pr);
     book.appendChild(price);
     
     Element date = doc.createElement("Publish_Date");
     System.out.print("Enter the Publish_Date:");
     String dt = sc.next();
     date.setTextContent(dt);
     book.appendChild(date);
             
     Element description = doc.createElement("Description");
     System.out.print("Enter the Description:");
     String des = sc.next();
     description.setTextContent(des);
     book.appendChild(description);


     TransformerFactory transformerFactory = TransformerFactory.newInstance();
     Transformer transformer = transformerFactory.newTransformer();
     transformer.setOutputProperty(OutputKeys.INDENT, "yes");

   
     DOMSource source = new DOMSource(doc);
     StreamResult result = new StreamResult(new File("C:\\Users\\dell\\Documents\\NetBeansProjects\\Booooooooook\\src\\booooooooook\\book.xml"));
     transformer.transform(source, result);
     
     
     
     }
     
     
      

  } catch (Exception e) {
     e.printStackTrace();
  }
    }
    public static void DisplayAll(){
         try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            System.out.println("Root Element: " + doc.getDocumentElement().getNodeName());
            System.out.println("---------------");

            NodeList list = doc.getElementsByTagName("Book");

            for (int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    //Print Data
                    String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String Author = element.getElementsByTagName("Author").item(0).getTextContent();
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String Genre = element.getElementsByTagName("Genre").item(0).getTextContent();
                    String Price = element.getElementsByTagName("Price").item(0).getTextContent();
                    String Publish_Date = element.getElementsByTagName("Publish_Date").item(0).getTextContent();
                    String Description = element.getElementsByTagName("Description").item(0).getTextContent();
                    
                    System.out.println("ID: " + ID);
                    System.out.println("Author: " + Author);
                    System.out.println("Title: " + Title);
                    System.out.println("Genre: " + Genre);
                    System.out.println("Price: " + Price);
                    System.out.println("Publish_Date: " + Publish_Date);
                    System.out.println("Description: " + Description);
                    System.out.println("---------------------");
                }
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void SearchByTitle(String value){
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            NodeList list = doc.getElementsByTagName("Book");
            boolean found =false;
            for (int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("Title").item(0).getTextContent();
                    if(title.equalsIgnoreCase(value)){
                        //Print Data
                        String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String Author = element.getElementsByTagName("Author").item(0).getTextContent();
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String Genre = element.getElementsByTagName("Genre").item(0).getTextContent();
                    String Price = element.getElementsByTagName("Price").item(0).getTextContent();
                    String Publish_Date = element.getElementsByTagName("Publish_Date").item(0).getTextContent();
                    String Description = element.getElementsByTagName("Description").item(0).getTextContent();
                    
                    System.out.println("ID: " + ID);
                    System.out.println("Author: " + Author);
                    System.out.println("Title: " + Title);
                    System.out.println("Genre: " + Genre);
                    System.out.println("Price: " + Price);
                    System.out.println("Publish_Date: " + Publish_Date);
                    System.out.println("Description: " + Description);
                    System.out.println("---------------------");
                        found = true;
                        break;
                    }
                }
            }
            if (found == false){
                System.out.println("Not Found");
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void SearchByAuthor (String value){
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            NodeList list = doc.getElementsByTagName("Book");
            boolean found = false;
            for (int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    String auth = element.getElementsByTagName("Author").item(0).getTextContent();
                    if(auth.equalsIgnoreCase(value)){
                        //Print Data
                        String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String Author = element.getElementsByTagName("Author").item(0).getTextContent();
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String Genre = element.getElementsByTagName("Genre").item(0).getTextContent();
                    String Price = element.getElementsByTagName("Price").item(0).getTextContent();
                    String Publish_Date = element.getElementsByTagName("Publish_Date").item(0).getTextContent();
                    String Description = element.getElementsByTagName("Description").item(0).getTextContent();
                    
                    System.out.println("ID: " + ID);
                    System.out.println("Author: " + Author);
                    System.out.println("Title: " + Title);
                    System.out.println("Genre: " + Genre);
                    System.out.println("Price: " + Price);
                    System.out.println("Publish_Date: " + Publish_Date);
                    System.out.println("Description: " + Description);
                    System.out.println("---------------------");
                        found = true;
                    }
                }
            }
            if(found == false){
                System.out.println("Not Found");
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
       public static void SearchByID (String value){
        try {
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(filename));

            NodeList list = doc.getElementsByTagName("Book");
            Element rootElement = doc.getDocumentElement();
            boolean found = false;
            for (int i=0;i<list.getLength();i++){
                Node node = list.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    
                    String iddd = node.getAttributes().getNamedItem("ID").getNodeValue();
                   
                    if(iddd.equalsIgnoreCase(value)){
                        
                        String ID = node.getAttributes().getNamedItem("ID").getNodeValue();
                    String Author = element.getElementsByTagName("Author").item(0).getTextContent();
                    String Title = element.getElementsByTagName("Title").item(0).getTextContent();
                    String Genre = element.getElementsByTagName("Genre").item(0).getTextContent();
                    String Price = element.getElementsByTagName("Price").item(0).getTextContent();
                    String Publish_Date = element.getElementsByTagName("Publish_Date").item(0).getTextContent();
                    String Description = element.getElementsByTagName("Description").item(0).getTextContent();
                    
                    System.out.println("ID: " + ID);
                    System.out.println("Author: " + Author);
                    System.out.println("Title: " + Title);
                    System.out.println("Genre: " + Genre);
                    System.out.println("Price: " + Price);
                    System.out.println("Publish_Date: " + Publish_Date);
                    System.out.println("Description: " + Description);
                    System.out.println("---------------------");
                        found = true;
                    }
                }
            }
            if(found == false){
                System.out.println("Not Found");
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Booooooooook.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       
       
       public static void deleteBook(String value) {


      String File = filename;
        try {
            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            Document document = documentBuilder.parse(File);
            NodeList Catalogue = document.getElementsByTagName("Book");
            
            for (int i = 0; i < Catalogue.getLength(); i++) {
                Node node = Catalogue.item(i);
                String iddd = node.getAttributes().getNamedItem("ID").getNodeValue();
                if(iddd.equalsIgnoreCase(value))
                {
                Element id = (Element) Catalogue.item(i);
               Element idTag = (Element) id.getElementsByTagName("Author").item(0);
                idTag.getParentNode().getParentNode().removeChild(Catalogue.item(i));
                 
                }
            }
            saveXMLContent(document, File);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    private static void saveXMLContent(Document document, String File) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(File);
            transformer.transform(domSource, streamResult);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    }
       
       
       
    
    
    

