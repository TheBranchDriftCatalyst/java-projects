import alu.*;
import logicGates.*;

public class ALUTest {
        //test//
        public static void main(String[] args){

                ALU main = new ALU(8);

                System.out.println("Should get 00000000: " + main.evaluateAND("10101010", "01010101"));
                System.out.println("Should get 10101010: " + main.evaluateAND("10101010", "10101010"));

                System.out.println("Should get 11111111: " + main.evaluateOR("11110000", "00001111"));
                System.out.println("Should get 10101010: " + main.evaluateOR("10101010", "10101010"));

                SignalGenerator sigA = new SignalGenerator(false);
                SignalGenerator sigB = new SignalGenerator(true);
                CECircuit testCE = new CECircuit(sigA, sigB);

                System.out.println();
                System.out.println("Should get false: " + testCE.evaluate());

                sigA.setSignal(false);
                sigB.setSignal(false);
                System.out.println("Should get true: " + testCE.evaluate());

                sigA.setSignal(true);
                sigB.setSignal(true);
                System.out.println("Should get true: " + testCE.evaluate());


                System.out.println();
                System.out.println("Should get 00000000: " + main.evaluateCE("11110000", "00001111"));
                System.out.println("Should get 11111111: " + main.evaluateCE("10101010", "10101010"));


                SignalGenerator sigC = new SignalGenerator(true);
                sigA.setSignal(true);
                sigB.setSignal(true);
                FullAddCircuit testAddBit = new FullAddCircuit(sigA, sigB, sigC);
                System.out.println();
                System.out.println("Should be true false: " +  testAddBit.evaluateCary() + testAddBit.evaluate());

                sigA.setSignal(false);
                sigB.setSignal(true);
                sigC.setSignal(false);

                System.out.println("Should be false true: " +  testAddBit.evaluateCary() + testAddBit.evaluate());



                System.out.println();
                System.out.println("Should get 11111111:  " + main.evaluateADD("11110000", "00001111"));
                System.out.println("Should get 101010100: " + main.evaluateADD("10101010", "10101010"));
                System.out.println("Should get 11111110:  " + main.evaluateADD("01111111", "01111111"));
        }
}
