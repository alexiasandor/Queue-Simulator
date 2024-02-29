package GUI;

import BusinessLogic.SimulationManager;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JPanel;
import javax.swing.text.StyleConstants.ColorConstants;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class SimulationFrame extends JFrame {
    private JTextField timp_min_sosire;
    private JTextField timp_max_sosire;
    private JTextField timp_min_serv;
    private JTextField timp_max_serv;
    private JTextField nrClienti;
    private JTextField nrCozi;
    private JTextField field_limitTime;
    private SimulationFrame frame=this;
    private JTextArea textArea;




    public SimulationFrame() {
        setTitle("Simulare Cozi");
        getContentPane().setBackground(new Color(33, 22, 105));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(45, 30, 145));
        panel.setBounds(20, 10, 543, 498);
        panel.setLayout(null);
        getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 242, 216));
        panel_1.setBounds(10, 21, 505, 446);
        panel_1.setLayout(null);
        panel.add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(new Color(244, 243, 232));
        panel_2.setBounds(0, 83, 505, 280);
        panel_2.setLayout(null);
        panel_1.add(panel_2);

        JLabel tmins = new JLabel("Timp minim de sosire");
        tmins.setBounds(8, 69, 122, 13);
        panel_2.add(tmins);

        JLabel tmaxs = new JLabel("Timp maxim de sosire");
        tmaxs.setBounds(10, 92, 107, 13);
        panel_2.add(tmaxs);

        JLabel tminserv = new JLabel("Timp minim de servire");
        tminserv.setBounds(8, 115, 107, 13);
        panel_2.add(tminserv);

        JLabel tmaxserv = new JLabel("Timp maxim de servire");
        tmaxserv.setBounds(8, 138, 122, 13);
        panel_2.add(tmaxserv);

        timp_min_sosire = new JTextField();
        timp_min_sosire.setBounds(127, 66, 68, 19);
        panel_2.add(timp_min_sosire);
        timp_min_sosire.setColumns(10);

        timp_max_sosire = new JTextField();
        timp_max_sosire.setBounds(127, 89, 68, 19);
        panel_2.add(timp_max_sosire);
        timp_max_sosire.setColumns(10);

        timp_min_serv = new JTextField();
        timp_min_serv.setBounds(125, 112, 70, 19);
        panel_2.add(timp_min_serv);
        timp_min_serv.setColumns(10);

        timp_max_serv = new JTextField();
        timp_max_serv.setBounds(127, 135, 68, 19);
        panel_2.add(timp_max_serv);
        timp_max_serv.setColumns(10);

        textArea = new JTextArea();
        textArea.setBounds(238, 19, 257, 251);
        panel_2.add(textArea);

        JLabel nrCl = new JLabel("Nr.clienti");
        nrCl.setBounds(10, 10, 45, 13);
        panel_2.add(nrCl);

        nrClienti = new JTextField();
        nrClienti.setBounds(63, 7, 22, 19);
        panel_2.add(nrClienti);
        nrClienti.setColumns(10);

        JLabel nrCzi = new JLabel("Nr.cozi");
        nrCzi.setBounds(10, 33, 45, 13);
        panel_2.add(nrCzi);

        nrCozi = new JTextField();
        nrCozi.setBounds(63, 30, 22, 19);
        panel_2.add(nrCozi);
        nrCozi.setColumns(10);

        JLabel limTime = new JLabel("Timp limita");
        limTime.setBounds(8, 161, 95, 13);
        panel_2.add(limTime);

        field_limitTime = new JTextField();
        field_limitTime.setBounds(127, 161, 68, 19);
        panel_2.add(field_limitTime);
        field_limitTime.setColumns(10);

        JScrollPane scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(238, 19, 257, 251);
        panel_2.add(scrollPane);

        JLabel titlu = new JLabel("SIMULARE COZI");
        titlu.setForeground(new Color(159, 165, 236));
        titlu.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
        titlu.setBounds(10, 23, 264, 40);
        panel_1.add(titlu);

        JLabel titlu_1 = new JLabel("SIMULARE COZI");
        titlu_1.setForeground(new Color(159, 165, 236));
        titlu_1.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 30));
        titlu_1.setBounds(268, 23, 237, 40);
        panel_1.add(titlu_1);

        JLabel titlu_2 = new JLabel("SIMULARE COZI");
        titlu_2.setForeground(new Color(53, 0, 106));
        titlu_2.setFont(new Font("Algerian", Font.BOLD | Font.ITALIC, 33));
        titlu_2.setBounds(122, 46, 264, 40);
        panel_1.add(titlu_2);

        JLabel design = new JLabel("-----------------");
        design.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design.setBounds(0, 50, 132, 13);
        panel_1.add(design);

        JLabel design_1 = new JLabel("-----------------");
        design_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design_1.setBounds(373, 50, 132, 13);
        panel_1.add(design_1);

        JLabel design_1_1 = new JLabel("-----------------");
        design_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design_1_1.setBounds(0, 10, 132, 13);
        panel_1.add(design_1_1);

        JLabel design_1_2 = new JLabel("-----------------");
        design_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design_1_2.setBounds(122, 10, 132, 13);
        panel_1.add(design_1_2);

        JLabel design_1_3 = new JLabel("-----------------");
        design_1_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design_1_3.setBounds(243, 10, 132, 13);
        panel_1.add(design_1_3);

        JLabel design_1_4 = new JLabel("-------------------");
        design_1_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
        design_1_4.setBounds(363, 10, 142, 13);
        panel_1.add(design_1_4);

        JButton start = new JButton("START");
        start.setFont(new Font("Algerian", Font.BOLD, 10));
        start.setBounds(62, 380, 85, 45);
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimulationManager gen = null;
                try {
                    gen= new SimulationManager(frame);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                Thread t = new Thread (gen);
                t.start();}
        });
     /*   start.addMouseListener(new MouseListener() {

            @Override
            public void mouseReleased(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mousePressed(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // TODO Auto-generated method stub

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                // TODO Auto-generated method stub
                start.setBackground(new Color(159, 165, 236));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                // TODO Auto-generated method stub

            }
        });*/
        panel_1.add(start);


        setSize(600, 600);
        setVisible(true);

    }
    public int getTimp_min_sosire() {
        return Integer.parseInt(timp_min_sosire.getText());
    }

    public int getTimp_max_sosire() {
        return Integer.parseInt(timp_max_sosire.getText());
    }

    public int getTimp_min_serv() {
        return Integer.parseInt(timp_min_serv.getText());
    }

    public int getTimp_max_serv() {
        return Integer.parseInt(timp_max_serv.getText());
    }

    public int getNrClienti() {
        return Integer.parseInt(nrClienti.getText());
    }

    public int getNrCozi() {
        return Integer.parseInt(nrCozi.getText());
    }


    public int getField_limitTime() {
        return Integer.parseInt(field_limitTime.getText());
    }

    public String getTextArea() {
        return textArea.getText();
    }

    public void setTextArea(String textArea) {
        this.textArea.append(String.valueOf(textArea));
    }
}