package model;

import controller.MainController;

import java.util.Random;

public class Ant extends Thread {
    private Position position;

    public static final int SIZE = 5;

    private boolean up;
    private boolean left;

    private static final int CHANCE_SWITCH_DIRECTION = 80;

    public Ant(Position position) {
        this.position = position;
        this.up = (new Random()).nextBoolean();
        this.left = (new Random()).nextBoolean();
    }

    @Override
    public void run() {
        while (true) {
            this.moveRandomly();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private void moveRandomly() {
        int x = this.position.getX();
        int y = this.position.getY();

        if (x == 0) {
            this.left = false;
        } else if (x == (MainController.getFrameWidth() - 5)) {
            this.left = true;
        } else {
            int random = (int) (Math.random() * CHANCE_SWITCH_DIRECTION);
            if (random == (CHANCE_SWITCH_DIRECTION / 2)) {
                this.left = !this.left;
            }
        }

        if (y == 0) {
            this.up = false;
        } else if (y == (MainController.getFrameHeight() - 40)) {
            this.up = true;
        } else {
            int random = (int) (Math.random() * CHANCE_SWITCH_DIRECTION);
            if (random == (CHANCE_SWITCH_DIRECTION / 2)) {
                this.up = !this.up;
            }
        }

        this.position.setX(left ? x - SIZE : x + SIZE);
        this.position.setY(up ? y - SIZE : y + SIZE);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
