Question 4:   Inventory management System for a Small Electronics Store using Objects and Classes
Points: 10
Skill Mapping: Intermediate
Description: WAP to implement a command line java application for Inventory management System for a Small Electronics Store using Classes and objects. It should implement functionalities given in below menu - (10 points)
1.	Product List - View list of all Products
2.	Product count - View number of quantities available for a specific Product
3.	View Product details – Product Specification, Cost and count available
4.	Edit Product - Update Product Details
5.	Update Inventory - Add/Delete Product Quantities


Program:

import java.util.Scanner;
import java.util.HashMap;

class Main {
    private String name;
    private String specification;
    private double cost;
    private int quantity;

    public Product(String name, String specification, double cost, int quantity) {
        this.name = name;
        this.specification = specification;
        this.cost = cost;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

public class InventoryObjects {
    private static HashMap<String, Product> inventory = new HashMap<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Product product1 = new Product("Phone", "iPhone 12", 999.99, 10);
        Product product2 = new Product("Laptop", "MacBook Pro", 1499.99, 5);
        Product product3 = new Product("Tablet", "iPad Pro", 799.99, 8);

        inventory.put(product1.getName(), product1);
        inventory.put(product2.getName(), product2);
        inventory.put(product3.getName(), product3);

        int choice = 0;
        do {
            System.out.println("\nInventory Management System Menu");
            System.out.println("1. Product List");
            System.out.println("2. Product Count");
            System.out.println("3. View Product Details");
            System.out.println("4. Edit Product");
            System.out.println("5. Update Inventory");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    productList();
                    break;
                case 2:
                    System.out.print("Enter product name: ");
                    String name = input.next();
                    productCount(name);
                    break;
                case 3:
                    System.out.print("Enter product name: ");
                    name = input.next();
                    viewProductDetails(name);
                    break;
                case 4:
                    System.out.print("Enter product name: ");
                    name = input.next();
                    editProduct(name);
                    break;
                case 5:
                    System.out.print("Enter product name: ");
                    name = input.next();
                    System.out.print("Enter quantity to add/delete: ");
                    int quantity = input.nextInt();
                    updateInventory(name, quantity);
                    break;
                    case 0:
                    System.out.println("Exiting Inventory Management System...");
                    break;
                    default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
                    }
                    } while (choice != 0);
                    }
                    private static void productList() {
                        System.out.println("\nProduct List");
                        System.out.println("--------------------");
                        for (String name : inventory.keySet()) {
                            System.out.println(name);
                        }
                    }
                    
                    private static void productCount(String name) {
                        if (inventory.containsKey(name)) {
                            System.out.println("\nProduct Count");
                            System.out.println("--------------------");
                            System.out.println("Product: " + name);
                            System.out.println("Quantity: " + inventory.get(name).getQuantity());
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                    
                    private static void viewProductDetails(String name) {
                        if (inventory.containsKey(name)) {
                            System.out.println("\nProduct Details");
                            System.out.println("--------------------");
                            System.out.println("Product: " + name);
                            System.out.println("Specification: " + inventory.get(name).getSpecification());
                            System.out.println("Cost: " + inventory.get(name).getCost());
                            System.out.println("Quantity: " + inventory.get(name).getQuantity());
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                    
                    private static void editProduct(String name) {
                        if (inventory.containsKey(name)) {
                            Scanner input = new Scanner(System.in);
                            Product product = inventory.get(name);
                    
                            System.out.print("Enter new name: ");
                            String newName = input.next();
                            product.setName(newName);
                    
                            System.out.print("Enter new specification: ");
                            String newSpecification = input.next();
                            product.setSpecification(newSpecification);
                    
                            System.out.print("Enter new cost: ");
                            double newCost = input.nextDouble();
                            product.setCost(newCost);
                    
                            inventory.remove(name);
                            inventory.put(newName, product);
                            System.out.println("Product updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                    
                    private static void updateInventory(String name, int quantity) {
                        if (inventory.containsKey(name)) {
                            Product product = inventory.get(name);
                            int currentQuantity = product.getQuantity();
                            currentQuantity += quantity;
                            product.setQuantity(currentQuantity);
                            System.out.println("Inventory updated successfully.");
                        } else {
                            System.out.println("Product not found.");
                        }
                    }
                    
                }


Output:

PS F:\Java Assignment> javac InventoryObjects.java
PS F:\Java Assignment> java InventoryObjects      

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 1

Product List
--------------------
Laptop
Phone
Tablet

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 2
Enter product name: Laptop

Product Count
--------------------
Product: Laptop
Quantity: 5

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 3
Enter product name: Laptop

Product Details
--------------------
Product: Laptop
Specification: MacBook Pro
Cost: 1499.99
Quantity: 5

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 4
Enter product name: laptop
Product not found.

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 4
Enter product name: Laptop
Enter new name: Laptops
Enter new specification: Macbook
Enter new cost: 1999.99
Product updated successfully.

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 5
Enter product name: Laptop
Enter quantity to add/delete: 4
Product not found.

Inventory Management System Menu
1. Product List
2. Product Count
3. View Product Details
4. Edit Product
5. Update Inventory
0. Exit
Enter your choice: 0
Exiting Inventory Management System...

