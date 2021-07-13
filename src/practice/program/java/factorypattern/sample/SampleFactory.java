package practice.program.java.factorypattern.sample;

import java.util.HashMap;
import java.util.Map;

public class SampleFactory {

    private Map<Integer, IDetectorCreator> detectors;

    public SampleFactory() {
        detectors = new HashMap<>();
    }

    public IDetectorCreator getDetector(int type) {
        return detectors.get(type);
    }

    public void registerDetectors(int type, IDetectorCreator detector) {
        detectors.put(type, detector);
    }

    public void initializeFields() {
        for (IDetectorCreator detector : detectors.values()) {
            detector.initializeField();
        }

    }
}
