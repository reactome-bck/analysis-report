package org.reactome.server.tools.analysis.exporter.playground.test;

import org.junit.Test;

import java.io.File;

/**
 * @author Chuan-Deng <dengchuanbio@gmail.com>
 */
public class Cleaner {
    @Test
    public void clean() throws Exception {
        for (File file : new File("src/test/resources/pdfs").listFiles()) file.delete();
    }
}