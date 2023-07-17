package om.gov.taxoman.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "CUSTOMERS")
public class Customer extends User {

    @Column(name = "FULL_NAME")
    private String fullName;

    @OneToMany(mappedBy = "customer")
    private List<Rental> rentals = new ArrayList<>();

}