package fr.tyrolium.maxime.launcher;

import javax.swing.JFrame;
import fr.theshark34.swinger.Swinger;
import fr.theshark34.swinger.util.WindowMover;

@SuppressWarnings("serial")
public class LauncherFrame extends JFrame {

    private static LauncherFrame instance;
    public LauncherPanel launcherPanel;

    public LauncherFrame() {
        this.setTitle("Tyrolium Launcher");
        this.setSize(975, 625);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setUndecorated(true);
        this.setIconImage(Swinger.getResource("icon.png"));
        this.setContentPane(launcherPanel = new LauncherPanel());

        WindowMover mover = new WindowMover(this);
        this.addMouseListener(mover);
        this.addMouseMotionListener(mover);

        this.setVisible(true);
    }

    public static void main(String[] args)	{
        Swinger.setSystemLookNFeel();
        Swinger.setResourcePath("/fr/tyrolium/maxime/launcher/ressource/");
        instance = new LauncherFrame();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("----------|Driver [GOOD]|----------");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------|Driver [ERREUR]|----------");
        }
    }

    public static LauncherFrame getInstance()	{
        return instance;
    }

    public LauncherPanel getLauncherPanel()	{
        return this.launcherPanel;
    }
}
