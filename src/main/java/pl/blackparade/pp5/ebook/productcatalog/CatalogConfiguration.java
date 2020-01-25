package pl.blackparade.pp5.ebook.productcatalog;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CatalogConfiguration{

    @Bean
    ProductCatalogFacade facade(BookRepository repository){
        return new ProductCatalogFacade(repository);
    }
}
