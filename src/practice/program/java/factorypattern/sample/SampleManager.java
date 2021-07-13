package practice.program.java.factorypattern.sample;

public class SampleManager {


    SampleFactory factory;

    SampleManager() {
        factory = new SampleFactory();
    }

    public void registerDetectors(int i, IDetectorCreator firstDetector) {
        factory.registerDetectors(i, firstDetector);
    }

    public void initializeFields() {
        factory.initializeFields();
    }
}
