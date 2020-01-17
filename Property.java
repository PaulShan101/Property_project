package Properties;

public class Property {


    public static int productId = 0;
    private int id;
    private String description;
    private String address;
    private String ber;
    private String eircode;
    private String areaId;
    private double priceId;
    private double bedroomId;
    private String typeId;



    public Property(String description, String address, String ber, String eircode, String areaId,double priceId, double bedroomId, String typeId ) {

        this.id = productId++;
        this.description = description;
        this.address = address;
        this.ber = ber;
        this.eircode = eircode;
        this.areaId = areaId;
        this.priceId = priceId;
        this.bedroomId = bedroomId;
        this.typeId = typeId;

    }


    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public double getBedroomId() {
        return bedroomId;
    }

    public void setBedroomId(double bedroomId) {
        this.bedroomId = bedroomId;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }




    public int getId ()
    {
        return id;
    }

    public void setId ( int id)
    {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String getBer() {
        return ber;
    }

    public void setBer(String ber) {
        this.ber = ber;
    }

    public String getEircode() {
        return eircode;
    }

    public void setEircode(String eircode) {
        this.eircode = eircode;
    }

    public double getPrice() {
        return priceId;
    }

    public void setPrice(double price) {
        this.priceId = priceId;
    }

    @Override
    public String toString() {
        return " Property  " +
                " id=  " + id + '\n' +
                " Description=  " + description + '\n' +
                " Address= " + address + '\n' +
                " Ber=  " + ber + '\n' +
                " Eircode=  " + eircode + '\n' +
                " AreaId=  " + areaId + '\n' +
                " Price=  " + priceId + '\n' +
                " Bedroom=  " + bedroomId + '\n' +
                " TypeId=  " + typeId + '\n' +

                "------------------------------";
    }
}
