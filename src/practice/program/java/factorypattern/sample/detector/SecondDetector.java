package practice.program.java.factorypattern.sample.detector;

import practice.program.java.factorypattern.sample.IDetectorCreator;
import practice.program.java.factorypattern.sample.SampleDriver;

public class SecondDetector implements IDetectorCreator {
    SampleDriver manager;
    public SecondDetector(SampleDriver manager){
        this.manager = manager;
    }
    @Override
    public void initializeField() {
        manager.getB().display();
    }
}
