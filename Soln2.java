import java.util.*;

class Product {
    int productId;
    String name;
    double price;

    Product(int productId, String name, double price) {
        this.productId=productId;
        this.name=name;
        this.price=price;
    }

    double calculateFinalPrice() {
        return price;
    }
}

class Electronics extends Product {
    Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
        return price +(price*0.17) + 500;
    }
}

class Clothing extends Product {
    Clothing(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
     double discountPrice= price -(price*0.10);
     return discountPrice + (discountPrice*0.05);
    }
}

class Book extends Product {
    Book(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    double calculateFinalPrice() {
         return price + (price * 0.05);
    }
}

class soln2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        Product[] products =new Product[n];
        for(int i =0; i<n; i++){
            int type = sc.nextInt();
            int id = sc.nextInt();
            String name = sc.next();
            double price = sc.nextDouble();
            if (type == 1) {
                products[i] = new Electronics(id, name, price);
            } 
            else if (type == 2) {
                products[i] = new Clothing(id, name, price);
            } 
            else {
                products[i] = new Book(id, name, price);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(products[i].name +" "+ products[i].calculateFinalPrice());
        }


        }
    }
