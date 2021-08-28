package bai10_dsa_danh_sach.bai_tap.trien_khai_linkedlist;

public class TestMyLinkedList {
    public static void main(String[] args) {
        class Student {
            private int id;
            private String name;

            public Student() {
            }

            public Student(int id, String name) {
                this.id = id;
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
        MyLinkedList<Student> myLinkedList = new MyLinkedList<>();
        Student student1 = new Student(1, "Jacky");
        Student student2 = new Student(2, "Ryuk");
        Student student3 = new Student(3, "Cuong");
        Student student4 = new Student(4, "Vu");
        Student student5 = new Student(5, "Quyen");

        myLinkedList.addFirst(student1);
        myLinkedList.addFirst(student2);
        myLinkedList.addFirst(student3);
        myLinkedList.addFirst(student4);
        myLinkedList.addLast(student5);

        myLinkedList.remove(3);

        MyLinkedList<Student> cloneMyLinkedList =  myLinkedList.clone();

        System.out.println(myLinkedList.constrains(student2));

        System.out.println(myLinkedList.indexOf(student3));

        for (int i = 0; i < myLinkedList.size(); i++) {
            Student student = (Student) myLinkedList.get(i);
            System.out.println(student.getName());
        }

        for (int i = 0; i < cloneMyLinkedList.size(); i++) {
            Student student = (Student) cloneMyLinkedList.get(i);
            System.out.println(student.getName());
        }
    }
}
