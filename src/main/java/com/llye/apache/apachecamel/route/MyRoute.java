package com.llye.apache.apachecamel.route;

import com.llye.apache.apachecamel.model.Book;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("activemq:queue:inputQueue")
                .log("Received message: ${body}")
                .choice()
                    .when().method("messageValidator", "isValidJson")
                        .log("Received JSON message")
                        .unmarshal().json(Book.class)
                        .to("direct:processBook")
                    .when().method("messageValidator", "isValidXml")
                        .log("Received XML message")
                        .unmarshal().jacksonXml(Book.class)
                        .to("direct:processBook")
                    .otherwise()
                        .log("Unknown message format")
                .end();

        from("direct:processBook")
                .to("bean:bookService?method=insertBook")
                .log("Inserted book into DB: ${body}")
                .end();
    }
}
