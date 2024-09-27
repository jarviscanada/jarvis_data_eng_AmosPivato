package ca.jrvs.apps.grep;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JavaGrepLambdaImp extends JavaGrepImp{

    @Override
    public void process() throws IOException {
        //List<String> matchedLines = new ArrayList<String>();
        //Stream<File> stream = this.listFiles(this.getRootPath()).stream();
        List<String> matchedLines = this.listFiles(this.getRootPath()).stream()
            .flatMap(file -> this.readLines(file).stream().filter(line -> this.containsPattern(line))).collect(Collectors.toList());
        this.writeToFile(matchedLines);
    }

    @Override
    public void writeToFile(List<String> lines) throws IOException {
        Stream<String> stream = lines.stream();
        Files.write(Paths.get(this.getOutFile()), (Iterable<String>)stream::iterator);
    }

    @Override
    public List<File> listFiles(String rootDir) {
        //new implementation to use streams instead of recursion
        if (rootDir == null) {
            return Collections.emptyList();
        }
        List<File> fileList = new ArrayList<>();
        try (Stream<Path> stream = Files.walk(Paths.get(rootDir))) {
            fileList = stream.map(Path::normalize)
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileList;
    }

    @Override
    public List<String> readLines(File inputFile) {
        //new implementation to use streams instead of for loops
        List<String> lines = new ArrayList<>();
        try (Stream<String> stream = Files.lines(Paths.get(String.valueOf(inputFile)))) {
            stream.forEach(lines::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static void main(String[] args) {
        if (args.length !=3) {
            throw new IllegalArgumentException("Usage: JavaGrep regex rootPath outFile");
        }

        JavaGrepLambdaImp javaGrepLambdaImp = new JavaGrepLambdaImp();
        javaGrepLambdaImp.setRegex(args[0]);
        javaGrepLambdaImp.setRootPath(args[1]);
        javaGrepLambdaImp.setOutFile((args[2]));

        try {
            javaGrepLambdaImp.process();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}