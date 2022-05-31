package ca.jrvs.apps.grep;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaGrepImp implements JavaGrep {

    final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
    private String regex;
    private String rootPath;
    private String outFile;

    @Override
    public void process() throws IOException {

    }

    @Override
    public List<File> listFiles(String rootDir) {
        try {
            File root = new File(rootDir);
            File[] listing = root.listFiles();
            if (listing != null) {
                List<File> files = new ArrayList<File>(Arrays.asList(listing));
                return files;
            }
            else{
                //could maybe use try catch to stop if not dir
                this.logger.error("Error: inputted rootDir must be a dir and contain files");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> readLines(File inputFile) {
        BufferedReader reader;
        List<String> lines = new ArrayList<String>;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public boolean containtsPattern(String line) {

        return false;
    }

    @Override
    public void writeTorFile(List<String> Lines) throws IOException {

    }

    @Override
    public String getRegex() {
        return regex;
    }

    @Override
    public void setRegex(String regex) {
        this.regex = regex;
    }

    @Override
    public String getRootPath() {
        return rootPath;
    }

    @Override
    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

    @Override
    public String getOutFile() {
        return outFile;
    }

    @Override
    public void setOutFile(String outFile) {
        this.outFile = outFile;
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
        }

        BasicConfigurator.configure();

        JavaGrepImp javaGrepImp = new JavaGrepImp();
        javaGrepImp.setRegex(args[0]);
        javaGrepImp.setRootPath(args[1]);
        javaGrepImp.setOutFile((args[2]));

        try {
            javaGrepImp.process();
        } catch (Exception ex) {
            javaGrepImp.logger.error("Error: unable to process", ex);
        }

    }
}
