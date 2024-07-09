package Medicine;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Node {
    public int ID;
    public int Quantity;
    public String Name;
    public  String Place;
    public double price;
    public String Type;
    public Date ExpireDate;
    public  String Manufacture;

    public Date getExpireDate() {
        return ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }

    public int getID() {
        return ID;
    }

    public int getQuantity() {
        return Quantity;
    }

    public String getName() {
        return Name;
    }

    public String getPlace() {
        return Place;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return Type;
    }

    public String getManufacture() {
        return Manufacture;
    }

    public Node next;
    public Node prev;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public void setManufacture(String Manufacture) {
        this.Manufacture = Manufacture;
    }

 
    
    

    public String toString() {
        return "\nMedicine{" +
                "\nID=" + ID +
                ", \nQuantity=" + Quantity +
                ", \nName='" + Name + '\'' +
                ", \nPlace='" + Place + '\'' +
                ", \nprice=" + price +
                ", \nManufacture='" + Manufacture + '\'' +
                '}';
    }
}
