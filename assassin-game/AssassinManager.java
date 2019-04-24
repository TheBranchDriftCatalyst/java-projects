package project4;

import java.io.PrintStream;

public class AssassinManager
{
        private AssassinNode headKillRing;
        private AssassinNode headGraveyard;

        public AssassinManager(String[] names)
        throws IllegalArgumentException
        {
                if (names.length <= 0) {
                        throw new IllegalArgumentException("Error :: List File Invalid or Had no Names");
                }
                for (int i = 0; i < names.length; i++)
                {
                        appendToKillRing(names[i]);
                }
        }

        private void appendToKillRing(String n)
        {
                AssassinNode node = new AssassinNode(n);
                if (this.headKillRing == null)
                {
                        this.headKillRing = node;
                }
                else {
                        AssassinNode current = this.headKillRing;
                        while (current.next != null) {
                                current = current.next;
                        }
                        current.next = node;
                }
        }

        void printKillRing()
        {
                String result = "";
                AssassinNode current = this.headKillRing;
                AssassinNode curNext = this.headKillRing.next;
                int i = 1;

                while (curNext != null) {
                        result = result + "\t" + i + " :: " + current.name + " is stalking " + curNext.name + "\n";
                        current = current.next;
                        curNext = curNext.next;
                        i++;
                }

                if (this.headKillRing.name.equalsIgnoreCase(current.name))
                        result = result + "\t" + i + " :: " + current.name + " is stalking themselves \n";
                else {
                        result = result + "\t" + i + " :: " + current.name + " is stalking " + this.headKillRing.name + "\n";
                }
                System.out.println(result);
        }

        void printGraveyard()
        {
                String result = "";

                if (this.headGraveyard == null) {
                        System.out.println("\t Graveyard is Empty!");
                }

                AssassinNode curNext = this.headGraveyard;
                int i = 1;
                while (curNext != null) {
                        result = "\t" + i + " :: " + curNext.name + " was killed by " + curNext.killer + "\n" + result;
                        curNext = curNext.next;
                        i++;
                }
                System.out.println(result);
        }

        public void kill(String name)
        throws IllegalStateException, IllegalArgumentException
        {
                if (gameOver())
                        throw new IllegalStateException("Game is Over! There is no one to Kill!");
                if (!killRingContains(name)) {
                        throw new IllegalArgumentException("Name is not in the kill ring!");
                }

                AssassinNode targetNode = this.headKillRing;
                AssassinNode killerNode = this.headKillRing;
                int i = -1;

                if (this.headKillRing.name.equalsIgnoreCase(name)) {
                        while (killerNode.next != null) {
                                killerNode = killerNode.next;
                        }

                        targetNode.killer = killerNode.name;
                        this.headKillRing = targetNode.next;
                        AssassinNode temp = targetNode;
                        appendToGraveyard(temp);
                }
                else
                {
                        do {
                                if (i >= 0) {
                                        killerNode = killerNode.next;
                                }
                                i++;
                                targetNode = targetNode.next;
                        }
                        while (!targetNode.name.equalsIgnoreCase(name));

                        targetNode.killer = killerNode.name;
                        killerNode.next = targetNode.next;
                        AssassinNode temp = targetNode;
                        appendToGraveyard(temp);
                }

                System.out.println(targetNode.killer + " Killed " + targetNode.name);
        }

        private void appendToGraveyard(AssassinNode node)
        {
                node.next = null;

                if (this.headGraveyard == null)
                {
                        this.headGraveyard = node;
                }
                else {
                        AssassinNode current = this.headGraveyard;
                        while (current.next != null) {
                                current = current.next;
                        }
                        current.next = node;
                }
        }

        public boolean killRingContains(String name)
        {
                AssassinNode current = this.headKillRing;
                while (current != null) {
                        if (current.name.equalsIgnoreCase(name)) {
                                return true;
                        }
                        current = current.next;
                }

                return false;
        }

        public boolean graveyardContains(String name)
        {
                AssassinNode current = this.headGraveyard;
                while (current != null) {
                        if (current.name.equalsIgnoreCase(name)) {
                                return true;
                        }
                        current = current.next;
                }

                return false;
        }

        public boolean gameOver()
        {
                return this.headKillRing.next == null;
        }

        public String winner()
        {
                if (gameOver()) {
                        return this.headKillRing.name;
                }
                return null;
        }

        public String toString()
        {
                return "Manager toString does not exist! Use printGraveyard of printKillRing";
        }
}
