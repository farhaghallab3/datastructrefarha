package Medicine;

import java.util.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LinkedList {

    private Node head = null;
    private Node tail = null;
    Scanner sc = new Scanner(System.in);

    public Node CreateNode(int ID, int Quantity, String Name, String Place, double price, String Manufacture) {
        Node node = new Node();
        if (node != null) {
            node.ID = ID;
            node.Quantity = Quantity;
            node.Name = Name;
            node.Place = Place;
            node.price = price;
            node.Manufacture = Manufacture;
           // node.ExpireDate=ExpireDate;

            node.prev = null;
            node.next = null;
        }
        return node;

    }

    public boolean AddNewMedicine(int ID, int Quantity, String Name, String Place, double price, String Manufacture) {
        boolean retval = false;
        Node node = CreateNode(ID, Quantity, Name, Place, price, Manufacture);
        if (node != null) { //Node exists
            if (head == null) { //Empty List
                head = tail = node;
            } else {
                node.prev = tail;
                tail.next = node;
                tail = node;
            }
            retval = true;
        }
        return retval;

    }

    public void PrintAll() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;

        }
    }

    public void PrintMedicineData(String name) {
        Node temp = head;
        temp=searchMedicineName(name);
        System.out.println(temp.toString());

    }

    public void deleteMedicine(String name) {
        if (head.Name.equals(name)) {
            head = head.next;
            head.prev = null;
        } else if (tail.Name.equals(name)) {
            tail = tail.prev;
            tail.next = null;

        } else {
            Node temp = head.next;
            while (temp.next != null) {
                if (temp.Name.equals(name)) {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                temp = temp.next;
            }
        }

    }

    public Node searchMedicineName(String N) {
        Node n;
        n = head;
        while (n != null && !n.Name.equals(N)) {
            n = n.next;

        }
        return n;
    }

    public boolean swap(Node n1, Node n2) {

        if (n1.prev == null) {
            //1st two nodes
            (n2.next).prev = n1;
            n1.next = n2.next;
            n2.next = n1;
            n2.prev = null;
            n1.prev = n2;
            head = n2;
        } else if (n2.next == null) {
            // last two nodes
            (n1.prev).next = n2;
            n2.next = n1;
            n1.next = null;
            n2.prev = n1.prev;
            n1.prev = n2;
            tail = n1;
            return true;
        } else {
            //Default nodes
            (n2.next).prev = n1;
            (n1.prev).next = n2;
            n2.prev = n1.prev;
            n1.next = n2.next;
            n2.next = n1;
            n1.prev = n2;

        }
        return false;
    }

    public void SortbyPrice() {
        Node temp;
        Node temp2;

        for (temp = head; temp != null; temp = temp.next) {
            for (temp2 = head; temp2.next != null; temp2 = temp2.next) {
                if (temp2.price > temp2.next.price) {
                    if (swap(temp2, temp2.next)) {
                        break;
                    }

                }
            }
        }

    }

    public void SortbyQuantity() {
        Node temp;
        Node temp2;

        for (temp = head; temp != null; temp = temp.next) {
            for (temp2 = head; temp2.next != null; temp2 = temp2.next) {
                if (temp2.Quantity > temp2.next.Quantity) {
                    if (swap(temp2, temp2.next)) {
                        break;
                    }

                }
            }
        }

    }

    public void update(String name, int data) {
        //name 
        if (data == 1) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals(name)) {
                System.out.println("Enter the right Name");
                int x = sc.nextInt();
                temp.setID(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }
        //ID
        if (data == 2) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals(name)) {
                System.out.println("Enter the right ID");
                int x = sc.nextInt();
                temp.setID(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }
        //Quantity
        if (data == 3) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals(name)) {
                System.out.println("Enter the right Quantity");
                int x = sc.nextInt();
                temp.setQuantity(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }       
        //place
        if (data == 4) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals(name)) {
                System.out.println("Enter the right Place");
                String x = sc.next();
                temp.setPlace(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }
        //price
        if (data == 5) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals(name)) {
                System.out.println("Enter the right Price");
                double x = sc.nextInt();
                temp.setPrice(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }
         //Manufacture
        if (data == 6) {
            Node temp = head;
            while (!temp.Name.equals (name) && temp != null) {
                temp = temp.next;
            }
            if (temp.Name.equals (name)) {
                System.out.println("Enter the right Manufacture");
                String x = sc.next();
                temp.setManufacture(x);
            }
            if (temp == null) {
                System.out.println("the name you put in has no match in the dataset");
            }
        }

    }

    public double sellMedicine(String name, int Quan) {
        double x = 0;
        //searching for the medicine
        Node temp = head;
        while (!temp.Name.equals (name) && temp != null) {
            temp = temp.next;
        }
        //if we found it
        if (temp.Name.equals(name)) {
            //check if the quantity you have in stock is equale or more than the required amount

            if (temp.Quantity >= Quan) {
                x = temp.getPrice() * Quan;
                //decrease the quantity in the stock
                temp.setQuantity(temp.Quantity - Quan);
            } //if the quantity you have in stock is less than the required amount
            else {
                System.out.println("Only " + temp.Quantity + " of this medicine in the stock");
            }
        }
        if (temp == null) {
            System.out.println("the name you put in has no match in the dataset");
        }
        return x;
    }

}
