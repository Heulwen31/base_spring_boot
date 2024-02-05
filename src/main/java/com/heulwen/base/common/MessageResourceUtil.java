package com.heulwen.base.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class MessageResourceUtil {
    private static MessageSource messageSource;

    @Autowired
    public MessageResourceUtil(MessageSource messageSource) {
        MessageResourceUtil.messageSource = messageSource;
    }

    public static String message(String message) {
        Locale locale = Locale.getDefault();
        return messageSource.getMessage(message, new Object[]{null}, locale);
    }
}
