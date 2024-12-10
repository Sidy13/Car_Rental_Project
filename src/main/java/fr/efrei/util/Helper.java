package fr.efrei.util;

import fr.efrei.domain.Address;
import fr.efrei.domain.BankingCard;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    public static String generateId() {
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

    public static String validateCard(BankingCard card) {
        StringBuilder errors = new StringBuilder();

        if (!isValidCardNumber(card.getNumber())) {
            errors.append("Invalid card number, it must be composed of 16 digits.\n");
        }

        if (!isValidExpirationDate(card.getExpirationDate())) {
            errors.append("Invalid expiration date, it must be in the format MM/YY and must be after the current date.\n");
        }

        if (!isValidCVV(card.getCvv())) {
            errors.append("The CVV must be composed of 3 digits.\n");
        }


        if (!errors.isEmpty()) {
            return errors.toString();
        } else {
            return null;
        }    }

    public static boolean isValidCardNumber(String number) {
        return number.matches("\\d{16}");
    }

    public static boolean isValidExpirationDate(String expirationDate) {
        try {
            LocalDate expDate = LocalDate.parse("01/" + expirationDate, DateTimeFormatter.ofPattern("dd/MM/yy"));
            return expDate.isAfter(LocalDate.now());
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static boolean isValidCVV(String cvv) {
        return cvv.matches("\\d{3}");
    }




}
