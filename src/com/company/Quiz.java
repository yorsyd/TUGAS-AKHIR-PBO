package com.company;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Quiz implements ActionListener{

    String[] pertanyaan = {
                            "1 + 1 Berapa?",
                            "2 + 2 Berapa?",
                            "2 + 3 Berapa?",
                            "2 x 3 Berapa?",
                           };
    String[][] jawaban = {
                            {"5","1","2","4","3"},
                            {"9","1","4","2","3"},
                            {"6","1","2","3","5"},
                            {"3","6","5","1","8"},
                         };

    char[] pilgan = {
                        'A',
                        'B',
                        'C',
                        'D',
                        'E',
                    };

    char tebak; // menampung tebakan
    char jawab; // menampung jawaban
    int index; // deklarasi index
    int tebakanBenar = 0; // menampung tebakan yang benar
    int totalPertanyaan = pertanyaan.length; // banyak pertanyaan
    int hasil; //
    int detik = 10; // untuk gitung mundur

    JFrame bingkai = new JFrame();
    JTextField bidangText = new JTextField(); // menampung pertnyaan terkini yg sdg d bhs
    JTextArea areaText = new JTextArea();
    JButton buttonA = new JButton();
    JButton buttonB = new JButton();
    JButton buttonC = new JButton();
    JButton buttonD = new JButton();
    JButton buttonE = new JButton();
    JLabel labelA_jawab = new JLabel();
    JLabel labelB_jawab = new JLabel();
    JLabel labelC_jawab = new JLabel();
    JLabel labelD_jawab = new JLabel();
    JLabel labelE_jawab = new JLabel();
    JLabel label_waktu = new JLabel();
    JLabel detik_kiri = new JLabel();
    JTextField nomor_kanan = new JTextField();
    JTextField pesentase = new JTextField(); // persentase skor yang di dapat



    public Quiz(){
        bingkai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        bingkai.setSize(400,550);
        bingkai.getContentPane().setBackground(new Color(50,50,50));
        bingkai.setLayout(null);
        bingkai.setResizable(false);

        bidangText.setBounds(0,0,400,50);
        bidangText.setBackground(new Color(25,25,25));
        bidangText.setForeground(new Color(25,255,0));
        bidangText.setFont(new Font("Ink Free",Font.BOLD,30));
        bidangText.setBorder(BorderFactory.createBevelBorder(1));
        bidangText.setHorizontalAlignment(JTextField.CENTER);
        bidangText.setEditable(false);
        bidangText.setText("Quiz Game");
        bidangText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        areaText.setBounds(0,50,400,50);
        areaText.setLineWrap(true);
        areaText.setWrapStyleWord(true);
        areaText.setBackground(new Color(25,25,25));
        areaText.setForeground(new Color(25,255,0));
        areaText.setFont(new Font("Times New Roman",Font.PLAIN,25));
        areaText.setBorder(BorderFactory.createBevelBorder(1));
        areaText.setEditable(false);
        areaText.setText("IKI TEST BOLOِ\n");
        areaText.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        buttonA.setBounds(0,100,50,50);
        buttonA.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonA.setFocusable(false);
        buttonA.addActionListener(this);
        buttonA.setText("A");

        buttonB.setBounds(0,150,50,50);
        buttonB.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonB.setFocusable(false);
        buttonB.addActionListener(this);
        buttonB.setText("B");

        buttonC.setBounds(0,200,50,50);
        buttonC.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonC.setFocusable(false);
        buttonC.addActionListener(this);
        buttonC.setText("C");

        buttonD.setBounds(0,250,50,50);
        buttonD.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonD.setFocusable(false);
        buttonD.addActionListener(this);
        buttonD.setText("D");

        buttonE.setBounds(0,300,50,50);
        buttonE.setFont(new Font("MV Boli",Font.BOLD,20));
        buttonE.setFocusable(false);
        buttonE.addActionListener(this);
        buttonE.setText("E");

        labelA_jawab.setBounds(50,100,500,50);
        labelA_jawab.setBackground(new Color(50,50,50));
        labelA_jawab.setForeground(new Color(25,255,0));
        labelA_jawab.setFont(new Font("MV Boli",Font.PLAIN, 25));


        labelB_jawab.setBounds(50,150,500,50);
        labelB_jawab.setBackground(new Color(50,50,50));
        labelB_jawab.setForeground(new Color(25,255,0));
        labelB_jawab.setFont(new Font("MV Boli",Font.PLAIN, 25));


        labelC_jawab.setBounds(50,200,500,50);
        labelC_jawab.setBackground(new Color(50,50,50));
        labelC_jawab.setForeground(new Color(25,255,0));
        labelC_jawab.setFont(new Font("MV Boli",Font.PLAIN, 25));


        labelD_jawab.setBounds(50,250,500,50);
        labelD_jawab.setBackground(new Color(50,50,50));
        labelD_jawab.setForeground(new Color(25,255,0));
        labelD_jawab.setFont(new Font("MV Boli",Font.PLAIN, 25));


        labelE_jawab.setBounds(50,300,500,50);
        labelE_jawab.setBackground(new Color(50,50,50));
        labelE_jawab.setForeground(new Color(25,255,0));
        labelE_jawab.setFont(new Font("MV Boli",Font.PLAIN, 25));


        detik_kiri.setBounds(305,440,80,80);
        detik_kiri.setBackground(new Color(25,26,28));
        detik_kiri.setForeground(new Color(14,80,0));
        detik_kiri.setFont(new Font("Verdana",Font.BOLD,40));
        detik_kiri.setBorder(BorderFactory.createBevelBorder(1));
        detik_kiri.setOpaque(true);
        detik_kiri.setHorizontalAlignment(JTextField.CENTER);
        detik_kiri.setText(String.valueOf(detik));

        label_waktu.setBounds(295,410,100,25);
        label_waktu.setBackground(new Color(50,89,9));
        label_waktu.setForeground(new Color(77,255,0));
        label_waktu.setFont(new Font("Verdana",Font.PLAIN,14));
        label_waktu.setHorizontalAlignment(JTextField.CENTER);
        label_waktu.setText("Timer > :D");

        bingkai.add(label_waktu);
        bingkai.add(detik_kiri);
        bingkai.add(labelA_jawab);
        bingkai.add(labelB_jawab);
        bingkai.add(labelC_jawab);
        bingkai.add(labelD_jawab);
        bingkai.add(labelE_jawab);
        bingkai.add(buttonA);
        bingkai.add(buttonB);
        bingkai.add(buttonC);
        bingkai.add(buttonD);
        bingkai.add(buttonE);
        bingkai.add(areaText);
        bingkai.add(bidangText);
        bingkai.setVisible(true);
    }

    public void nextQuestion(){

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public void displayAnswer(){

    }

    public void results(){

    }

    public static boolean isArabic(String text) {
        boolean arabicChars = false;
        for (char ch : text.toCharArray()) {
            if (Character.UnicodeBlock.of(ch) == Character.UnicodeBlock.ARABIC) {
                arabicChars = true;
                break;
            }
        }
        return arabicChars;
    }
}
