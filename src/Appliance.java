/**
 * -----------------------------------------------------
 * COMP 249
 * Assignment 0
 * Question: Part 1
 * Written by: Ahmad-Radjai Cherifi, 40327936
 * Due Date: September 19th
 * -----------------------------------------------------
 * This program defines an Appliance class for household appliances with the following attributes:
 * a unique serial number, type, brand and price.
 * It tracks the total number of appliances created, and has methods for attribute access, modification, comparison, and display.
 */

public class Appliance {
 private String type;
 private String brand;
 private static long nextSerial= 1000000;
 private final long serial_no;
 private double price;
 private static int count= 0;

 /** Constructor creates object, validates inputs type and sets attributes values */
 public Appliance(String type, String brand, double price) {
  if (!isValidType(type)) throw new IllegalArgumentException("Invalid appliance type");
  if (price < 1) throw new IllegalArgumentException("Price must be at least 1$");

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

/** Helper method to validate appliance type */
 private boolean isValidType(String type) {
  for (String t : VALID_TYPES) {
   if (t.equals(type)) return true;
  }
  return false;
 }


 /** Accessors */
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

 /** Mutators */
 public void setType(String type) {
  if(!isValidType(type)){throw new IllegalArgumentException("Invalid appliance type");}
  this.type = type;
 }

 public void setBrand(String brand) {
  this.brand = brand;
 }

 public void setPrice(double price) {
  if (price < 1) throw new IllegalArgumentException("Price must be at least 1$");
  this.price = price;
 }

 /** Printing the object's information */
 @Override
 public String toString() {
  return "Appliance [Type: " + type +
          ", Brand: " + brand +
          ", Serial: " + serial_no +
          ", Price: $" + price + "]";
 }

/** Static method to track number of created appliances */
 public static int findNumberOfCreatedAppliances(){
 return count;
 }

/** Comparing objects equality */
 public boolean equals(Appliance obj){
  return this.type.equals(obj.type) && this.brand.equals(obj.brand) && this.price == obj.price;
 }
}
