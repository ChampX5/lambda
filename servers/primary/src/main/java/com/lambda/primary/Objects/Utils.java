package com.lambda.primary.Objects;

public class Utils {
    public static String StringToHex(String c){
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i<c.length(); i++){
            hexString.append(Integer.toHexString(c.charAt(i)));
        }
        return hexString.toString();
    }
}
