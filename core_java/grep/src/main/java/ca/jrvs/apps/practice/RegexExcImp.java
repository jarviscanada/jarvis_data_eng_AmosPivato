package ca.jrvs.apps.practice;

import java.util.regex.Pattern;

public class RegexExcImp implements RegexExc{
    @Override
    public boolean matchJpeg(String filename) {
        //[^\\s] must contain at least one char
        //\\.matches for a .
        //?i means make the string case insentive
        // $ ending should be .jpg .jpeg and is case insensitive
        return Pattern.matches("([^\\s]+(\\.(?i)(jpe?g))$)", filename);
    }

    @Override
    public boolean matchIp(String ip) {
        //?: means it matches but wont capture the group
        //{1,3} 1 to 3 times match previous char
        // ^ means the start should be and $ means the end should be
        return Pattern.matches("^(?:[0-9]{1,3}\\.){3}[0-9]{1,3}$", ip);
    }

    @Override
    public boolean isEmptyLine(String line) {
        return Pattern.matches("^\\s*$", line);
    }

    public static void main(String[] args) {
        //simple testing to check implementation nothing too scientific
        RegexExc regexExc = new RegexExcImp();
        System.out.println(regexExc.matchJpeg("amos.jpg"));
        System.out.println(regexExc.matchJpeg("amos.jpeg"));
        System.out.println(regexExc.matchJpeg(".jpg"));
        System.out.println(regexExc.matchJpeg("..jpeg"));
        System.out.println(regexExc.matchIp("0.0.0.0"));
        System.out.println(regexExc.matchIp("999.999.999.999"));
        System.out.println(regexExc.matchIp("2.33.45.655"));
        System.out.println(regexExc.matchIp("4.5.33"));
        System.out.println(regexExc.isEmptyLine(""));
        System.out.println(regexExc.isEmptyLine("bruh what"));
    }
}