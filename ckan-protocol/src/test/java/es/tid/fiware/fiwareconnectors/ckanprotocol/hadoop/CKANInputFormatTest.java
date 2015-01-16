/**
 * Copyright 2014 Telefonica Investigación y Desarrollo, S.A.U
 *
 * This file is part of fiware-connectors (FI-WARE project).
 *
 * fiware-connectors is free software: you can redistribute it and/or modify it under the terms of the GNU Affero
 * General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * fiware-connectors is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Affero General Public License along with fiware-connectors. If not, see
 * http://www.gnu.org/licenses/.
 *
 * For those usages not covered by the GNU Affero General Public License please contact with
 * francisco.romerobueno at telefonica dot com
 */

package es.tid.fiware.fiwareconnectors.ckanprotocol.hadoop;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.mapreduce.InputSplit;
import org.apache.hadoop.mapreduce.Job;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.junit.Assert.*; // this is required by "fail" like assertions

/**
 *
 * @author frb
 */
@RunWith(MockitoJUnitRunner.class)
public class CKANInputFormatTest {
    
    /**
     * Test of setCKANEnvironmnet method, of class CKANInputFormat.
     */
    @Test
    public void testSetCKANEnvironmnet() {
        System.out.println("Testing CKANInputFormat.setCKANEnvironmnet (row)");
    } // testSetCKANEnvironmnet

    /**
     * Test of createRecordReader method, of class CKANInputFormat.
     */
    @Test
    public void testCreateRecordReader() {
        System.out.println("Testing CKANInputFormat.createRecordReader (row)");
    } // testCreateRecordReader
    
    /**
     * Test of getSplits method, of class CKANInputFormat.
     */
    @Test
    public void testGetSplits() {
        System.out.println("Testing CKANInputFormat.getSplits (resource)");
        Configuration conf = new Configuration();
        Job job;
        
        try {
            job = Job.getInstance(conf, "testGetSplitsResource");
        } catch (IOException ex) {
            return;
        } // try catch
        
        job.setInputFormatClass(CKANInputFormat.class);
        CKANInputFormat.setCKANEnvironmnet(job, "data.lab.fi-ware.org", "443", true,
                "2d5bf021-ff9f-48e3-bb97-395b77581665");
        CKANInputFormat.addCKANInput(job,
                "https://data.lab.fiware.org/dataset/logrono_cygnus/resource/ca73a799-9c71-4618-806e-7bd0ca1911f4");
        CKANInputFormat inputFormat = new CKANInputFormat();
        List<InputSplit> splits = inputFormat.getSplits(job);
        assertTrue(splits.size() > 0);

        System.out.println("Testing CKANInputFormat.getSplits (package)");
        conf = new Configuration();
        
        try {
            job = Job.getInstance(conf, "testGetSplitsPackage");
        } catch (IOException ex) {
            return;
        } // try catch
        
        job.setInputFormatClass(CKANInputFormat.class);
        CKANInputFormat.setCKANEnvironmnet(job, "data.lab.fi-ware.org", "443", true,
                "2d5bf021-ff9f-48e3-bb97-395b77581665");
        CKANInputFormat.addCKANInput(job, "https://data.lab.fiware.org/dataset/logrono_cygnus");
        inputFormat = new CKANInputFormat();
        splits = inputFormat.getSplits(job);
        assertTrue(splits.size() > 0);
        
        System.out.println("Testing CKANInputFormat.getSplits (organization)");
        conf = new Configuration();
        
        try {
            job = Job.getInstance(conf, "testGetSplitsOrganization");
        } catch (IOException ex) {
            return;
        } // try catch
        
        job.setInputFormatClass(CKANInputFormat.class);
        CKANInputFormat.setCKANEnvironmnet(job, "data.lab.fi-ware.org", "443", true,
                "2d5bf021-ff9f-48e3-bb97-395b77581665");
        CKANInputFormat.addCKANInput(job, "https://data.lab.fiware.org/organization/logrono");
        inputFormat = new CKANInputFormat();
        splits = inputFormat.getSplits(job);
        assertTrue(splits.size() > 0);
    } // testGetSplits
    
} // CKANInputFormatTest
