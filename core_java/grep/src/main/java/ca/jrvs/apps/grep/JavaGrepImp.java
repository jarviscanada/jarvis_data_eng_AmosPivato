package ca.jrvs.apps.grep;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class JavaGrepImp implements JavaGrep {
    final Logger logger = LoggerFactory.getLogger(JavaGrep.class);
    private String regex;
    private String rootPath;
    private String outFile;

    @Override
    public void process() throws IOException {
        List<String> matchedLines = new ArrayList<String>();
        //List<File> files = new ArrayList<File>(listFiles(this.rootPath));
        for (File file : new ArrayList<File>(listFiles(this.getRootPath()))){
            //List<String> lines = new ArrayList<String>(this.readLines(file));
            for (String line : new ArrayList<String>(this.readLines(file))) {
                if (this.containsPattern(line)) {
                    matchedLines.add(line);
                }
            }
        }
        this.writeToFile(matchedLines);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        File root = new File(rootDir);
        File[] listing = root.listFiles();
        List<File> files = new ArrayList<File>();
        try {
            for (File file : listing) {
                //File file = new File(fileS);
                if (file.isFile()) {
                    files.add(file);
                } else {
                    files.addAll(this.listFiles(file.getPath()));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new IllegalArgumentException("input dir argument must be ./sub_dir_path_to_search_through eg: ./dirpath in cwd with out cwd");
        }
        return files;
    }

    @Override
    public List<String> readLines(File inputFile) {
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lines;
    }

    @Override
    public boolean containsPattern(String line) {
        return Pattern.matches(this.getRegex(), line);
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.getOutFile())));
        for (String line : lines) {
            writer.write(line);
            writer.newLine();
        }
        writer.close();
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
        //BasicConfigurator.configure();

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