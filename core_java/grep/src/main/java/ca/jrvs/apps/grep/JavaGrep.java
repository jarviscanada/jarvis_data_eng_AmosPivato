package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface JavaGrep {

    /**
     * top level search workflow
     * @throws IOException
     */
    void process() throws IOException;

    /**
     * traverse a given directory and return all files
     * @param rootDir input dir
     * @return files under the rootdir
     */
    List<File> listFiles(String rootDir);

    /**
     * read a file and return all lines
     *
     * FileReader class for reading character files, meant to read streams of characters
     * BufferedReader reads text from character input stream buffering characters to provide efficient reading
     * character encoding is defualt to utf16 to encode its chars
     *
     * @param inputFile to be read
     * @return lines
     * @throws IllegalArgumentException if a given inputFile is not a file
     */
    List<String> readLines(File inputFile);

    /**
     * check if a line contains the regex pattern passed by user          *
     * @param line input string
     * @return true if there is a match
     */
    boolean containsPattern(String line);

    /**
     * Write lines to a file
     *
     * FileOutputStream for writing data toa file or a fildescriptor, meant to write stream os raw bytes
     * OutputStreamWriter is a bdridge from chracters streams to byte streams encodes bhytes to a specified charset
     * BufferedWriter writes text toa character output stream, buffering chars so the writting is efficient
     *
     * @param lines matched
     * @throws IOException if write failed
     */
    void writeToFile(List<String> lines) throws IOException;

    /**
     * getter for the rootpath string
     * @return rootpath string
     */
    String getRootPath();

    /**
     * setter for the rootpath string
     * @param rootPath
     */
    void setRootPath(String rootPath);

    /**
     * getter for the regex string
     * @return regex string
     */
    String getRegex();

    /**
     * setter for the regex string
     * @param regex
     */
    void setRegex(String regex);

    /**
     * getter for the outfile string
     * @return outfile string
     */
    String getOutFile();

    /**
     * setter for the outfile string
     * @param outFile
     */
    void setOutFile(String outFile);
}