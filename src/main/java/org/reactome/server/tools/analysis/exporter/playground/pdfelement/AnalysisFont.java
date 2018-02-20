package org.reactome.server.tools.analysis.exporter.playground.pdfelement;

import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;

import java.io.IOException;

/**
 * @author Pascual/Chuan-Deng dengchuanbio@gmail.com
 */
public class AnalysisFont {

    public static PdfFont LIGHT;
    public static PdfFont REGULAR;
    public static PdfFont BOLD;

    private void updateFonts() {
        // Every PDF must load the fonts again, as they are hold by one, and only one document
        try {
//            final String resource = getClass().getResource("fonts/Open_Sans").getFile();
//            PdfFontFactory.registerDirectory(resource);
            PdfFontFactory.registerDirectory("src/main/resources/fonts/Open_Sans");
            LIGHT = PdfFontFactory.createRegisteredFont("open sans light");
            REGULAR = PdfFontFactory.createRegisteredFont("open sans");
            BOLD = PdfFontFactory.createRegisteredFont("open sans bold");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setUp() {
        new AnalysisFont().updateFonts();
    }
}