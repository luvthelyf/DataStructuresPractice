package lld.parkinglot.controller;

import lld.parkinglot.exceptions.NoSuchEntryGateException;
import lld.parkinglot.exceptions.NoSuchExitGateException;
import lld.parkinglot.model.gate.EntryGate;
import lld.parkinglot.model.gate.ExitGate;
import lld.parkinglot.model.gate.Gate;

import java.util.Set;

public class GateController {

    Set<Gate> entryGates;
    Set<Gate> exitGates;

    public GateController(Set<Gate> entryGate, Set<Gate> exitGate) {
        this.exitGates = exitGate;
        this.entryGates = entryGate;
    }

    public void onVehicleEntered(EntryGate entryGate) {
        if (entryGates.contains(entryGate)) {
            entryGate.allowEntry();
        } else
            throw new NoSuchEntryGateException();
    }

    public void onVehicleExit(ExitGate exitGate) {
        if (exitGates.contains(exitGate)) {
            exitGate.allowExit();
        } else
            throw new NoSuchExitGateException();
    }
}
