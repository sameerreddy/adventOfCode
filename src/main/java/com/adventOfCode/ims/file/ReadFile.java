package com.adventOfCode.ims.file;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class ReadFile {

    public static Stream<String> readAllLinesInFile(URI inputFileName) throws IOException {
        Path path = Paths.get(inputFileName);
        Stream<String> strings = Files.lines(path);
        return strings;
    }
}
