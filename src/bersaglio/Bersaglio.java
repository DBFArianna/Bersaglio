package bersaglio;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Bersaglio {

    public static void main(String[] args) {
//        creiamo la finestra e le diamo un titolo
        JFrame frame = new JFrame("il mio bersaglio");
//        definire cosa succede quando si schiaccia sulla X rossa
//        esci quando schiacci sulla X rossa
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Inizializziamo la classe Jbersaglio
        JBersaglio panel = new JBersaglio();
//        Bisogna dire che il panel è contenuto nel frame
//        quindi aggiungiamo il panel ne ContentPane che è il contenitore
        frame.getContentPane().add(panel);
//        Organizza la disposizione delle componenti
//        a seconda del layout e dal dispositivo
        frame.pack();
//        Setta la visibilità a true
        frame.setVisible(true);

    }

}

//     classe che estende JPanel settare il loyut della finestra
class JBersaglio extends JPanel {

//        dichiariamo il numero di cerchi
    int cerchi = 5;
//        dichiariamo tre variabili int
//        le coordinate x e y, il diametro del cerchio 
    int x = 0, y = 0, diametro = 300;
//        dichiariamo delta come il rapporto
//        tra il diametro e il doppio dei cerchi -3
    int delta = diametro / (2 * cerchi) - 3;

    public JBersaglio() {
//        per settare il colore di sfondo della finestra
        setBackground(Color.BLACK);
//        per settare le dimensioni preferite in pixel
        setPreferredSize(new Dimension(300, 300));
    }

//    Tracciamento della grafica
//    Creiamo i cerchi
//    Li passiamo come parametro la parte grafica
    @Override
    public void paintComponent(Graphics page) {
//        Devo richiamare al paintComponent già esistente
//        che mi passa la parte grafica
        super.paintComponent(page);

        for (int i = 0; i < cerchi; i++) {
            if (i % 2 == 0) {
//        Settiamo il colore delle linee (foreground)
                page.setColor(Color.DARK_GRAY);
            } else {
//        Settiamo il colore delle linee (forground)
                page.setColor(Color.LIGHT_GRAY);
            }
//        tracciamo il cerchio all'interno del panel
//        con fillOval mettendo le coordinate uguali
//        se le mettessimo diverse traccerebbe un ovale
            page.fillOval(x, y, diametro, diametro);
//            incrementiamo x e y del valore di delta
//            togliamo al diametro il doppio di delta
            x += delta;
            y += delta;
            diametro -= 2 * delta;
        }
//	  settiamo il colore del cerchio centrale
        page.setColor(Color.red);
//        creiamo il cerchio centrale
        page.fillOval(x, y, diametro, diametro);

    }

}
