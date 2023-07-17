package om.gov.taxoman;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import om.gov.taxoman.entity.Customer;
import om.gov.taxoman.entity.Property;
import om.gov.taxoman.entity.PropertyOwner;
import om.gov.taxoman.entity.Rental;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hamdan");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Customer customer = new Customer();
        customer.setEmail("Salim@gmail.com");
        customer.setFullName("Salim Alhabsi");
        customer.setPassword("111@aaa");
        em.persist(customer);

        Customer customer1 = new Customer();
        customer1.setEmail("Ali@gmail.com");
        customer1.setFullName("Ali okey");
        customer1.setPassword("222@bbb");
        em.persist(customer1);

        PropertyOwner propertyOwner = new PropertyOwner();
        propertyOwner.setEmail("Salim@gmail.com");
        propertyOwner.setPassword("111@aaa");
        propertyOwner.setPhoneNumber("9100001");
        em.persist(propertyOwner);

        PropertyOwner propertyOwner1 = new PropertyOwner();
        propertyOwner1.setEmail("Ali@gmail.com");
        propertyOwner1.setPassword("222@bbb");
        propertyOwner1.setPhoneNumber("9101111");
        em.persist(propertyOwner1);

        PropertyOwner foundPropertyOwner = em.find(PropertyOwner.class, 1);
        PropertyOwner foundPropertyOwner1 = em.find(PropertyOwner.class, 2);

        Property property = new Property();
        property.setDayRentalPrice(5);
        property.setName("Muscat Flat");
        property.setPropertyOwner(foundPropertyOwner);
        em.persist(property);

        Property property1 = new Property();
        property1.setDayRentalPrice(10);
        property1.setName("Sohar Flat");
        property1.setPropertyOwner(foundPropertyOwner1);
        em.persist(property1);

        Property property2 = new Property();
        property2.setDayRentalPrice(15);
        property2.setName("Nizwa Flat");
        property2.setPropertyOwner(foundPropertyOwner);
        em.persist(property2);

        Property property3 = new Property();
        property3.setDayRentalPrice(20);
        property3.setName("Salalah Flat");
        property3.setPropertyOwner(foundPropertyOwner1);
        em.persist(property3);

        Customer foundCustomer = em.find(Customer.class, 1);
        Property foundProperty = em.find(Property.class, 1);

        Rental rental = new Rental();
        rental.setStartDate(LocalDate.of(2019, 1, 1));
        rental.setEndDate(LocalDate.of(2023, 12,31));
        rental.setRentingAmount(100);
        rental.setCustomer(foundCustomer);
        rental.setProperty(foundProperty);
        em.persist(rental);

        Customer foundCustomer1 = em.find(Customer.class,1);
        Property foundProperty1 = em.find(Property.class,2);
        Rental rental1 = new Rental();
        rental1.setStartDate(LocalDate.of(2020,1,1));
        rental1.setEndDate(LocalDate.of(2022,12,31));
        rental1.setRentingAmount(200);
        rental1.setCustomer(foundCustomer1);
        rental1.setProperty(foundProperty1);
        em.persist(rental1);

        em.getTransaction().commit();

        em.close();
        emf.close();

    }
}