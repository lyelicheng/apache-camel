package com.llye.apache.apachecamel.route;

import com.llye.apache.apachecamel.model.Book;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("activemq:queue:inputQueue")
                .log("Received message: ${body}")
                .process(exchange -> {
                    Book book = new Book();
                    book.setTitle("Sample Book");
                    book.setAuthor("John Doe");
                    book.setGenre("Fiction");
                    book.setPublishedYear(2023);
                    exchange.getIn().setBody(book);
                })
                .to("bean:bookService?method=insertBook")
                .log("Inserted book into DB: ${body}");
    }
}
