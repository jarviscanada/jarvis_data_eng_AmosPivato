package ca.jrvs.apps.practice;

public interface RegexExc {
    /**
     * return true if filename extension if jpg or pjeg (case insensitive)
     * @param filename
     * @return
     */
    public boolean matchJpeg(String filename);

    /**
     * Return true if ip is a valid ipv4 address
     * @param ip
     * @return
     */
    public boolean matchIp(String ip);

    /**
     * return true if line is empty (whitespace, new line, tabs etc...)
     * @param line
     * @return
     */
    public boolean isEmptyLine(String line);
}