package org.reactome.server.tools.pdf.exporter.playground.diagramexporter;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * @author Chuan Deng <cdeng@ebi.ac.uk>
 */
@SpringBootTest
public class DiagramExportDemoTests {

    @Test
    public void test() throws Exception {
        String stId="R-HSA-169911";
        BufferedImage BufferedImage = DiagramExporter.getBufferedImage(stId);
        final File file = new File("src/main/resources/diagrams/"+stId + ".png");
        ImageIO.write(BufferedImage, "png", file);
    }
}