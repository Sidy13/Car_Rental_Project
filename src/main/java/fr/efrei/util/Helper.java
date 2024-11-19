package fr.efrei.util;

import fr.efrei.domain.Address;
import fr.efrei.domain.BankingCard;

import javax.smartcardio.Card;
import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
    public static boolean isNullOrEmpty(Address address) {
        return address == null;
    }
    public static boolean isNullOrEmpty(Object o) {
        return o == null;
    }
    public static String generateId(){
        return UUID.randomUUID().toString();
    }
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(emailRegex, email);
    }

    public static boolean isValidPhone(String phone) {
        String phoneRegex = "^\\+?[0-9]{10,15}$";
        return phone != null && Pattern.matches(phoneRegex, phone);
    }
    public static boolean isValidPassword(String password) {
        String passwordRegex = "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9!@#$%^&*()_+={}|;:,.<>?/-]).{8,}$";
        return password != null && Pattern.matches(passwordRegex, password);
    }
    public static boolean isValidCard(BankingCard card) {
        // https://stackoverflow.com/questions/9315647/regex-credit-card-number-tests
        String mastercardRegex = "^(5[1-5][0-9]{14}|2(22[1-9][0-9]{12}|2[3-9][0-9]{13}|[3-6][0-9]{14}|7[0-1][0-9]{13}|720[0-9]{12}))$";
        String visaRegex = "^4[0-9]{12}(?:[0-9]{3})?$";
        String visaMasterCardRegex = "^^(?:4[0-9]{12}(?:[0-9]{3})?|5[1-5][0-9]{14})$";
        String cardNumber = card.getNumber();
        return Pattern.matches(mastercardRegex, cardNumber) || Pattern.matches(visaRegex, cardNumber) || Pattern.matches(visaMasterCardRegex, cardNumber) && card.getCvv().length()==3;
    }
}
