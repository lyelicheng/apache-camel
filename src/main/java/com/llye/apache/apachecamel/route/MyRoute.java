package com.llye.apache.apachecamel.route;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.llye.apache.apachecamel.model.Book;
import com.llye.apache.apachecamel.model.MessageType;
import com.llye.apache.apachecamel.util.MessageTypeChecker;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MyRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("activemq:queue:inputQueue")
                .log("Received message: ${body}")
                .choice()
                .when(simple("${body.getClass().getName()} == 'java.lang.String'"))
                .process(exchange -> {
                    String bodyString = exchange.getIn().getBody(String.class);
                    MessageType messageType = MessageTypeChecker.getMessageType(bodyString);
                    Book book;
                    if (MessageType.JSON.equals(messageType)) {
                        ObjectMapper objectMapper = new ObjectMapper();
                        book = objectMapper.readValue(bodyString, Book.class);
                    } else if (MessageType.XML.equals(messageType)) {
                        XmlMapper xmlMapper = new XmlMapper();
                        book = xmlMapper.readValue(bodyString, Book.class);
                    } else {
                        throw new IllegalArgumentException("Unsupported message type.");
                    }
                    exchange.getIn().setBody(book);
                })
                .to("bean:bookService?method=insertBook")
                .log("Inserted book into DB: ${body}")
                .otherwise()
                .log("Invalid message format: ${body}")
                .end();
    }
}
