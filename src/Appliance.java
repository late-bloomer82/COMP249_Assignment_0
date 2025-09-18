public class Appliance {
 private String type;
 private String brand;
 final long serial_no;
 private double price;
 private static int count= 0;

 public Appliance(String type, String brand, double price) {
  this.type = type;
  this.brand = brand;
  this.serial_no = serial_no;
  this.price = price;
  count++;

 }

 //Accessors
 public String getType() {
  return this.type;
 }

 public String getBrand() {
  return this.brand;
 }

 public long getSerial_no() {
  return this.serial_no;
 }

 public double getPrice() {
  return this.price;
 }

 //Mutators
 public void setType(String type) {
  this.type = type;
 }

 public void setBrand(String brand) {
  this.brand = brand;
 }

 public void setPrice(double price) {
  this.price = price;
 }

 //Printing the object's information
 public String toString() {
  return "Appliance [Type: " + type +
          ", Brand: " + brand +
          ", Serial: " + serial_no +
          ", Price: $" + price + "]";
 }

 public static int findNumberOfCreatedAppliances(){
 return count;
 }

 public boolean equals(Appliance other){
  return this.type.equals(other.type) && this.brand.equals(other.brand) && this.price == other.price;
 }
}
