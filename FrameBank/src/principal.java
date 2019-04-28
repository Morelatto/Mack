
public class principal {

    public static void main(String args[]) {
        Bank listaConta = new Bank("entrada.txt");
        FrameBank form = new FrameBank();
        form.setVisible(true);
    }
}
