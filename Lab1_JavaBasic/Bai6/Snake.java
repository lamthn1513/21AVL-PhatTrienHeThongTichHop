package Lab1_JavaBasic.Bai6;

public class Snake extends Animal {
    double length;
    public Snake(String name, double weight, double length) {
        super(name, weight);
        this.length = length;
    }
    public void hienThi() {
        System.out.println("SNAKE");
        super.hienThi();
        System.out.println("Chieu dai: " + length);
    }
}
