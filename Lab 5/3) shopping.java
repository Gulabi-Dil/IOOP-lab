/*
Implement a ShoppingCart class that contains an inner class Item.
a) The Item class should have fields like itemName, quantity, and price.
b) The ShoppingCart class should provide methods to add items, calculate the total price, and display the cart contents.
*/
import java.util.Scanner;
class ShoppingCart {
Item[] items;
int itemCount;
double total;
  class Item
  {
      String itemName;
      int quantity;
      double price;
      Item(String itemName, int quantity, double price)
      {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
      }

      void displayItem()
      {
        System.out.printf("%s (x%d): Rs. %.2f each\n",itemName,quantity,price);
      }
  }
    public ShoppingCart(int size) {
        this.items = new Item[size];
        this.itemCount = size;
    }

    void addItems() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < itemCount; i++) {
            System.out.print("Enter item name: ");
            String name = sc.nextLine();
            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();
            System.out.print("Enter price: ");
            double price = sc.nextDouble();
            sc.nextLine(); // Consume newline
            items[i] = new Item(name, qty, price);
        }
    }

    void calculateTotal() {
        total=0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].quantity * items[i].price;
        }
    }

    void displayCart() {
        if (itemCount == 0) {
            System.out.println("Your shopping cart is empty.");
        } else {
            System.out.println("\nShopping Cart:");
            calculateTotal();
            for (int i = 0; i < itemCount; i++) {
                items[i].displayItem();
            }
            System.out.printf("Total Price: Rs.%.2f",total);
        }
    }
}

class shopping {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of items: ");
        int size = scan.nextInt();
        scan.nextLine();
        ShoppingCart cart = new ShoppingCart(size);
        cart.addItems();
        cart.displayCart();
    }
}
