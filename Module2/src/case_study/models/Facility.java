package case_study.models;

public class Facility {
    private String idFacicility;
    private String nameService;
    private double areaUse;
    private int rentalPrice;
    private int rentalPeopleMax;
    private String styleRental;

    public Facility() {
    }

    public Facility(String idFacicility, String nameService, double areaUse, int rentalPrice, int rentalPeopleMax, String styleRental) {
        this.idFacicility = idFacicility;
        this.nameService = nameService;
        this.areaUse = areaUse;
        this.rentalPrice = rentalPrice;
        this.rentalPeopleMax = rentalPeopleMax;
        this.styleRental = styleRental;
    }

    public String getIdFacicility() {
        return idFacicility;
    }

    public void setIdFacicility(String idFacicility) {
        this.idFacicility = idFacicility;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getAreaUse() {
        return areaUse;
    }

    public void setAreaUse(double areaUse) {
        this.areaUse = areaUse;
    }

    public int getRentalPrice() {
        return rentalPrice;
    }

    public void setRentalPrice(int rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public int getRentalPeopleMax() {
        return rentalPeopleMax;
    }

    public void setRentalPeopleMax(int rentalPeopleMax) {
        this.rentalPeopleMax = rentalPeopleMax;
    }

    public String getStyleRental() {
        return styleRental;
    }

    public void setStyleRental(String styleRental) {
        this.styleRental = styleRental;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idFacicility = '" + idFacicility + '\'' +
                ", nameService = '" + nameService + '\'' +
                ", areaUse = " + areaUse +
                ", rentalPrice = " + rentalPrice +
                ", rentalPeopleMax = " + rentalPeopleMax +
                ", styleRental = '" + styleRental + '\'' +
                '}';
    }
}
