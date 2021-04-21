package books.api.com.controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import books.api.com.document.Books;
import books.api.com.repository.BooksRepository;
import books.api.com.service.BooksService;
import static books.api.com.constants.BooksConstant.BOOKS_ENDPOINT_LOCAL;

@RestController
public class BooksController {
    BooksService booksService;
    BooksRepository booksRepository;

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BooksController.class);

    public BooksController(BooksService booksService, BooksRepository booksRepository){
        this.booksService = booksService;
        this.booksRepository = booksRepository;
    }

    @GetMapping(BOOKS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.OK)
    public Flux<Books> getAll(){
        log.info("requesting the list of all books");
        return booksService.findAll();
    }

    @GetMapping(BOOKS_ENDPOINT_LOCAL + "/{id}")
    public Mono<ResponseEntity<Books>>getBookById(@PathVariable String id){
        log.info("requesting a book by id {}", id);
        return booksService.findById(id)
                .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
                .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));

    }

    @PostMapping(BOOKS_ENDPOINT_LOCAL)
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Books> saveBook(@RequestBody Books books){
        log.info("a new book was saved");
        return booksService.save(books);
    }

    @DeleteMapping(BOOKS_ENDPOINT_LOCAL + "/{id}")
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public HttpStatus deleteBookById(@PathVariable String id){
        booksService.deleteById(id);
        log.info("book with id {} deleted", id);
        return HttpStatus.NOT_FOUND;
    }
}