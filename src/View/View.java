package View;

import Controller.Message;
import Controller.UpdateMessage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.concurrent.BlockingQueue;

public class View extends JFrame {
    BlockingQueue<Message>  queue;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    JTextField redTextField;
    JTextField greenTextField;
    JTextField blueTextField;

    JButton updateButton;
    JButton resetButton;

    JPanel controlPanel = new JPanel();
    DrawGraph graphPanel = new DrawGraph();

    public View(BlockingQueue<Message> queue){
        this.queue = queue;
        String DEFAULT_VAL = "1";

        this.redLabel = new JLabel("Red");
        this.greenLabel = new JLabel("Green");
        this.blueLabel = new JLabel("Blue");

        this.redTextField = new JTextField(10);
        redTextField.setText(DEFAULT_VAL);
        this.blueTextField = new JTextField(10);
        blueTextField.setText(DEFAULT_VAL);
        this.greenTextField = new JTextField(10);
        greenTextField.setText(DEFAULT_VAL);

        controlPanel.add(redLabel);
        controlPanel.add(redTextField);
        controlPanel.add(greenLabel);
        controlPanel.add(greenTextField);
        controlPanel.add(blueLabel);
        controlPanel.add(blueTextField);

        this.updateButton = new JButton("Update");

        updateButton.addActionListener(e -> {
            String redVal = redTextField.getText();
            String greenVal = greenTextField.getText();
            String blueVal = blueTextField.getText();
            int[] values = new int[3];

            if(!redVal.equals("") && !greenVal.equals("") && !blueVal.equals(""))
            {
                values[0] = Integer.parseInt(redVal);
                values[1] = Integer.parseInt(greenVal);
                values[2] = Integer.parseInt(blueVal);
            }
            else{
                System.out.println("No values entered");
            }

            try {
                Message msg = new UpdateMessage(values);
                queue.put(msg);
            } catch (InterruptedException exception) {
                // do nothing
            }
        });
        controlPanel.add(updateButton);

        controlPanel.setLayout(new GridLayout(0,1, 0, 5));
        controlPanel.setBorder(new EmptyBorder(10, 25, 35, 25));

        this.add(controlPanel, BorderLayout.WEST);
        this.add(graphPanel, BorderLayout.CENTER);

        this.setSize(600, 500);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateHeightsInView(int[] heights){
        graphPanel.setHeights(heights);
    }
}