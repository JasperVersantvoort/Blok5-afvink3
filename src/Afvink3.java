// Naam: Jasper Versantvoort
// Blok 5 afvink 2
// Teken watermolecul

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Afvink3 extends JFrame implements ActionListener {
    private JTextField xtext;
    private JLabel uitleg;
    private JLabel xlabel;
    private JButton button;
    private JPanel paper;
    private ArrayList<String> kruisje = new ArrayList<String>();
    private ArrayList<String> bolletje = new ArrayList<String>();


    public static void main(String[] args) throws InterruptedException {
        Afvink3 frame = new Afvink3();
        frame.setSize(500, 500);
        frame.createGui();
        frame.setVisible(true);

    }

    private void createGui() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());

        xlabel = new JLabel("Voer nummer van vakje in");
        window.add(xlabel);

        xtext = new JTextField(3);
        window.add(xtext);


        button = new JButton("Start");
        window.add(button);
        button.addActionListener(this);

        paper = new JPanel();
        paper.setPreferredSize(new Dimension(300, 300));
        paper.setBackground(Color.white);
        window.add(paper);
        paper.setVisible(true);

        uitleg = new JLabel("Druk op start, Daarna geef je aan welk vakje je wilt");
        window.add(uitleg);
    }


    public void actionPerformed(ActionEvent event) {
        // actie die wordt uitgvoerd wnr buton wordt ingeklikt

        switch (button.getText()) {
            case "Start" -> {
                Graphics tekenveld = paper.getGraphics();
                tekenveld.drawLine(100, 0, 100, 300);
                tekenveld.drawLine(200, 0, 200, 300);
                tekenveld.drawLine(0, 100, 300, 100);
                tekenveld.drawLine(0, 200, 300, 200);
                tekenveld.drawString("1", 10, 10);
                tekenveld.drawString("2", 110, 10);
                tekenveld.drawString("3", 210, 10);
                tekenveld.drawString("4", 10, 110);
                tekenveld.drawString("5", 110, 110);
                tekenveld.drawString("6", 210, 110);
                tekenveld.drawString("7", 10, 210);
                tekenveld.drawString("8", 110, 210);
                tekenveld.drawString("9", 210, 210);
                button.setText("Kruisje geef nummer");
                break;
            }
            case "Opnieuw?" -> {
                paper.removeAll();
                paper.revalidate();
                paper.repaint();
                kruisje.clear();
                bolletje.clear();
                xlabel.setText("Voer nummer van vakje in");
                button.setText("Start");
                break;
            }
            case "Kruisje geef nummer" -> {
                if (kruisje.contains(xtext.getText()) || bolletje.contains(xtext.getText())) {
                    xlabel.setText("Vakje al bezet");
                } else {
                    button.setText("Bolletje geef nummer");
                    kruisje.add(xtext.getText());
                    System.out.println("kruisje" + kruisje);
                    switch (xtext.getText()) {
                        case "1" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(20, 20, 80, 80);
                            tekenveld.drawLine(20, 80, 80, 20);
                            break;
                        }
                        case "2" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(120, 20, 180, 80);
                            tekenveld.drawLine(120, 80, 180, 20);
                            break;
                        }
                        case "3" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(220, 20, 280, 80);
                            tekenveld.drawLine(220, 80, 280, 20);
                            break;
                        }
                        case "4" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(20, 120, 80, 180);
                            tekenveld.drawLine(20, 180, 80, 120);
                            break;
                        }
                        case "5" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(120, 120, 180, 180);
                            tekenveld.drawLine(120, 180, 180, 120);
                            break;
                        }
                        case "6" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(220, 120, 280, 180);
                            tekenveld.drawLine(220, 180, 280, 120);
                            break;
                        }
                        case "7" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(20, 220, 80, 280);
                            tekenveld.drawLine(20, 280, 80, 220);
                            break;
                        }
                        case "8" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(120, 220, 180, 280);
                            tekenveld.drawLine(120, 280, 180, 220);
                            break;
                        }
                        case "9" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawLine(220, 220, 280, 280);
                            tekenveld.drawLine(220, 280, 280, 220);
                            break;
                        }

                    }
                    if (kruisje.contains("1") && kruisje.contains("2") && kruisje.contains("3")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 250, 50);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("4") && kruisje.contains("5") && kruisje.contains("6")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 150, 250, 150);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("7") && kruisje.contains("8") && kruisje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 250, 250, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("1") && kruisje.contains("4") && kruisje.contains("7")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 50, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("2") && kruisje.contains("5") && kruisje.contains("8")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(150, 50, 150, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("3") && kruisje.contains("6") && kruisje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(250, 50, 250, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("1") && kruisje.contains("5") && kruisje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 250, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else if (kruisje.contains("3") && kruisje.contains("5") && kruisje.contains("7")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 250, 50, 250);
                        xlabel.setText("Kruisje wint!!");
                        button.setText("Opnieuw?");
                    } else {

                    }
                }
                break;
            }
            case "Bolletje geef nummer" -> {
                if (kruisje.contains(xtext.getText()) || bolletje.contains(xtext.getText())) {
                    xlabel.setText("Vakje al bezet");
                } else {
                    button.setText("Kruisje geef nummer");
                    bolletje.add(xtext.getText());
                    System.out.println("bolletje" + bolletje);
                    switch (xtext.getText()) {
                        case "1" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(10, 10, 80, 80);
                            break;
                        }
                        case "2" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(110, 10, 80, 80);
                            break;
                        }
                        case "3" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(210, 10, 80, 80);
                            break;
                        }
                        case "4" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(10, 110, 80, 80);
                            break;
                        }
                        case "5" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(110, 110, 80, 80);
                            break;
                        }
                        case "6" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(210, 110, 80, 80);
                            break;
                        }
                        case "7" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(10, 210, 80, 80);
                            break;
                        }
                        case "8" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(110, 210, 80, 80);
                            break;
                        }
                        case "9" -> {
                            Graphics tekenveld = paper.getGraphics();
                            tekenveld.drawOval(210, 210, 80, 80);
                            break;
                        }
                    }
                    if (bolletje.contains("1") && bolletje.contains("2") && bolletje.contains("3")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 250, 50);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("4") && bolletje.contains("5") && bolletje.contains("6")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 150, 250, 150);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("7") && bolletje.contains("8") && bolletje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 250, 250, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("1") && bolletje.contains("4") && bolletje.contains("7")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 50, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("2") && bolletje.contains("5") && bolletje.contains("8")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(150, 50, 150, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("3") && bolletje.contains("6") && bolletje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(250, 50, 250, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("1") && bolletje.contains("5") && bolletje.contains("9")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 50, 250, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    } else if (bolletje.contains("3") && bolletje.contains("5") && bolletje.contains("7")) {
                        Graphics tekenveld = paper.getGraphics();
                        tekenveld.drawLine(50, 250, 50, 250);
                        xlabel.setText("Bolletje wint!!");
                        button.setText("Opnieuw?");
                    }
                }
            }
        }
    }
}