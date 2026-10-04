package Lab1_JavaBasic.Bai6;

public class Animal {
    String name;
    double weight;
    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    public void hienThi() {
        System.out.println("Ten: " + name);
        System.out.println("Can nang: " + weight);
    } 
}
