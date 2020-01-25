package pl.blackparade.pp5.productcatalog;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import java.math.BigDecimal;
import java.util.List;

public class ProductCatalogFacadeTest {

    //Plain Java Object. Easy to test and move to the other's.
    @Test
    public void itAllowAddBookToCatalog(){
        //Fasada. Punkt stycznosci ze swiatem zewnetrznym.
        ProductCatalogFacade app = new ProductCatalogFacade();

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
