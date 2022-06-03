package ca.jrvs.apps.practice;

public class RegexExcImp implements RegexExc{
    @Override
    public boolean matchJpeg(String filename) {
        return false;
    }

    @Override
    public boolean matchIp(String ip) {
        return false;
    }

    @Override
    public boolean isEmptyLine(String line) {
        return false;
    }
}