import view.View;

public class Main {
        private final View view;
        Main (){
            view = new View();
        }
    public static void main(String[] args) {
          while(true){
              new Main().view.ui();
              new Main().view.UserDesire();
          }
    }
}
