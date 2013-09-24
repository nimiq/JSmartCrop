package com.mydomain.smartcrop;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.mydomain.smartcrop.operation.AbstractComputerVisionOperation;
import com.mydomain.smartcrop.operation.color.Negative;
import com.mydomain.smartcrop.operation.statistics.StdScoreAnalysis;
import com.mydomain.smartcrop.procedure.AbstractProcedure;
import com.mydomain.smartcrop.procedure.RegularProcedure;

public class QuickProcedureTest {

    private AbstractProcedure proc;
    
    @Before
    public void setUp() throws Exception {
        proc = new RegularProcedure();
    }

    @Test
    public void testGetOperations() {
        assertEquals(proc.getOperations().size(), 3);
    }

    @Test
    public void testAddComputerVisionOperation() {
        int n = proc.getOperations().size();
        AbstractComputerVisionOperation op = new Negative();
        proc.addOperation(op);
        assertEquals(proc.getOperations().size(), n+1);
    }

    @Test
    public void testGetStdScoreAnalysis() {
        assertTrue(proc.getStdScoreAnalysis() instanceof StdScoreAnalysis);
    }

    @Test
    public void testSetStdScoreAnalysis() {
//        StdScoreAnalysis s = new StdScoreAnalysis();
//        proc.setStdScoreAnalysis(s);
//        assertSame(s, proc.getStdScoreAnalysis());
;    }

}
