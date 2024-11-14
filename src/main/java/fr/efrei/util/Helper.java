package fr.efrei.util;

import fr.efrei.domain.Address;

import java.util.UUID;

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
}
