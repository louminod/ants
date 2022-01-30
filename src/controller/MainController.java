package controller;

import model.*;
import view.CustomPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import static java.lang.Thread.sleep;

public class MainController {
    private static JFrame frame;
    private CustomPanel panel;

    public static ConcurrentLinkedQueue<Ant> ants;
    public static ConcurrentLinkedQueue<Colony> colonies;
    public static ConcurrentLinkedQueue<Pheromone> pheromones;
    public static ConcurrentLinkedQueue<Food> food;

    public MainController() {
        ants = new ConcurrentLinkedQueue<>();
        colonies = new ConcurrentLinkedQueue<>();
        pheromones = new ConcurrentLinkedQueue<>();
        food = new ConcurrentLinkedQueue<>();

        this.panel = new CustomPanel();

        frame = new JFrame("Ants simulation");
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(this.panel);
        frame.setVisible(true);
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            Ant ant = new Ant(new Position(frame.getWidth() / 2, frame.getHeight() / 2));
            ants.add(ant);
            ant.start();
        }

        while (true) {
            this.panel.repaint();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static int getFrameHeight() {
        return frame.getSize().height;
    }

    public static int getFrameWidth() {
        return frame.getSize().width;
    }
}
