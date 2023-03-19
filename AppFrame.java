package GUI;

import compressor_decompressor.compressor;
import compressor_decompressor.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class AppFrame extends JFrame implements ActionListener {


    JLabel label;

    JButton compressButton;
    JButton decompressButton;

    AppFrame() {




        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        label=new JLabel();
        label.setText("Compressor and Decompressor");

        JPanel panel = new JPanel();
        panel.add(label);
        panel.setBackground(Color.green);
        panel.setBounds(20, 20, 460, 20); // set the position and size of the panel
        this.add(panel);





        compressButton = new JButton("Select file to Compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20, 120, 200, 30);


        decompressButton = new JButton("Select file to Decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(260, 120, 200, 30);

        this.add(compressButton);
        this.add(decompressButton);



        this.setSize(500, 250);
        this.getContentPane().setBackground(Color.blue);


        this.setVisible(true);

    }

    @Override

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == compressButton) {

            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.println(file);
                try {
                    compressor.method(file);

                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }

        if (e.getSource() == decompressButton) {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if (response == JFileChooser.APPROVE_OPTION) {

                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try {
                    decompressor.method(file);
                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null, excp.toString());
                }
            }
        }
    }
}
