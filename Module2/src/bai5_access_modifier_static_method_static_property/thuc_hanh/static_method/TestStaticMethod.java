package bai5_access_modifier_static_method_static_property.thuc_hanh.static_method;

public class TestStaticMethod {
    public static void main(String[] args) {
        Student.change();

        Student s1 = new Student(111, "Son");
        Student s2 = new Student(222,"Minh");

        s1.display();
        s2.display();
    }
}
