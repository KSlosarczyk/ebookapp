package pl.blackparade.pp5.ebook.productcatalog;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Builder
@Entity
public class Book {
    private Book(){

    }
    @Id
    @GeneratedValue //Autonumered ID

    Long id;

    String title;
    String description;
    String cover;
    Boolean published;
    BigDecimal price;


}
