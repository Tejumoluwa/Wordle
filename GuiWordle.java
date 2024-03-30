package Wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.Random;
import javax.swing.BorderFactory;
import java.awt.Color;

public class GuiWordle extends JFrame implements ActionListener {
    private JPanel word_guessed, guessing, keypad, key1, key2, key3, notify, center;
    private JLabel wordle, clues, words, word, guess1, guess2, guess3, guess4, guess5, guess6;
    private JButton a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, enter, delete;

    String[] arr_words = { "CABIN", "EAGER", "HABIT", "LABOR", "SOBER", "OTHER", "STRAP", "AMBLE", "DRUNK", "LUNCH",
            "MAYBE", "EVERY", "ENTER" };
    StringBuffer str_word;
    int lives = 6, rnd, index = 0;
    Random rd;
    int begin = 0;
    String hiddenWord, word2 = "", check;
    ArrayList<JLabel> arr;

    public GuiWordle() {
        center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        notify = new JPanel();
        notify.setLayout(new FlowLayout());
        wordle = new JLabel("Wordle");
        wordle.setFont(new Font("Serif", Font.BOLD, 35));
        wordle.setForeground(new Color(125, 89, 100));

        guessing = new JPanel();
        // guessing.setBackground(new Color(255, 0, 0));
        GridBagConstraints gc1 = new GridBagConstraints();
        guessing.setLayout(new GridBagLayout());
        clues = new JLabel();
        clues.setFont(new Font("serif", Font.BOLD, 25));
        gc1.gridx = 5;
        gc1.gridy = 5;
        guessing.add(clues, gc1);
        clues.setSize(100, 0);
        word = new JLabel();
        word.setFont(new Font("Serif", Font.BOLD, 25));
        gc1.gridx = 5;
        gc1.gridy = 7;
        guessing.add(word, gc1);

        a = new JButton("A");
        b = new JButton("B");
        c = new JButton("C");
        d = new JButton("D");
        e = new JButton("E");
        f = new JButton("F");
        g = new JButton("G");
        h = new JButton("H");
        i = new JButton("I");
        j = new JButton("J");
        k = new JButton("K");
        l = new JButton("L");
        m = new JButton("M");
        n = new JButton("N");
        o = new JButton("O");
        p = new JButton("P");
        q = new JButton("Q");
        r = new JButton("R");
        s = new JButton("S");
        t = new JButton("T");
        u = new JButton("U");
        v = new JButton("V");
        w = new JButton("W");
        x = new JButton("X");
        y = new JButton("Y");
        z = new JButton("Z");
        enter = new JButton("ENTER");
        delete = new JButton("DELETE");

        keypad = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        keypad.setLayout(new GridBagLayout());

        // Saintcoded comment: wrong implemantation changed from:
        // javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 0) to:
        // BorderFactory.createLineBorder(new Color(0, 255, 0)

        // Saintcoded comment: import the package javax.swing.BorderFactory; then use
        // BorderFactory.createLineBorder same for Color class import java.awt.Color;

        keypad.setBorder(BorderFactory.createLineBorder(new Color(0, 255, 0)));
        key1 = new JPanel();
        key1.setLayout(new FlowLayout());
        key1.add(q);
        key1.add(w);
        key1.add(e);
        key1.add(r);
        key1.add(t);
        key1.add(y);
        key1.add(u);
        key1.add(i);
        key1.add(o);
        key1.add(p);

        gc.gridx = 0;
        gc.gridy = 0;
        keypad.add(key1, gc);

        key2 = new JPanel();
        key2.setLayout(new FlowLayout());
        key2.add(a);
        key2.add(s);
        key2.add(d);
        key2.add(f);
        key2.add(g);
        key2.add(h);
        key2.add(i);
        key2.add(j);
        key2.add(k);
        key2.add(l);

        gc.gridx = 0;
        gc.gridy = 1;
        keypad.add(key2, gc);

        key3 = new JPanel();
        key3.setLayout(new FlowLayout());
        key3.add(delete);
        key3.add(z);
        key3.add(x);
        key3.add(c);
        key3.add(v);
        key3.add(b);
        key3.add(n);
        key3.add(m);
        key3.add(enter);

        gc.gridx = 0;
        gc.gridy = 2;
        keypad.add(key3, gc);

        arr = new ArrayList<>();
        guess1 = new JLabel();
        guess1.setFont(new Font("Serif", Font.BOLD, 18));
        guess2 = new JLabel();
        guess2.setFont(new Font("Serif", Font.BOLD, 18));
        guess3 = new JLabel();
        guess3.setFont(new Font("Serif", Font.BOLD, 18));
        guess4 = new JLabel();
        guess4.setFont(new Font("Serif", Font.BOLD, 18));
        guess5 = new JLabel();
        guess5.setFont(new Font("Serif", Font.BOLD, 18));
        guess6 = new JLabel();
        guess6.setFont(new Font("Serif", Font.BOLD, 18));
        word_guessed = new JPanel();
        words = new JLabel("Words Guessed");
        words.setFont(new Font("Serif", Font.BOLD, 25));
        word_guessed.add(words);
        word_guessed.setLayout(new GridLayout(7, 1));
        word_guessed.add(guess1);
        word_guessed.add(guess2);
        word_guessed.add(guess3);
        word_guessed.add(guess4);
        word_guessed.add(guess5);
        word_guessed.add(guess6);

        rd = new Random();
        rnd = rd.nextInt(arr_words.length);
        str_word = new StringBuffer();
        hiddenWord = arr_words[rnd];

        notify.add(wordle);
        center.add(word_guessed);
        center.add(guessing);
        arr.add(guess1);
        arr.add(guess2);
        arr.add(guess3);
        arr.add(guess4);
        arr.add(guess5);
        arr.add(guess6);
        setLayout(new BorderLayout());
        add(notify, BorderLayout.NORTH);
        add(keypad, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        setSize(800, 650);
        setVisible(true);

        a.addActionListener(this);
        b.addActionListener(this);
        c.addActionListener(this);
        d.addActionListener(this);
        e.addActionListener(this);
        f.addActionListener(this);
        g.addActionListener(this);
        h.addActionListener(this);
        i.addActionListener(this);
        j.addActionListener(this);
        k.addActionListener(this);
        l.addActionListener(this);
        m.addActionListener(this);
        n.addActionListener(this);
        o.addActionListener(this);
        p.addActionListener(this);
        q.addActionListener(this);
        r.addActionListener(this);
        s.addActionListener(this);
        t.addActionListener(this);
        u.addActionListener(this);
        v.addActionListener(this);
        w.addActionListener(this);
        x.addActionListener(this);
        y.addActionListener(this);
        z.addActionListener(this);

        // Saintcoded Comment: Set button focus this method is wrong but due to the way
        // you gui was created i had no option

        a.setFocusable(false);
        b.setFocusable(false);
        c.setFocusable(false);
        d.setFocusable(false);
        e.setFocusable(false);
        f.setFocusable(false);
        g.setFocusable(false);
        h.setFocusable(false);
        i.setFocusable(false);
        j.setFocusable(false);
        k.setFocusable(false);
        l.setFocusable(false);
        m.setFocusable(false);
        n.setFocusable(false);
        o.setFocusable(false);
        p.setFocusable(false);
        q.setFocusable(false);
        r.setFocusable(false);
        s.setFocusable(false);
        t.setFocusable(false);
        u.setFocusable(false);
        v.setFocusable(false);
        w.setFocusable(false);
        x.setFocusable(false);
        y.setFocusable(false);
        z.setFocusable(false);
        delete.setFocusable(false);
        enter.setFocusable(false);
        enter.addActionListener(this);
        delete.addActionListener(this);
        enter.setEnabled(false);
        delete.setEnabled(false);
        setTitle("Wordle");
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }

    public void playGame() {
        for (int i = 0; i < 5; i++) {
            str_word.append("_  ");
        }
        word.setText(str_word.toString());
        // System.out.println(hiddenWord);
    }

    public void actionPerformed(ActionEvent e) {
        String letter = e.getActionCommand();
        delete.setEnabled(true);
        if (index != 6) {
            if (letter.equals("DELETE")) {

                // Saintcoded Comment: disable delete button if there is no entry or entry was
                // deleted

                check = str_word.substring(0, 1);
                if (!(check.equals("_"))) {
                    begin--;
                    str_word.replace((begin * 3), ((begin * 3) + 1), "_");
                    check = str_word.substring(0, 1);
                    if (check.equals("_")) {
                        delete.setEnabled(false);
                    }
                }

            } else if (letter.equals("ENTER")) {
                String str = str_word.toString();
                str = str.replace(" ", "");
                if (hiddenWord.equals(str)) {
                    int score = showScore(index);
                    JOptionPane.showMessageDialog(this, "Congrats you guessed the word \n Score: " + score);
                    confirmExit();
                } else {
                    for (int j = 0; j < str.length(); j++) {
                        if (hiddenWord.charAt(j) == str.charAt(j)) {
                            word2 += "*  ";
                        } else if (hiddenWord.indexOf(str.charAt(j)) != -1) {
                            word2 += "+  ";
                        } else {
                            word2 += "x  ";
                        }
                    }

                    clues.setText(word2);
                    arr.get(index).setText("     " + str);
                    index++;
                    try {
                        Thread.sleep(500);
                    } catch (Exception o) {
                    }
                    str_word = new StringBuffer("");
                    word2 = "";
                    begin = 0;
                    enter.setEnabled(false);
                    playGame();
                }
            } else {
                if (str_word.length() == 15 && begin < 5) {
                    str_word.replace((begin * 3), ((begin * 3) + 1), letter);
                    begin++;
                }

            }

            word.setText(str_word.toString());
            if (begin == 5) {
                enter.setEnabled(true);
                // Saintcoded Comment: disable enter button if entry not equals to 5
            } else {
                enter.setEnabled(false);
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Sorry you have used all of your chances \n the correct word is " + hiddenWord,
                    "Information Message", JOptionPane.INFORMATION_MESSAGE);
            confirmExit();
        }

    }

    public void confirmExit() {
        int n = JOptionPane.showConfirmDialog(this, "Do you want to exit the game", "OPTION",
                JOptionPane.YES_NO_OPTION);
        if (n == 0) {
            System.exit(0);
        } else {
            this.dispose();
            hiddenWord = "";
            GuiWordle wordle = new GuiWordle();
            wordle.playGame();
        }
    }

    public int showScore(int value) {
        int score = 0;
        switch (value) {
            case 0 ->
                score = 30;
            case 1 ->
                score = 25;
            case 2 ->
                score = 20;
            case 3 ->
                score = 15;
            case 4 ->
                score = 10;
            case 5 ->
                score = 5;
        }
        return score;
    }
    public static void main(String[] args) {
        GuiWordle wordle = new GuiWordle();
        wordle.playGame();
    }

}
