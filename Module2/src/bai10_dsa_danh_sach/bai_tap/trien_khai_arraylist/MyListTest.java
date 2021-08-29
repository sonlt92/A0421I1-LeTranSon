package bai10_dsa_danh_sach.bai_tap.trien_khai_arraylist;

public class MyListTest {

    public static void main(String[] args) {
        Student a = new Student(1, "Jacky");
        Student b = new Student(2, "Ryuk");
        Student c = new Student(3, "Cuong");
        Student d = new Student(4, "Quyen");
        Student e = new Student(5, "Phat");
        Student f = new Student(6, "Dat");

        MyList<Student> studentMyList = new MyList<>();
        studentMyList.add(a);
        studentMyList.add(b);
        studentMyList.add(c);
        studentMyList.add(d);
        studentMyList.add(e);
        studentMyList.add(f);

        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.print(student.getId() + "." + " ");
            System.out.println(((Student) studentMyList.elements[i]).getName());
        }

        System.out.println(studentMyList.get(2).getName());

        System.out.println(studentMyList.indexOf(b));

        System.out.println(studentMyList.contains(b));


        MyList<Student> newStudentMyList = new MyList<>();
        newStudentMyList = studentMyList.clone();
        newStudentMyList.remove(3);
        for (int i = 0; i < newStudentMyList.size(); i++) {
            System.out.println(newStudentMyList.get(i).getName());
        }


    }

    public static class Student {
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
}
