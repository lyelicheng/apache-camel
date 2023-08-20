package com.llye.apache.apachecamel.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;

@Component("messageValidator")
public class MessageValidator {

    public boolean isValidJson(String body) {
        try {
            new ObjectMapper().readTree(body);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public boolean isValidXml(String body) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new java.io.StringReader(body)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
