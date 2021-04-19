package utcn.ds.carshop.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "model")
    private String model;

    @Column(name = "price")
    private long price;

    @Column(name = "year")
    private long year;

    @Column(name = "image")
    private String image;

    @Column(name = "details")
    private String details;

    //status can be SOLD or ACTIVE
    @Column(name = "status")
    private String status;

    public Car() {
    }

    public Car(String type, String model, long price, long year, String image, String details, String status) {
        this.type = type;
        this.model = model;
        this.price = price;
        this.year = year;
        this.image = image;
        this.details = details;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}