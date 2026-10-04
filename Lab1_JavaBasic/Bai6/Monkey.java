package Lab1_JavaBasic.Bai6;

public class Monkey extends Animal {
    String food;
    public Monkey(String name, double weight, String food) {
        super(name, weight);
        this.food = food;
    }
    public void hienThi() {
        System.out.println("=== MONKEY ===");
        super.hienThi();
        System.out.println("Thuc an yeu thich: " + food);
    }
}
