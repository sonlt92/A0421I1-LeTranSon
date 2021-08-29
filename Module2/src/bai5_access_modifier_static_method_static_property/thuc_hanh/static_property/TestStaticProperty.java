package bai5_access_modifier_static_method_static_property.thuc_hanh.static_property;

public class TestStaticProperty {
    public static void main(String[] args) {
        Car car1 = new Car("BMW","Ryuk");
        System.out.println(Car.numberOfCars);
        Car car2 = new Car("Honda","Takashi");
        System.out.println(Car.numberOfCars);
    }
}
