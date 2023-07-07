import Interfaces.Controller;
import Interfaces.Model;
import Interfaces.View;

class Main {
    public static void main(String[] args) {
        View view = new ViewSimple();
        Model model = new ModelSimple();

        Controller controller = new ControllerSimple(model, view);
        controller.runProgramm();
    }
}