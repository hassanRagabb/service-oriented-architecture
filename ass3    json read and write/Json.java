
package json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.parser.*;
import org.json.simple.JSONObject;
public class Json {

    public static void main(String[] args) throws IOException, ParseException, JSONException {
        boolean flag =true;
        int choise =-1;
        Scanner scan = new Scanner(System.in);
        Scanner string_scan = new Scanner(System.in);
        while (flag){
            System.out.println("JSON Operation Menu:");
            System.out.println("====================");
            System.out.println("1-Add Node");
            System.out.println("2-Display All");
            System.out.println("3-Search By City");
            System.out.println("4-Search By FoundationYear");
             System.out.println("5-Search By BlName");

            System.out.print("Enter Your Choice:");
            choise = scan.nextInt();

            switch (choise){
                case 1:
                    AddNode();
                    break;
                case 2:
                    DisplayAll();
                    break;
                case 3:
                    System.out.println("Enter City");
                    Search("City",string_scan.nextLine());
                    break;
                case 4:
                    System.out.println("Enter The FoundationYear");
                    Search("FoundationYear",string_scan.nextLine());
                    break;
                case 5:
                    System.out.println("Enter The BlName");
                    Search("BlName",string_scan.nextLine());
                case 6:
                    flag=false;
                    break;
            }
        }
    }
    public static void AddNode()throws IOException, ParseException, JSONException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\dell\\Documents\\NetBeansProjects\\Json\\src\\json\\data.json"));
        JSONObject jsonFile = (JSONObject) obj;
        JSONObject newNode;// = new JSONObject();
        System.out.print("Enter The Number Of Data: ");
        Scanner int_scanner = new Scanner(System.in);
        Scanner string_scanner = new Scanner(System.in);

        JSONArray myList = new JSONArray();
        myList = (JSONArray)jsonFile.get("Data");

        int num = int_scanner.nextInt();
        for (int i=0;i<num;i++){
            newNode = new JSONObject();
            System.out.println("Enter BlName:");
            newNode.put("BlName",string_scanner.nextLine());

            System.out.println("Enter City:");
            newNode.put("City",string_scanner.nextLine());

            System.out.println("Enter FoundationYear:");
            newNode.put("FoundationYear",string_scanner.nextLine());

            myList.add(newNode);

        }
        jsonFile.put("Data",myList);
        PrintWriter writer = new PrintWriter("C:\\Users\\dell\\Documents\\NetBeansProjects\\Json\\src\\json\\data.json");
        writer.write(jsonFile.toString());

        writer.flush();
        writer.close();
    }
    public static void DisplayAll() throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\dell\\Documents\\NetBeansProjects\\Json\\src\\json\\data.json"));
        JSONObject jsonFile = (JSONObject) obj;
        JSONArray myList = (JSONArray) jsonFile.get("Data");
        String currentKey;
        for(int i = 0; i < myList.size();i++) {
            JSONObject subItem = (JSONObject) myList.get(i);
            Iterator key = subItem.keySet().iterator();
            while(key.hasNext()){
                currentKey = (String) key.next();
                System.out.println(currentKey + " : " + subItem.get(currentKey));
            }
            System.out.println("---------------------");
        }
    }
    public static void Search(String attr , String value) throws IOException, ParseException {
        Object obj = new JSONParser().parse(new FileReader("C:\\Users\\dell\\Documents\\NetBeansProjects\\Json\\src\\json\\data.json"));
        JSONObject jsonFile = (JSONObject) obj;
        JSONArray myList = (JSONArray) jsonFile.get("Data");
        String currentKey;
        boolean flag=false;
        for(int i = 0; i < myList.size();i++) {
            if(flag == true){break;}
            JSONObject subItem = (JSONObject) myList.get(i);
            if(subItem.get(attr).equals(value)){
                Iterator key = subItem.keySet().iterator();
                while(key.hasNext()){
                    currentKey = (String) key.next();
                    System.out.println(currentKey + " : " + subItem.get(currentKey));
                    System.out.println("---------------------");
                }
                flag=true;
            }
            
        }
    }
    
    
    


}

