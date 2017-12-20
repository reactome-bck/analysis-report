package org.reactome.server.tools.analysis.exporter.playground.model._;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.stream.Stream;

/**
 * @author Chuan-Deng <dengchuanbio@gmail.com>
 */
public class _DataSetTest {
    @Test
    public void test() throws Exception {

        ObjectMapper mapper = new ObjectMapper();
        //ignore some property may not exist in java object
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        _DataSet dataSet = mapper.readValue(new File("src/main/java/org/reactome/server/tools/analysis/exporter/playground/model/_/_DataSet.json"), _DataSet.class);
        Assert.assertEquals(62, dataSet.getVersion());
        assert 62 == dataSet.getVersion();
        Assert.assertEquals(true, dataSet.getDetails().get(0).isInDisease());
        Assert.assertEquals(true, dataSet.getDetails().get(0).isInferred());
        dataSet.getExpNames().stream().forEach(System.out::println);
        Stream.of(dataSet.getDetails()).forEach(System.out::println);
        for (FoundAll foundAll:dataSet.getFoundAll()){
            for (Entity entity:foundAll.getEntities()){
                System.out.println(entity.getMapsTo().toString());
            }
        }
    }
}