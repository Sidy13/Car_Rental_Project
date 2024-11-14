package fr.efrei.util;

import fr.efrei.domain.Address;

import java.util.UUID;
import java.util.regex.Pattern;

public class Helper {
    public static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
    public static boolean isNullOrEmpty(Address address) {
        return address == null;
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
}
