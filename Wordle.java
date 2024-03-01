package Wordle;

import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Wordle {
    int lives = 6, rnd;
    String feedback, hiddenWord, guess;
    String[] words ={"cabin", "eager", "habit", "labor", "sober"};

    public void playGame(){
        Random rd = new Random();
        rnd = rd.nextInt(4);
        hiddenWord = words[rnd];
        rules();
        for(int i = 0; i < 6; i++){
            System.out.println("You have " + lives + " lives remaining");
            lives -= 1;
            guess = GetInput();
            feedback = GetFeedBack();
            if(feedback.equals("break")){
                break;
            }else{
                System.out.println("Oops looks like you didn't get it");
            }
        }
    }
    public void rules(){
        System.out.println("Welcome to Wordle, a game you guess a 5 letter word. There are clues to help you along the way.\n" +
                "_________________________________________Clues_______________________________________\n"+
                "If you see '*', the letter in the word you guessed is correct and in the right position\n" +
                "If you see '+', the letter is in the word but in the wrong position.\n" +
                "If you see 'x', the letter is not in the word." +
                "Enjoy your game!!");
        System.out.println("______________________________________________________");
        System.out.println("Remember you have 5 chances");
    }
    public String GetInput(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print("Give me a five letter word: ");
            String guess = input.next().toLowerCase(Locale.ROOT);
            if(guess.length() == 5) return guess;
        }
    }

    public String GetFeedBack(){
        String word2 = "";
        if(guess.equals(hiddenWord)){
            System.out.println("You are correct!!");
            return "break";
        }else{
            for(int i = 0; i < guess.length(); i++){
                if (hiddenWord.charAt(i) == guess.charAt(i)){
                    word2 += "*";
                }else if(contains(guess.charAt(i))){
                    word2 += "+";
                }else{
                    word2 += "x";
                }
            }
        }
        System.out.println(word2);
        return "";
    }

    public boolean contains(char i){
        if(hiddenWord.indexOf(i) == -1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("What is your name: ");
        String name;
        int score = 0;
        Scanner input = new Scanner(System.in);
        name = input.next();
        Player p1 = new Player(name, score);
        Wordle wd = new Wordle();
        wd.playGame();
        p1.addScore();
        System.out.println("Do you want to see your score");
        String option = input.next();
        if(option.equals("yes")){
            p1.showScore();
        }
    }

}
