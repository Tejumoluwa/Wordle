package Wordle;

public class Player {
    private String name;
    private int score;
    public Player(String nm, int sc){
        this.name = nm;
        this.score = sc;
    }
    public int addScore(){
        return this.score += 5;
    }

    public void showScore(){

        System.out.println(getName() + " your score is " + getScore());
    }
    public String getName(){
        return name;
    }

    public int getScore(){
        return score;
    }

    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {

    }
}
