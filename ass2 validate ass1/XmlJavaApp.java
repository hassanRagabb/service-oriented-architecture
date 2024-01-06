/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmljavaapp;






import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Pattern;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

/**
 *
 * @author Alaa-sabry
 */
public class XmlJavaApp {
    
   // public static boolean is_new = true;// to check if file new or old
    private static final String FILENAME = "D:\\4444444444444444444444\\sna 4\\First_term\\SERVICE ORIENTED ARCH\\assignments\\ass2\\example.xml";
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        int option = 0 ;
		System.out.println("------------------------------");
		System.out.println("Welcome to XML Application");
		System.out.println("1. Add new Books");
		System.out.println("2. Search for a book");
        System.out.println("3. delete book by Id");
        System.out.println("4. Sort book by element");
		Scanner in = new Scanner(System.in);
		option = in.nextInt();
		switch (option) {
			case 1: {
				add_bOOKS();
				break;
			}
			case 2:{
				search_Book();
				break;
			}
			case 3:{
				delete_book();
				break;
			}
			case 4:{
				sort();
				break;
			}
		}
    
    
    
    }
    public static int is_new = 0;
    public static void add_bOOKS() throws Exception  {
    //builderFactory
    System.out.println("enter number of books :");
    Scanner in = new Scanner(System.in);
    int num= in.nextInt();
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();//you can't call static methods
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    //doc
    
    Document xmlDoc=null;//create temp
    //CREATE root
    Element root=null;
    
//    if(is_new==0){//if document is free
//        xmlDoc=docBuilder.newDocument();
//        root=xmlDoc.createElement("Catalogue");
//        xmlDoc.appendChild(root);
//        is_new=1;
//    }
//    else
//    {
        xmlDoc=docBuilder.parse("D:\\4444444444444444444444\\sna 4\\First_term\\SERVICE ORIENTED ARCH\\assignments\\ass2\\example.xml");
        root=xmlDoc.getDocumentElement();
//    }
    for(int i=0;i<num;i++)
    {
         Element book = xmlDoc.createElement("Book");
			      
         Element Author = xmlDoc.createElement("Author");                                   
         Element Title = xmlDoc.createElement("Title");
         Element Genre = xmlDoc.createElement("Genre");
         Element Price = xmlDoc.createElement("Price");
         Element Publish_Date = xmlDoc.createElement("Publish_Date");
         Element Description = xmlDoc.createElement("Description");
         root.appendChild(book);//add book to root(category)
         //book.setAttribute("id", "1002");
         System.out.println("Adding the Book #"+(i+1));
         System.out.println("add Book ID:");
      
         String s=in.nextLine();//for delay
         String ID=in.nextLine();
         Set<String> ids = new HashSet<>();
         for(int l=0;i<10;i++)
         {
         if(ids.add(ID))
         {
        	 book.setAttribute("id", ID);
        	 break;
         }
         else {
          // add returns false if numID is already in the Set
             System.out.println("The Book ID: " +ID+ " already exist.\nEnter New Book ID: ");
             ID=in.nextLine();
         }
         }
         //book.setAttribute("id", in.nextLine());
         
         System.out.println("add the Author: ");
         Author.setTextContent(in.nextLine());
    	 if(Author == null || Author.getTextContent().length() == 0)
    	 {
    		 
    		 for(int k=0;k<10;k++) {
    			 System.out.println("enter ya 8by el author s7: ");
    			 Author.setTextContent(in.nextLine());
    			 if(Author == null || Author.getTextContent().length() == 0)
    			 {continue ;}
    			 else 
    			 {
    				 book.appendChild(Author);
    				 break;}
    		 }
    		 
    	}
    	 if (Pattern.matches("[a-z]+",Author.getTextContent()))
    	 {
    	 for(int y=0;y<10;y++) {
    		 if (Pattern.matches("[a-z]+",Author.getTextContent())) { 
    			  // Do something
    			 // System.out.println("Yes, string contains letters only");
    			  book.appendChild(Author);
    			  break;
    			}else{
    			  System.out.println("please enter the Author name is characters (a-z) only");   
    			  Author.setTextContent(in.nextLine());
    			}
    		 
    	 }
    	 }
    	 else {
    		 book.appendChild(Author);
    	 }
    	 
    	 
//   System.out.println("add the Author: ");
//	 Author.setTextContent(in.nextLine());
//	 if (Author != null ) {
//		 book.appendChild(Author);
//	 }
//	 else {
//		 throw new Exception("Author is null");
//	 }
//   book.appendChild(Author); //add  author to book
         
     System.out.println("add the Title: ");
	 Title.setTextContent(in.nextLine());
	 if(Title == null || Title.getTextContent().length() == 0)
	 {
		 
		 for(int k=0;k<10;k++) {
			 System.out.println("enter ya 8by el title s7: ");
			 Title.setTextContent(in.nextLine());
			 if(Title == null || Title.getTextContent().length() == 0)
			 {continue ;}
			 else 
			 {
				 book.appendChild(Title);
				 break;}
		 }
	 }
	 else {
		 book.appendChild(Title);
	 }
	 //book.appendChild(Title);
         
     System.out.println("add the Genre from list (1)Science (2) Fiction (3)Drama: ");
     Scanner ihh = new Scanner(System.in);
     int p=0;
     while(p!=5) {
     int choose = ihh.nextInt();
		switch (choose) {
			case 1: {
				Genre.setTextContent("Science");
				book.appendChild(Genre);
				p=5;
				break;
			}
			case 2:{
				Genre.setTextContent("Fiction");
				book.appendChild(Genre);
				p=5;
				break;
			}
			case 3:{
				Genre.setTextContent("Drama");
				book.appendChild(Genre);
				p=5;
				break;
			}
			default: {
				System.out.println("please sir , you must add the Genre from list (1)Science (2) Fiction (3)Drama: ");
			}
		}
    
     }
    
         
     System.out.println("enter double Price (000.00): ");
      
      while(true) {
    	  String input = ihh.next();
    	  if(input.length()!=0) {
	    	 double isNum = Double.parseDouble(input);
	         if(isNum == Math.floor(isNum)) {
	             System.out.println("please enter double price");
	              //enter a double again
	             continue;
	         }else {
	        	 Price.setTextContent(input);
	        	 book.appendChild(Price);
	        	 break;
	         }
    	  }
    	  else {
    		  System.out.println("please enter double price");
    	  }
      }	  
//	 Price.setTextContent(in.nextLine());
//	 book.appendChild(Price);
         
     
	 /* Check if date is 'null' */
     while(true) {
    	 System.out.println("add the Publish_Date fromat MM/dd/yyyy: ");
    	 Publish_Date.setTextContent(in.nextLine());
		if (Publish_Date.getTextContent().trim().equals(""))
		{
			continue;
		}
		/* Date is not 'null' */
		else
		{
		    /*
		     * Set preferred date format,
		     * For example MM-dd-yyyy, MM.dd.yyyy,dd.MM.yyyy etc.*/
		    SimpleDateFormat sdfrmt = new SimpleDateFormat("MM/dd/yyyy");
		    sdfrmt.setLenient(false);
		    /* Create Date object
		     * parse the string into date 
	             */
		    try
		    {
		        Date javaDate = sdfrmt.parse(Publish_Date.getTextContent()); 
		        book.appendChild(Publish_Date);
		        break;
		    }
		    /* Date format is invalid */
		    catch (ParseException e)
		    {
		        //System.out.println(strDate+" is Invalid Date format");
		       // return false;
		    	continue;
		    }
//		        Date javaDate = sdfrmt.parse(Publish_Date.getTextContent()); 
//		        //System.out.println(Publish_Date+" is valid date format");
//		        book.appendChild(Publish_Date);
//		        break;
		}
     }
	 //book.appendChild(Publish_Date);
         
     System.out.println("add the Description: ");
	 Description.setTextContent(in.nextLine());
	 book.appendChild(Description);
         
         TransformerFactory transformerFactory = TransformerFactory.newInstance();
	 Transformer transformer = transformerFactory.newTransformer();
         // pretty print
	 transformer.setOutputProperty(OutputKeys.INDENT, "yes");

         DOMSource source = new DOMSource(xmlDoc);
         
         FileOutputStream output = new FileOutputStream("D:\\4444444444444444444444\\sna 4\\First_term\\SERVICE ORIENTED ARCH\\assignments\\ass2\\example.xml");
	 StreamResult result = new StreamResult(output);
         transformer.transform(source, result); 
    }
    
    
    }
    public static void search_Book() throws ParserConfigurationException, SAXException, IOException{
        Scanner in = new Scanner(System.in);
        System.out.println("Enter Title , author , Genre, Price,Publish_Date to search for: ");
        String search = in.nextLine();

        boolean found = false;
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        docFactory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);// process XML securely
        DocumentBuilder db = docFactory.newDocumentBuilder();// parse XML file
        Document doc = db.parse(new File(FILENAME));
        doc.getDocumentElement().normalize();
                  // get <book>
        NodeList list = doc.getElementsByTagName("Book");//to get all items from book(author,title....)
        int counter=0;
        for (int i = 0; i < list.getLength(); i++){
           Node node=list.item(i);//get first book
           if (node.getNodeType() == Node.ELEMENT_NODE){
              Element element = (Element) node;
              // get attribute of book
              String id = element.getAttribute("id");
              //get text
              String Author = element.getElementsByTagName("Author").item(0).getTextContent();
              String Title = element.getElementsByTagName("Title").item(0).getTextContent();
              String Genre = element.getElementsByTagName("Genre").item(0).getTextContent();
              String Price = element.getElementsByTagName("Price").item(0).getTextContent();
              String Publish_Date = element.getElementsByTagName("Publish_Date").item(0).getTextContent();
              String Description = element.getElementsByTagName("Description").item(0).getTextContent();
              if(Author.equalsIgnoreCase(search) || Title.equalsIgnoreCase(search)||Genre.equalsIgnoreCase(search)||Publish_Date.equalsIgnoreCase(search)||Price.equalsIgnoreCase(search)){
                  counter++;
                  System.out.println("book   "+counter);
            	  System.out.println("the Author is: "+Author);
                  System.out.println("the Title is: "+Title);
                  System.out.println("the Genre is: "+Genre);
                  System.out.println("the Price is: "+Price);
                  System.out.println("the Publish_Date is: "+Publish_Date);
                  System.out.println("the Description is: "+Description);
                  System.out.println("\n");
              }

           }
           

       
       
    }
        System.out.println("\n\n Number of found books : " + counter);
    }
    public static void delete_book() throws SAXException, IOException, ParserConfigurationException, TransformerConfigurationException, TransformerException{
            Scanner in = new Scanner(System.in);
            System.out.println("Enter ID of Book: ");
            String search = in.nextLine();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(FILENAME));

            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer tFormer = tFactory.newTransformer();

            NodeList list = doc.getElementsByTagName("Book");//to get all items from book(author,title....)
            for (int i = 0; i < list.getLength(); i++){
               Node node=list.item(i);//get first book
               if (node.getNodeType() == Node.ELEMENT_NODE){
                  Element element = (Element) node;
                  // get attribute of book
                  String id = element.getAttribute("id");
                  //get text
                  if(id.equalsIgnoreCase(search)){
                     element.getParentNode().removeChild(element);
                     //  Normalize the DOM tree to combine all adjacent nodes
                     doc.normalize();
                     Source source = new DOMSource(doc);
                     //Result dest = new StreamResult(System.out);
                     //tFormer.transform(source, dest);
                     tFormer.setOutputProperty(OutputKeys.INDENT, "yes");
                     FileOutputStream output = new FileOutputStream("D:\\4444444444444444444444\\sna 4\\First_term\\SERVICE ORIENTED ARCH\\assignments\\ass2\\example.xml");
                     StreamResult result = new StreamResult(output);
                     tFormer.transform(source, result);

                  }

               }



            }
    }
    public static void sort() throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException {
    	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(FILENAME));
    	Element catalogElem = doc.getDocumentElement();
    	
    	Scanner ihh = new Scanner(System.in);
    	System.out.println("enter the elemet");
    	String sortItem=ihh.nextLine();
    	
    	// Find <book> elements
    	List<Element> bookElems = new ArrayList<>();
    	for (Node child = catalogElem.getFirstChild(); child != null; child = child.getNextSibling())
    	    if (child.getNodeType() == Node.ELEMENT_NODE && child.getNodeName().equals("book"))
    	        bookElems.add((Element) child);

    	// Replace <book> elements with placeholders so interleaved whitespaces can be retained
    	List<Node> placeholders = new ArrayList<>();
    	for (Node bookElem : bookElems) {
    	    Node placeholder = doc.createTextNode("X");
    	    catalogElem.replaceChild(placeholder, bookElem);
    	    placeholders.add(placeholder);
    	}

    	// Sort <book> elements by title
    	
    	bookElems.sort(Comparator.comparing(e -> e.getElementsByTagName(sortItem).item(0).getTextContent()));

    	// Put <book> elements back into XML document
    	for (int i = 0; i < bookElems.size(); i++)
    	    catalogElem.replaceChild(bookElems.get(i), placeholders.get(i));

    	// Print the XML
    	Transformer transformer = TransformerFactory.newInstance().newTransformer();
    	transformer.transform(new DOMSource(doc), new StreamResult(System.out));
    }

    
    
}
