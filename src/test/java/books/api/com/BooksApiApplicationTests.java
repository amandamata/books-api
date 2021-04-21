package books.api.com;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import static books.api.com.constants.BooksConstant.BOOKS_ENDPOINT_LOCAL;

@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class BooksApiApplicationTests {

	@Autowired
	WebTestClient webTestClient;

	@Test
	public void getOneBookById(){
		webTestClient.get().uri(BOOKS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isOk()
				.expectBody();

	}

	@Test
	public void getOneBookNotFound(){
		webTestClient.get().uri(BOOKS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.exchange()
				.expectStatus().isNotFound();

	}

	@Test
	public void deleteBook(){
		webTestClient.delete().uri(BOOKS_ENDPOINT_LOCAL.concat("/{id}"),"1")
				.accept(MediaType.APPLICATION_JSON)
				.exchange()
				.expectStatus().isNotFound()
				.expectBody(Void.class);

	}
}
