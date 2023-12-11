package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.SimulationEngine;
import agh.ics.oop.model.WorldMap;
import agh.ics.oop.model.models.MoveDirection;
import agh.ics.oop.model.models.Vector2d;
import agh.ics.oop.model.observers.MapChangeListener;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class SimulationPresenter implements MapChangeListener {
    private WorldMap worldMap;
    public void setWorldMap(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @FXML
    private Label infoLabel;
    @FXML
    private TextField movesListTextField;
    @FXML
    private Label moveInfoLabel;
    @FXML
    private Button startButton;

    @FXML
    public void drawMap() { //setter for infoLabel
        System.out.println("drawMap w SimulationPresenter zadzialalo");
        infoLabel.setText(worldMap.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        Platform.runLater(() -> {
            drawMap();
            // ewentualny inny kod zmieniający kontrolki
        });
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        try {
            startSimulation();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void startSimulation() {
        String[] args = {"f","f","f","r","l","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        List<MoveDirection> movesList = OptionsParser.parse(args);
        List<Vector2d> positionsList = List.of(new Vector2d(2, 2) , new Vector2d(20,20));
        Simulation simulation = new Simulation(movesList, positionsList, worldMap);
//        simulation.run();
        SimulationEngine simulationEngine = new SimulationEngine(new ArrayList<>(List.of(simulation)));
        simulationEngine.runASync();

        Platform.runLater(() -> startButton.setDisable(true));
    }

}
