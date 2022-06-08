public class CatsAndAMouseDebug {
    public static void main(String[] args) {
        CatsAndAMouseDebug c = new CatsAndAMouseDebug();
        c.solve();
    }

    public void solve() {
        int catA = 1;
        int catB = 2;
        int mouseC = 3;

        int catADist = Math.abs(mouseC - catA);
        int catBDist = Math.abs(mouseC - catB);

        // Logic
        if (catADist == catBDist) {
            System.out.println("Mouse C");
        } else if (catADist < catBDist) {
            System.out.println("Cat A");
        } else {
            System.out.println("Cat B");
        }
    }
}
