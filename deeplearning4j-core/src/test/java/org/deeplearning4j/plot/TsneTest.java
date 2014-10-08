package org.deeplearning4j.plot;

import org.junit.Test;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * Created by agibsonccc on 10/1/14.
 */
public class TsneTest {

    @Test
    public void testTsne() throws Exception {
        Tsne calculation = new Tsne.Builder().setMaxIter(10000)
                .normalize(true).useAdaGrad(true).learningRate(1e-1f)
                .build();
        ClassPathResource resource = new ClassPathResource("/mnist2500_X.txt");
        File f = resource.getFile();
        INDArray data = Nd4j.readTxt(f.getAbsolutePath(),"   ");
        data = data.getRows(new int[]{0,5});
        //assertTrue(Arrays.equals(new int[]{2500,784},data.shape()));
        calculation.calculate(data,2,20);
    }


}
