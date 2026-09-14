package Tuan3.Bai4;

public class product {
    private final String code;
    private final String name;
    private final double unitPrice;
    private final int quantity;
    public product (String code, String name, double unitPrice, int quantity){
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Mã không được rỗng");
        }
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Tên không được rỗng");
        }
        if (unitPrice <=0 || quantity <0) {
            throw new IllegalArgumentException("Giá hoặc số lượng không hợp lệ");
        }
        this.code=code;
        this.name=name;
        this.unitPrice=unitPrice;
        this.quantity=quantity;
    }

    public double inventoryValue(){
        return unitPrice * quantity;
    }

    @Override 
    public String toString(){
        return "%s - %s: %,.0f VNĐ".formatted(code,name, inventoryValue());
    }
}
