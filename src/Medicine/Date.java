package Medicine;

public class Date {

  
    private int month;
    private int year;

    public Date(int month, int year) {
        
        this.month = month;
        this.year = year;
    }
    public Date(Date d){
     this.month=d.month;
     this.year=d.year;
    }

    @Override
    public String toString() {
        return "ExpireDate{" + ":" + this.month + "/" + this.year + '}';
    }

}

