package lld.parkinglot.model.gate;

import lld.parkinglot.exceptions.EntryFromWrongGateException;
import lld.parkinglot.exceptions.ExitFromWrongGateException;
import lld.parkinglot.exceptions.IllegalGateStateException;

public class DefaultGate implements EntryGate, ExitGate {

    private GateStatus status;
    private final GateType gateType;

    public DefaultGate(GateType gateType) {
        this.gateType = gateType;
        this.status = GateStatus.CLOSE;
    }

    @Override
    public void open() {
        status = GateStatus.OPEN;
    }

    @Override
    public void close() {
        status = GateStatus.CLOSE;
    }

    @Override
    public void allowPassage() {
        if (status == GateStatus.OPEN) {
            throw new IllegalGateStateException();
        }
        System.out.println("Gate is opened!");
        open();
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                close();
//                System.out.println("Gate is closed!");
//                timer.cancel();
//            }
//        }, 2000);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        close();
        System.out.println("Gate is closed!");
    }

    @Override
    public void allowEntry() {
        if (gateType == GateType.EXIT)
            throw new ExitFromWrongGateException();
        allowPassage();
    }

    @Override
    public void allowExit() {
        if (gateType == GateType.ENTRY)
            throw new EntryFromWrongGateException();
        allowPassage();
    }

    @Override
    public String toString() {
        return "DefaultGate{" +
                "status=" + status +
                ", gateType=" + gateType +
                '}';
    }
}
