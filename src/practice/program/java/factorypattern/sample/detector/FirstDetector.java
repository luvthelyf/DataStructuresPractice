package practice.program.java.factorypattern.sample.detector;

import practice.program.java.factorypattern.sample.IDetectorCreator;
import practice.program.java.factorypattern.sample.SampleDriver;

public class FirstDetector implements IDetectorCreator {
    SampleDriver manager;
    public FirstDetector(SampleDriver manager){
        this.manager = manager;
    }
    @Override
    public void initializeField() {
        manager.getA().display();
    }
}
