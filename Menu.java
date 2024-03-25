package Wordle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JPanel panel1, panel2;
    JLabel wordle, hint;
    JButton play, vi, exit;

    public Menu(){
        Color color = new Color(174, 55, 255);
        panel1 = new JPanel();
        panel1.setBackground(color);
        panel2 = new JPanel();
        panel2.setBackground(color);
        wordle = new JLabel("Wordle");
        wordle.setFont(new Font("Arial", Font.BOLD, 25));
        wordle.setForeground(Color.black);
        hint = new JLabel("Get 6 chances to  guess a 5-letter word");
        hint.setForeground(Color.BLACK);
        hint.setFont(new Font("Arial", Font.ITALIC, 18));
        play = new JButton("Play");
        play.setFont(new Font("Arial", Font.PLAIN, 16));
        play.setFocusable(false);
        play.setBackground(Color.gray);
        play.setForeground(Color.white);
        vi = new JButton("View Instructions");
        vi.setFont(new Font("Arial", Font.PLAIN, 16));
        vi.setFocusable(false);
        vi.setBackground(Color.gray);
        vi.setForeground(Color.white);
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial", Font.PLAIN, 16));
        exit.setFocusable(false);
        exit.setBackground(Color.gray);
        exit.setForeground(Color.white);


        setDefaultCloseOperation(3);
        setVisible(true);
        setSize(350, 200);
        setLocationRelativeTo(null);
        setTitle("Wordle Menu");
//        setResizable(false);

        play.addActionListener(this);
        vi.addActionListener(this);
        exit.addActionListener(this);
    }

    public void addComponents(){
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints c1 = new GridBagConstraints();

        c1.gridx = 0;
        c1.gridy = 0;
        panel1.add(wordle, c1);

        c1.gridx = 0;
        c1.gridy = 1;
        c1.weighty = 0.1;
        panel1.add(hint, c1);


        panel2.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        c.gridx = 0;
        c.gridy = 2;
        c.fill = c.HORIZONTAL;
        c.weighty = 0.1;
        panel2.add(play, c);

        c.gridx = 0;
        c.gridy = 3;
        c.fill = c.HORIZONTAL;
        panel2.add(vi, c);

        c.gridx = 0;
        c.gridy = 4;
        c.fill = c.HORIZONTAL;
        panel2.add(exit, c);


        setLayout(new BorderLayout());
        add(panel1, BorderLayout.NORTH);
        add(panel2, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e){
        Wordle wordle = new Wordle();
        if(e.getSource().equals(play)){
            new GuiWordle().playGame();
        }else if(e.getSource().equals(vi)){
             JOptionPane.showMessageDialog(this, "1. You are to guess a 5 letter word chosen at random" + "\n2. You can guess the word clicking the character from the virtual keypad" +
                    "\n3. You have a maximum of 6 guesses" ,
                    "Instructions", JOptionPane.INFORMATION_MESSAGE);
        }else if(e.getSource().equals(exit)){
            JOptionPane.showConfirmDialog(this,"Are you sure you want to exit", "Option", JOptionPane.YES_NO_OPTION);
            if(JOptionPane.YES_OPTION == 0){
                System.exit(0);
            }
        }
    }
    public static void main(String[] args) {
        Menu mn = new Menu();
        mn.addComponents();
    }
}
