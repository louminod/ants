import controller.MainController;
import model.Ant;
import model.Colony;
import model.Position;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static MainController controller;

    public static void main(String[] args) throws InterruptedException {
        (new MainController()).run();
    }
}
