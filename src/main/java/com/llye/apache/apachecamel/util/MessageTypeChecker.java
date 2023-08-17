package com.llye.apache.apachecamel.util;

import com.llye.apache.apachecamel.model.MessageType;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MessageTypeChecker {

    public static MessageType getMessageType(String inputString) {
        if (isJSONString(inputString)) {
            return MessageType.JSON;
        } else if (isXMLString(inputString)) {
            return MessageType.XML;
        } else {
            return MessageType.UNKNOWN;
        }
    }

    private static boolean isJSONString(String inputString) {
        try {
            new JSONObject(inputString);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public static boolean isXMLString(String inputString) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(new InputSource(new java.io.StringReader(inputString)));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
