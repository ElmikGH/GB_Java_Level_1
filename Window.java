package IG_Homework_Lesson_7;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Window extends JFrame {
    private final int maxSize_x = 500;
    private final int maxSize_y = 500;
    private final Color background = new Color(200,200,200);
    private final Dimension screenCenter = Toolkit.getDefaultToolkit().getScreenSize();
    private JCheckBox userChoice;
    private JPanel formButtons;
    private JButton aceptDone;

    private void userAceptLicense () {
        formButtons.add(new JLabel("Read license and acept:"));
        userChoice = new JCheckBox("I agree");
        userChoice.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                aceptDone.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
            }
        });
        formButtons.add(userChoice);
    }
    private void initialization () {
        setSize(maxSize_y, maxSize_x);
        setLocation((screenCenter.width/2)-(maxSize_x/2), (screenCenter.height/2)-(maxSize_y/2));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("New license to accept.");
        setResizable(false);

    }

    private void licenseBody(){
        JTextArea text = new JTextArea(10,10);
        text.append("Это лицензия на использование софта\n и меня никто не читает, жми уже галку\n и иди своей дорогой.");
        JScrollPane textScroll = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(textScroll);
    }

    private void formManipulator (){
        formButtons = new JPanel(new GridLayout(6,1));
        formButtons.setBackground(background);
        userAceptLicense();
        doneButton();
        add(formButtons,BorderLayout.SOUTH);

    }
    private void doneButton (){
        aceptDone = new JButton("Done");
        formButtons.add(aceptDone);
    }

    Window () {
        initialization();
        licenseBody();
        formManipulator();
        setVisible(true);


    }

}
