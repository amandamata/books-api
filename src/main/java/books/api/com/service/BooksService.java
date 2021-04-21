package books.api.com.service;

import books.api.com.document.Books;
import books.api.com.repository.BooksRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class BooksService {
    private final BooksRepository booksRepository;

    public BooksService(BooksRepository booksRepository){
        this.booksRepository = booksRepository;
    }

    public Flux<Books> findAll(){
        return Flux.fromIterable(this.booksRepository.findAll());
    }

    public Mono<Books> findById(String id){
        return Mono.justOrEmpty(this.booksRepository.findById(id));
    }

    public Mono<Books> save(Books books){
        return Mono.justOrEmpty(this.booksRepository.save(books));
    }

    public void deleteById(String id){
        booksRepository.deleteById(id);
    }
}
