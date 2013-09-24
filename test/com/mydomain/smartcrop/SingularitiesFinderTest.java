package com.mydomain.smartcrop;

import static org.junit.Assert.assertEquals;

import java.awt.image.BufferedImage;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.smartcrop.operation.statistics.AbstractSamples;
import com.mydomain.smartcrop.operation.statistics.ColumnSamples;
import com.mydomain.smartcrop.operation.statistics.RowSamples;
import com.mydomain.smartcrop.operation.statistics.Singularities;
import com.mydomain.smartcrop.operation.statistics.SingularitiesFinder;
import com.mydomain.smartcrop.utils.IOImage;

public class SingularitiesFinderTest {

    private SingularitiesFinder rowFinder;
    private SingularitiesFinder colFinder;
    private AbstractSamples rowSamples;
    private AbstractSamples colSamples;
    private List<Float> rowScores;
    private List<Float> colScores;
    
    @Before
    public void setUp() throws Exception {
        String path = "test/resources/1.png";
        BufferedImage image = IOImage.getImage(path);
        rowSamples = new RowSamples(image);
        colSamples = new ColumnSamples(image);
        rowScores = rowSamples.getStdScores().getScores();
        colScores = colSamples.getStdScores().getScores();
        rowFinder = new SingularitiesFinder(rowScores);
        colFinder = new SingularitiesFinder(colScores);
    }

    @Test
    public void testGetSingularities() {
        Singularities singR = rowFinder.getSingularities();
        assertEquals(singR.getX0(), 34);
        assertEquals(singR.getX1(), 308);
        Singularities singC = colFinder.getSingularities();
        assertEquals(singC.getX0(), 33);
        assertEquals(singC.getX1(), 228);
    }

    @Test
    public void testGetSingularitiesFloatIntInt() {
        //Useless to test this
    }

    @Test
    public void testGetFirstSingularity() {
        assertEquals(rowFinder.getFirstSingularity(rowScores), 34);
    }

}
