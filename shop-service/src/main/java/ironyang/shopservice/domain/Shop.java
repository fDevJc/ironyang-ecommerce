package ironyang.shopservice.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Long id;

    private String businessNumber;
    private String name;
    private String address;
    private String phone;

    @Builder
    private Shop(Long id, String businessNumber, String name, String address, String phone) {
        this.id = id;
        this.businessNumber = businessNumber;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }
}
