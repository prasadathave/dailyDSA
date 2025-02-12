package org.example.Feb2025;

public class Feb112025 {
    public String removeOccurrences(String s, String part) {
        while(s.contains(part)){
            s = s.replaceFirst(part,"");
        }
        return s;
    }
}
