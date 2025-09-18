public class Appliance {
 private String type;
 private String brand;
 final long serial_no;
 private double price;

  public Appliance(String type, String brand, long serial_no, double price){
   this.type = type;
   this.brand = brand;
   this.serial_no= serial_no;
   this.price = price;


  }
  //Accessors
  public String getType(){
   return this.type;
  }
 public String getBrand(){
  return this.brand;
 }
 public long getSerial_no(){
  return this.serial_no;
 }
 public double getPrice(){
  return this.price;
 }

 //Mutators
 public void setType(String type){
   this.type = type;
 }
 public void setBrand(String brand){
  this.brand = brand;
 }
 public void setPrice(double price){
  this.price = price;
 }

}
