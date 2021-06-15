package program;

import views.WindowBuilder;
import views.WindowID;

public class Main {

    public static void main(String[] args) {


        WindowBuilder.buildWindowAndShow(null, WindowID.LOGIN);
        WindowBuilder.buildWindowAndShow(null, WindowID.SINGIN);

    }

}
