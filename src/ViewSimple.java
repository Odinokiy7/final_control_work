import Interfaces.View;

public class ViewSimple implements View<String> {

    @Override
    public void showData(String data) {
        System.out.println(data);
    }
}