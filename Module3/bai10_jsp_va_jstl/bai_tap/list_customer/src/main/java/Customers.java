public class Customers {
    private String name;
    private String dateOfBirth;
    private String address;
    private String linkImg;

    public Customers() {
    }

    public Customers(String name, String dateOfBirth, String address, String linkImg) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.linkImg = linkImg;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}
