package Lab1_JavaBasic.Bai6;

public class Lion extends Animal {
    String eat;
    public Lion(String name, double weight, String eat) 
    {
        super(name, weight);
        this.eat = eat;
    }

    public void hienThi() {
        System.out.println("LION");
        super.hienThi();
        System.out.println("Thuc an: " + eat);
    }
}
