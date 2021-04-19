package utcn.ds.carshop.dto;

public class NewCarDTO {

    private String type;
    private String model;
    private long price;
    private long year;
    private String details;
    private String image;

    public NewCarDTO() {
    }

    public NewCarDTO(String type, String model, long price, long year, String details, String image) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.year = year;
        this.details = details;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getYear() {
        return year;
    }

    public void setYear(long year) {
        this.year = year;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
