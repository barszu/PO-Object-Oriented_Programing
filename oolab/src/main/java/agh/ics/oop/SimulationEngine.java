package agh.ics.oop;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimulationEngine {
    private final ArrayList<Simulation> simulations;
    SimulationEngine(ArrayList<Simulation> simulations) {
        this.simulations = simulations;
    }

    public void runSync() {
        for(Simulation simulation : this.simulations) {
            simulation.run();
        }
    }
    public synchronized void runASync() {
        for(Simulation simulation : this.simulations) {
            simulation.start();
            awaitSimulationsEnd(simulation);
        }
    }

    public void awaitSimulationsEnd(Simulation simulation) {
        try {
            simulation.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void runAsyncInThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for(Simulation simulation : this.simulations) {
            executorService.submit(simulation);
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
