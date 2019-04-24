package project5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LightsOut extends JFrame {

        private static final long serialVersionUID = 1L;
        private static final int defaultDims = 5;
        private int dims;
        private JTextField clickCount = new JTextField("000");
        private JButton resetButton = new JButton("Reset Game");
        protected LightButton[][] lightArray;
        private int clickCnt = 0;
        private JButton changeColors = new JButton("Change Theme");

        public LightsOut(){
                super("Lights Out!");
                setSize(700, 700);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                try {
                        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
                } catch (Exception e) {
                        e.printStackTrace();
                }

                try {
                        String dimSt = JOptionPane.showInputDialog(null, "Enter Dimensions (X*X): ");
                        this.dims = Integer.parseInt(dimSt);
                        this.lightArray = new LightButton[this.dims][this.dims];
                } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "You failed to enter an integer! Using Default Value");
                        this.dims = defaultDims;
                        this.lightArray = new LightButton[this.dims][this.dims];
                }

                Container content = getContentPane();
                content.setLayout(new BorderLayout());

                JPanel panelTop = new JPanel();
                panelTop.setLayout(new GridLayout(this.dims, this.dims));
                panelTop.setBackground(Color.BLACK);
                content.add(panelTop);


                JPanel bottomPanel = new JPanel();
                bottomPanel.setLayout(new BoxLayout(bottomPanel, BoxLayout.X_AXIS));

                bottomPanel.add(resetButton);
                resetButton.addActionListener( new ActionListener(){
                        @Override
                        public void actionPerformed(ActionEvent event){
                                resetPressed();
                        }
                });

                clickCount.setEditable(false);
                clickCount.setColumns(4);
                bottomPanel.add(clickCount);

                bottomPanel.add(changeColors);

                for (int i = 0; i < this.lightArray.length; i++) {
                        for (int j = 0; j < this.lightArray.length; j++) {
                                this.lightArray[i][j] = new LightButton(i, j);
                                panelTop.add(this.lightArray[i][j]);
                        }
                }
                content.add(bottomPanel, BorderLayout.SOUTH);
        }



        protected void resetPressed() {
                setAllTo(Color.GREEN);
                clickCnt = 000;
                clickCount.setText(Integer.toString(clickCnt));
        }

        private void ButtonPressed(String name){
                String[] coordinates = name.split(", ");
                int x = Integer.parseInt(coordinates[0]);
                int y = Integer.parseInt(coordinates[1]);
                System.out.println(Integer.toString(x) + ", " + Integer.toString(y));

                toggleLights(x - 1, y);
                toggleLights(x, y - 1);
                toggleLights(x, y);
                toggleLights(x, y + 1);
                toggleLights(x + 1, y);
                clickCount.setText(Integer.toString(clickCnt++));

                if (gameWon()) {
                        setAllTo(Color.RED);
                        JOptionPane.showMessageDialog(null, "You Won the Game");
                }
        }

        private void toggleLights(int x, int y){
                try{
                        if (this.lightArray[x][y].getBackground() == Color.GREEN)
                                this.lightArray[x][y].setBackground(Color.BLACK);
                        else
                                this.lightArray[x][y].setBackground(Color.GREEN);
                }catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException) {
                        //no error print
                }
        }

        public boolean gameWon(){
                for (int i = 0; i < this.lightArray.length; i++) {
                        for (int j = 0; j < this.lightArray.length; j++) {
                                if (this.lightArray[i][j].getBackground() == Color.GREEN) {
                                        return false;
                                }
                        }
                }
                return true;
        }

        public void setAllTo(Color col){
                for (int i = 0; i < this.lightArray.length; i++)
                        for (int j = 0; j < this.lightArray.length; j++)
                                this.lightArray[i][j].setBackground(col);
        }

        private class LightButton extends JButton {

                private static final long serialVersionUID = 1L;

                public LightButton(int i, int j){
                        setName(Integer.toString(i) + ", " + Integer.toString(j));
                        setBackground(Color.GREEN);
                        addActionListener(new LightsOut.LightButtonListener(this));
                }
        }

        public class LightButtonListener implements ActionListener {
                private LightsOut.LightButton button;

                public LightButtonListener(LightsOut.LightButton lightButton) {
                        this.button = lightButton;
                }
                @Override
                public void actionPerformed(ActionEvent e) {
                        LightsOut.this.ButtonPressed(this.button.getName());
                }
        }

}
