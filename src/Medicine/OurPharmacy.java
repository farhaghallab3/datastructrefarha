package Medicine;

import java.util.*;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OurPharmacy {
    public static LinkedList loadData() {
        JSONParser jsonParser = new JSONParser();
        LinkedList M = new LinkedList();
        try ( FileReader reader = new FileReader("Pharmacy.json")) {

            Object obj = jsonParser.parse(reader);

            JSONArray MedicineList = (JSONArray) obj;

            for (Object o : MedicineList) {
                if (o instanceof JSONObject) {
                    parseMedicineObject((JSONObject) o);
                    String[] med = parseMedicineObject((JSONObject) o);

                    Date date1 = new SimpleDateFormat("dd-MM-yyyy").parse(med[6]);

                    M.AddNewMedicine(
                            Integer.parseInt(med[0]),
                            Integer.parseInt(med[1]),
                            med[2],
                            med[3],
                            Double.parseDouble(med[4]),
                            med[5]);
                }
            }
        } catch (FileNotFoundException m) {
            m.printStackTrace();
        } catch (IOException m) {
            m.printStackTrace();
        } catch (ParseException m) {
            m.printStackTrace();
        } catch (java.text.ParseException ex) {
            Logger.getLogger(OurPharmacy.class.getName()).log(Level.SEVERE, null, ex);
        }
        return M;
    }
    private static String[] parseMedicineObject(JSONObject Medicine) {
        JSONObject MedicineObject = (JSONObject) Medicine.get("Medicine");
        String ID = (String) MedicineObject.get("ID");
        String Quantity = (String) MedicineObject.get("Quantity");
        String Name = (String) MedicineObject.get("Name");
        String Place = (String) MedicineObject.get("Place");
        String Price = (String) MedicineObject.get("Price");
        String Manufacture = (String) MedicineObject.get("Manufacture");
        String ExpireDate = (String) MedicineObject.get("ExpireDate");
        String[] med = {ID, Quantity, Name, Place, Price, Manufacture, ExpireDate};

        return med;
    }
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList Medicine = loadData();
        boolean medd = true;
        String x;
        String y;

        while (medd) {
            System.out.println("Enter 1 to show Medicine \nEnter 2 to print all \nEnter 3 to buy \nEnter 4 to update info \nEnter 5 to start sorting \nEnter 6 to delete a medicine \nEnter 7 to add new medicine \nEnter 0 to Exit");
            x = sc.nextLine();
            y = x.toUpperCase();
            if (y.equals("1")) {
                System.out.println("Enter Medicine's Name:");
                String Name = sc.nextLine();
                Medicine.PrintMedicineData(Name);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("2")) {
                Medicine.PrintAll();
                 System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("3")) {
                System.out.println("Enter Medicine's Name:");
                String Name = sc.next();
                System.out.println("Enter Medicine's Quantity");
                int Quantity = sc.nextInt();
                Medicine.sellMedicine(Name, Quantity);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("4")) {
                System.out.println("Which one to update?");
                String Name = sc.next();
                System.out.println("Enter 1 to update Name: \nEnter 2 to update ID: \nEnter 3 to update Quantity: \nEnter 4 to update Place: \nEnter 5 to update Price: \nEnter 6 to update Manufacture: ");
                int data = sc.nextInt();
                Medicine.update(Name, data);
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("5")) {
                System.out.println("Enter 1 to sort by Price, Enter 2 to sort by Quantity");
                int S = sc.nextInt();
                if (S == 1) {
                    Medicine.SortbyPrice();
                    System.out.println("Done!");
                } else if (S == 2) {
                    Medicine.SortbyQuantity();
                    System.out.println("Done!");
                } else {
                    System.out.println("Error!!");
                }
                 System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("6")) {
                System.out.println("Which one do you want to delete?");
                String Name = sc.next();
                Medicine.deleteMedicine(Name);
                System.out.println("Deleted!");
                  System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("7")) {

                System.out.print("Name: ");
                String Name = sc.next();
                System.out.println("ID: ");
                int ID = sc.nextInt();
                System.out.print("Quantity: ");
                int Quantity = sc.nextInt();
                System.out.print("Place: ");
                String Place = sc.next();
                System.out.print("Price: ");
                double price = sc.nextDouble();
                System.out.print("Manufacture: ");
                String Manufacture = sc.next();
                //System.out.println("Enter Medicine's ExpireDate:");
                // expiredate=sc.nextDate();
                Medicine.AddNewMedicine(ID, Quantity, Name, Place, price, Manufacture);
                System.out.println("Done!");
                  System.out.println("\nPress Enter to continue");
                sc.nextLine();
            } else if (y.equals("0")) {
                System.out.println("<3");
                sc.close();
                medd = false;
            } else {
                System.out.println("not valid");
                System.out.println("\nPress Enter to continue");
                sc.nextLine();
            }
        }
    }
     /*java.util.LinkedList list=new java.util.LinkedList();
        JSONParser jsonp=new JSONParser();
//        JSONArray a = (JSONArray) jsonp.parse(new FileReader("C:\\Users\\Ahmed\\Desktop\\zft.json"));
          try(FileReader reader=new FileReader("C:\\Users\\Ahmed\\Desktop\\zft.json")){
            Object obj=jsonp.parse(reader);
            JSONArray empList=(JSONArray)obj;
            for (int i=0;i<empList.size();i++){
                JSONObject user=(JSONObject) empList.get(i);
                Node n=new Node();
                n.Name=user.get("Name").toString();
                n.Place=user.get("Place").toString();
                n.Type=user.get("Type").toString();
                n.Manufacture=user.get("Manufacture").toString();
                n.id=(int)user.get("medicineID").hashCode();
                n.Quantity=(int)user.get("quantity").hashCode();
                JSONObject us=  (JSONObject) user.get("ExpireDate");
                int Year=(int)us.get("Year").hashCode();
                int Month=(int)us.get("Month").hashCode();
               /* expiredate d=new expiredate(Month,Year);
                n.expireDate=d;*/
               /* n.Price=(long) user.get("Price").hashCode();
                list.add(n);

            }
        }
           catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }

    } */
}
