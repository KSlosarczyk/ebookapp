package pl.blackparade.pp5.productcatalog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.swing.*;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductCatalogFacadeTest {

    @Autowired
    BookRepository repository;

    
    //Plain Java Object. Easy to test and move to the other's.
    @Test
    public void itAllowAddBookToCatalog(){
        //Fasada. Punkt stycznosci ze swiatem zewnetrznym.
        ProductCatalogFacade app = new ProductCatalogFacade(repository);
        Book book = thereIsBookIWouldLikeToHave();
        app.addBook(book);

        List<Book> books = app.allBooks();
        assertThat(books).hasSize(1);
    }

    private Book thereIsBookIWouldLikeToHave() {
        return Book.builder()
            .cover("https://www.mswordcoverpages.com/wp-content/uploads/2018/10/Book-cover-page-1-CRC.png")
                .title("Pragmatic programmer")
            .description("hey hey")
            .price(BigDecimal.valueOf(120.00))
            .published(true)
                .build();
    }
}
