package Lab1_JavaBasic.Bai6;

public class Main {
    public static void main(String[] args) {
        Lion lion = new Lion("Simba", 190, "Thit");
        Snake snake = new Snake("Python", 50, 5.5);
        Monkey monkey = new Monkey("King Kong", 80, "Chuoi");
        lion.hienThi();
        System.out.println();
        snake.hienThi();
        System.out.println();
        monkey.hienThi();
    }
}
