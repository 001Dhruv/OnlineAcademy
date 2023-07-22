package com.example.onlineacademy;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateHandlor {
    public static boolean isValidEmail(String email) {
            final String EMAIL_PATTERN =
                "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" +
                        "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isValidContactNumber(String contactNumber) {
        final String CONTACT_NUMBER_PATTERN = "^[0-9]{10}$";
        Pattern pattern = Pattern.compile(CONTACT_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(contactNumber);
        return matcher.matches();
    }
}
