package pl.blackparade.pp5.ebook.productcatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class CatalogConfiguration{

    @Bean
    ProductCatalogFacade facade(BookRepository repository){
        ProductCatalogFacade productCatalogFacade = new ProductCatalogFacade(repository);

        productCatalogFacade.addBook(
                thereIsPublishedBook("Lucy and Morgan"));
        productCatalogFacade.addBook(
                thereIsPublishedBook("Morty and Rick"));


        return new ProductCatalogFacade(repository);
    }
    private Book thereIsPublishedBook(String title) {
        return Book.builder()
                .cover("https://www.mswordcoverpages.com/wp-content/uploads/2018/10/Book-cover-page-1-CRC.png")
                .title(title)
                .description(title)
                .price(BigDecimal.valueOf(120.00))
                .published(true)
                .build();
    }
}

