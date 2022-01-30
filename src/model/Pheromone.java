package model;

public class Pheromone {
    private TypePheromone typePheromone;
    private Position position;

    public int life;

    public Pheromone(TypePheromone typePheromone, Position position) {
        this.typePheromone = typePheromone;
        this.position = position;
        this.life = 50;
    }

    public TypePheromone getTypePheromone() {
        return typePheromone;
    }

    public void setTypePheromone(TypePheromone typePheromone) {
        this.typePheromone = typePheromone;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
