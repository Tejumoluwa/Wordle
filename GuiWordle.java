package Wordle;

import javax.swing.*;
import java.awt.*;

public class GuiWordle extends JFrame {
    private JPanel word_guessed, guessing, keypad, key1, key2, key3, notify, center;
    private JLabel wordle, clues, words;
    private JButton a, b, c, d, e,f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, enter;
    private JTextField word;

    public GuiWordle(){
        center = new JPanel();
        center.setLayout(new GridLayout(1, 2));
        notify = new JPanel();
        notify.setLayout(new FlowLayout());
        wordle = new JLabel("Wordle");
        wordle.setFont(new Font("Serif", Font.BOLD, 35));
        wordle.setForeground(new Color(125,89,100));

        guessing = new JPanel();
//        guessing.setBackground(new Color(255, 0, 0));
        GridBagConstraints gc1 = new GridBagConstraints();
        guessing.setLayout(new GridBagLayout());
        clues = new JLabel("Clues");
        clues.setFont(new Font("serif", Font.BOLD, 25));
        gc1.gridx = 5;
        gc1.gridy = 5;
        guessing.add(clues, gc1);
        clues.setSize(100,0);
        word = new JTextField(10);
        word.setFont(new Font("Serif", Font.BOLD, 25));
        gc1.gridx = 5;
        gc1.gridy = 6;
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

        keypad = new JPanel();
        GridBagConstraints gc = new GridBagConstraints();
        keypad.setLayout(new GridBagLayout());
        keypad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0,255,0)));

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

        word_guessed = new JPanel();
        words = new JLabel("Words Guessed");
        words.setFont(new Font("Serif", Font.BOLD, 25));
        word_guessed.add(words);


        notify.add(wordle);
        center.add(word_guessed);
        center.add(guessing);
        setLayout(new BorderLayout());
        add(notify, BorderLayout.NORTH);
        add(keypad, BorderLayout.SOUTH);
        add(center, BorderLayout.CENTER);
        setSize(800, 650);
        setVisible(true);

        setTitle("Wordle");
        setDefaultCloseOperation(3);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        new GuiWordle();
    }
}
