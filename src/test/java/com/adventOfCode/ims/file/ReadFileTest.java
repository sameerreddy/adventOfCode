package com.adventOfCode.ims.file;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.stream.Stream;

public class ReadFileTest {

    @Test
    public  void readAllLinesInFileTest() throws IOException, URISyntaxException {
        URL uri = this.getClass().getClassLoader().getSystemClassLoader().getResource("ids.txt");
        Stream<String> lines = ReadFile.readAllLinesInFile(uri.toURI());
        Assert.assertTrue(lines.count() >0);
    }
}
