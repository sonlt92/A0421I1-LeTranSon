package model.bean;

public class Service {
    private int idService ;
    private String name;
    private int areaUsed;
    private int numOfFloors;
    private int maxPeoples;
    private int rentalCosts;
    private String rentalType;
    private String typeOfService;
    private String linkImg;

    public Service() {
    }

    public Service(int idService, String name, int areaUsed, int numOfFloors, int maxPeoples, int rentalCosts, String RentalType, String TypeOfService, String linkImg) {
        this.idService = idService;
        this.name = name;
        this.areaUsed = areaUsed;
        this.numOfFloors = numOfFloors;
        this.maxPeoples = maxPeoples;
        this.rentalCosts = rentalCosts;
        this.rentalType = RentalType;
        this.typeOfService = TypeOfService;
        this.linkImg = linkImg;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAreaUsed() {
        return areaUsed;
    }

    public void setAreaUsed(int areaUsed) {
        this.areaUsed = areaUsed;
    }

    public int getNumOfFloors() {
        return numOfFloors;
    }

    public void setNumOfFloors(int numOfFloors) {
        this.numOfFloors = numOfFloors;
    }

    public int getMaxPeoples() {
        return maxPeoples;
    }

    public void setMaxPeoples(int maxPeoples) {
        this.maxPeoples = maxPeoples;
    }

    public int getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(int rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getLinkImg() {
        return linkImg;
    }

    public void setLinkImg(String linkImg) {
        this.linkImg = linkImg;
    }
}
