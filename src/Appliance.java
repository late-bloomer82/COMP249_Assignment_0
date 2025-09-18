public class Appliance {
 private String type;
 private String brand;
 private static long nextSerial= 1000000;
 private final long serial_no;
 private double price;
 private static int count= 0;

 public Appliance(String type, String brand, double price) {
  if (!isValidType(type)) throw new IllegalArgumentException("Invalid type");
  if (price < 1) throw new IllegalArgumentException("Price must be at least $1");
  this.type = type;
  this.brand = brand;
  this.price = price;
  this.serial_no = nextSerial++;
  count++;

 }
 private static final String[] VALID_TYPES = {
         "Fridge", "Air Conditioner", "Washer", "Dryer",
         "Freezer", "Stove", "Dishwasher", "Water Heaters", "Microwave"
 };

// Helper method to validate appliance type
 private boolean isValidType(String type) {
  for (String t : VALID_TYPES) {
   if (t.equalsIgnoreCase(type)) return true;
  }
  return false;
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
