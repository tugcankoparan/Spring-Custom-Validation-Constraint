package com.tugcankoparan.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.validation.ConstraintViolation;
import javax.validation.Path;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ClientBean {
    @Autowired
    private Validator validator;

    public void run(){
        Book book = new Book();
        book.setName("Alien Explorer");
        book.setLanguage("English");

        Set<ConstraintViolation<Book>> violations = validator.validate(book);
        for (ConstraintViolation<Book> violation : violations) {
            String message = violation.getMessage();
            Path path = violation.getPropertyPath();
            System.err.println(path+" "+message);
        }
    }
}