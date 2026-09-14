package Tuan3.Bai4;

public class Main {
    public static void main(String[] args) {
        product p1=new product("SP01","Bàn phím" , 350000, 10);
        product p2=new product("SP02","Chuột không dây" , 650000, 5);
        product p3=new product("SP03","Tai nghe" , 600000, 3);
        System.out.println(p1);
        System.out.println("Giá trị tồn kho: "+p1.inventoryValue());
        System.out.println("\n"+p2);
        System.out.println("Giá trị tồn kho: "+p2.inventoryValue());
        System.out.println("\n"+p3);
        System.out.println("Giá trị tồn kho: "+p3.inventoryValue());

    }
}
