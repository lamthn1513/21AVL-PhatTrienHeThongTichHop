package Lab03_JavaStream.Bai4;

public class Main {
    public static void main(String[] args) {
        Product p1=new Product("SP01","Bàn phím" , 350000, 10);
        Product p2=new Product("SP02","Chuột không dây" , 650000, 5);
        Product p3=new Product("SP03","Tai nghe" , 600000, 3);
        System.out.println(p1);
        System.out.println("Giá trị tồn kho: "+p1.inventoryValue());
        System.out.println("\n"+p2);
        System.out.println("Giá trị tồn kho: "+p2.inventoryValue());
        System.out.println("\n"+p3);
        System.out.println("Giá trị tồn kho: "+p3.inventoryValue());

    }
}
