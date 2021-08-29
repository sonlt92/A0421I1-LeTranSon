package bai5_access_modifier_static_method_static_property.baitap.xay_dung_lop_chi_ghi;

public class Student {
    private String name = "john";
    private String classes = "C02";

    public Student(){

    }

    public String setName(String name){
        System.out.print(name);
        return name;
    }

    public String setClass(String classes){
        System.out.print("\n" + classes);
        return classes;
    }
}
