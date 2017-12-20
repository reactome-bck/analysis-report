package org.reactome.server.tools.analysis.exporter.playground.pdfelement.table;

import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.VerticalAlignment;
import org.reactome.server.tools.analysis.exporter.playground.constant.FontSize;
import org.reactome.server.tools.analysis.exporter.playground.model.DataSet;

import java.util.stream.Stream;

/**
 * @author Chuan-Deng <dengchuanbio@gmail.com>
 */
public class IdentifiersWasNotFoundTableNoEXP extends Table {

    private static final int numColmns = 6;
    private static final int leftMargin = 40;

    public IdentifiersWasNotFoundTableNoEXP(DataSet dataSet) {
        super(new float[numColmns]);
        this.setWidthPercent(100)
                .setMarginLeft(leftMargin)
                .setFontSize(FontSize.H6)
                .setTextAlignment(TextAlignment.CENTER)
                .setVerticalAlignment(VerticalAlignment.MIDDLE)
                .addHeaderCell(new Cell(1, numColmns).add("Identifiers"));
        Stream.of(dataSet.getIdentifiersWasNotFounds()).forEach(identifier -> this.addCell(new Cell().add(identifier.getId())));

        for (int i = 0; i < numColmns - dataSet.getIdentifiersWasNotFounds().length % numColmns; i++) {
            this.addCell(new Cell());
        }
    }
}