package ua.com.blackJack;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Mykhailo on 21/12/2017.
 */
public class MainBlackJack {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String string = "";

        Playground playground = new Playground();

        int winsCountPc = 0;
        int winsCountUser = 0;

        File file = new File("BlackjackSource.txt");
        file.createNewFile();
        String score[] = new String[2];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String line = "";
        line = bufferedReader.readLine();
        if (file.exists() && line != null && !line.equals("") && !line.equals("\n")) {
            System.out.print("continue game? (+ || -): ");
            String contin = scanner.next();
            int i = 0;
            if ("+".equals(contin)) {
                while (line != null) {
                    score[i] = line;
                    i++;
                    line = bufferedReader.readLine();
                }
                winsCountPc = Integer.parseInt(score[0].replace("PC=", ""));
                winsCountUser = Integer.parseInt(score[1].replace("USER=", ""));
                scorGame(winsCountUser, winsCountPc);
            } else {
                winsCountPc = 0;
                winsCountUser = 0;
            }
            bufferedReader.close();
        } else {
            winsCountPc = 0;
            winsCountUser = 0;
        }
        playground.newGame();
        playground.showNextCard(Playground.USER);
        int cardShowCount = 1;
        boolean pcTurnEnd = false;

        while (true) {
            System.out.println("pc cards: ");
            playground.drawCard(cardShowCount, Playground.PC);
            if (pcTurnEnd) {
                System.out.print("pc score: ");
                playground.showScore(Playground.PC);
            }

            System.out.println("user cards: ");
            int userCardShowCount = playground.getCountCardOnPlayground(Playground.USER);
            playground.drawCard(userCardShowCount, Playground.USER);
            System.out.print("user score: ");
            playground.showScore(Playground.USER);
            longLine();

            int userScore = playground.calculateScore(Playground.USER);
            int pcScore = playground.calculateScore(Playground.PC);

            if (userScore < 21 && !pcTurnEnd) {
                rules();
            } else if (userScore == 21 || (pcTurnEnd && (pcScore > 21 || userScore > pcScore))) {
                winsCountUser++;
                System.out.println("you win");
                scorGame(winsCountUser,winsCountPc);
                longLine();
                rules();
            } else if (pcTurnEnd && userScore == pcScore) {
                winsCountPc++;
                winsCountUser++;
                System.out.println("draw");
                scorGame(winsCountUser, winsCountPc);
                longLine();
                rules();
            } else {
                winsCountPc++;
                System.out.println("you Lose");
                scorGame(winsCountUser, winsCountPc);
                longLine();
                rules();
            }
            string = scanner.next();

            if (userScore < 21 && !pcTurnEnd) {
                if ("2".equals(string)) {
                    playground.showNextCard(Playground.USER);
                } else if ("3".equals(string)) {
                    while (playground.calculateScore(Playground.PC) < playground.calculateScore(Playground.USER)) {
                        playground.showNextCard(Playground.PC);
                        if (playground.calculateScore(Playground.PC) > 19 && playground.calculateScore(Playground.PC) > playground.calculateScore(Playground.USER)) {
                            break;
                        }
                    }
                    cardShowCount = playground.getCountCardOnPlayground(Playground.PC);
                    pcTurnEnd = true;
                }
            }

            if ("1".equals(string)) {
                playground.newGame();
                playground.showNextCard(Playground.USER);
                cardShowCount = 1;
                pcTurnEnd = false;
            }

            if ("0".equals(string)) {
                System.out.print("save rezult? (+ || -): ");
                String rez = scanner.next();
                if ("+".equals(rez)) {
                    FileWriter fileWriter = new FileWriter(file);
                    String scores = "PC=" + winsCountPc + "\n" + "USER=" + winsCountUser;
                    fileWriter.write(scores);
                    fileWriter.close();
                    System.out.println("game over");
                    playground.exit();
                } else {
                    System.out.println("game over");
                    playground.exit();
                }
                scanner.close();
            }

        }

    }

    public static void longLine() {
        System.out.println("----------------------------------------------");
    }

    public static void rules() {
        System.out.print("enter: (1=new game, 2=more cards, 3=pc turn, 0=exit): ");
    }

    public static void scorGame(int winsCountUser, int winsCountPc){
        System.out.println("Scor " + winsCountUser + ":" + winsCountPc + " (USER:PC)");
    }
}
