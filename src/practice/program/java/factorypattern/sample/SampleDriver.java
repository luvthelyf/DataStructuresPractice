package practice.program.java.factorypattern.sample;

import practice.program.java.factorypattern.sample.detector.FirstDetector;
import practice.program.java.factorypattern.sample.detector.SecondDetector;
import practice.program.java.factorypattern.sample.detector.ThirdDetector;

public class SampleDriver {
    DataClass1 a = new DataClass1();
    DataClass2 b = new DataClass2();
    DataClass3 c = new DataClass3();


    public DataClass1 getA() {
        return a;
    }

    public DataClass2 getB() {
        return b;
    }

    public DataClass3 getC() {
        return c;
    }
    public static void main(String[] args) {
        SampleDriver driver = new SampleDriver();
        SampleManager manager = new SampleManager();
        manager.registerDetectors(0, new FirstDetector(driver));
        manager.registerDetectors(1, new SecondDetector(driver));
        manager.registerDetectors(2, new ThirdDetector(driver));

        manager.initializeFields();
    }
}
