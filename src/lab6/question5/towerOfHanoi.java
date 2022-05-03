package lab6.question5;
import java.util.HashMap;
import java.util.Map;

import lab6.question1.MyStack;

// taken from: https://www.youtube.com/watch?v=up9ac6zP5Yk

public class towerOfHanoi {
    private int totalDisks;
    private Map<Character, MyStack<Integer>> pegs;

    public towerOfHanoi(int disks){
        totalDisks = disks;
        pegs = new HashMap<Character, MyStack<Integer>>();
        pegs.put('A', new MyStack<Integer>());
        pegs.put('B', new MyStack<Integer>());
        pegs.put('C', new MyStack<Integer>());
        for (int i = disks; i > 0 ; i--) {
            pegs.get('A').push(i);
        }
    }

    /**
     * Calls moveTower to solve the puzzle.
     * Moves disk from tower 1 to tower 3 using tower 2 as a temporary place to put the disks.
     */
    public void solve(){
        printTowers();
        moveTower(totalDisks, 'A', 'C', 'B');
    }

    /**
     *
     * @param numDisks the number of disks to move
     * @param start    The starting peg
     * @param end      The ending peg
     * @param temp     The temporary peg, for moving from starting to ending peg
     */
    private void moveTower(int numDisks, Character start, Character end, Character temp){
        MyStack<Integer> startPeg = pegs.get(start);
        MyStack<Integer> endPeg = pegs.get(end);

        if(numDisks == 1){
            endPeg.push(startPeg.pop());
            printTowers();
        }else {
            moveTower(numDisks-1, start, temp, end);
            endPeg.push(startPeg.pop());
            printTowers();
            moveTower(numDisks-1, temp, end, start);
        }
    }

    public void printTowers(){
        System.out.println();
        for (Character c : pegs.keySet()) {
            System.out.println("Peg " + c + ": " + pegs.get(c));
        }
    }
}
