package practice.program.java.factorypattern.sample.detector;

import practice.program.java.factorypattern.sample.IDetectorCreator;
import practice.program.java.factorypattern.sample.SampleDriver;

public class ThirdDetector implements IDetectorCreator {

    SampleDriver manager;
    public ThirdDetector(SampleDriver manager){
        this.manager = manager;
    }
    @Override
    public void initializeField() {
        manager.getC().display();
    }
}
