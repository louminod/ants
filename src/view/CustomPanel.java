package view;

import controller.MainController;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class CustomPanel extends JPanel {

    private Graphics2D g2d;

    public CustomPanel() {
        this.setBackground(Color.black);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;

        MainController.colonies.forEach(colony -> {
            this.g2d.setColor(Color.green);
            this.g2d.fillOval(colony.getPosition().getX(), colony.getPosition().getY(), 5, 5);
        });

        MainController.ants.forEach(ant -> {
            this.g2d.setColor(Color.white);
            this.g2d.fillOval(ant.getPosition().getX(), ant.getPosition().getY(), 5, 5);
        });

        MainController.pheromones.forEach(pheromone -> {
            if (pheromone.life > 0) {
                pheromone.life--;
                switch (pheromone.getTypePheromone()) {
                    case FOOD:
                        this.g2d.setColor(Color.orange);
                        break;
                    case COLONY:
                        this.g2d.setColor(Color.blue);
                        break;
                }
                this.g2d.fillOval(pheromone.getPosition().getX(), pheromone.getPosition().getY(), 5, 5);
            } else {
                MainController.pheromones.remove(pheromone);
            }
        });

        MainController.food.forEach(food -> {
            this.g2d.setColor(Color.magenta);
            this.g2d.fillOval(food.getPosition().getX(), food.getPosition().getY(), 5, 5);
        });
    }
}
