package books.api.com.repository;

import books.api.com.document.Books;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface BooksRepository extends CrudRepository<Books, String> {

}
