import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleGui extends JFrame {
    // создаем необходимые поля
    private JButton button1=new JButton("Start");
    private JButton button2=new JButton("Close");
    private JButton button3=new JButton("Next choice");
    private JTextField input=new JTextField("", 50);
    private JLabel label1=new JLabel("Input your choice");
    private JTextField output=new JTextField("",50);
    private JLabel label2=new JLabel("Result");

    public SimpleGui(){ //конструктор
        super ("Sea Battle");  //название
        this.setBounds(100, 100, 400, 200); // размер поля
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // окончание работы по закрытии формы
        Container container1=this.getContentPane(); //создаем контейнер и помещаем в него элементы
        container1.setLayout(new GridLayout(3, 2, 3, 2));
        // добавляем в контейнер элементы
        container1.add(input);
        container1.add(label1);
        container1.add(output);
        container1.add(label2);
        container1.add(button1);
        container1.add(button2);
        container1.add(button3);
        input.addActionListener(new TextEventListener1());
        button1.addActionListener(new ButtonEventListener1());
        button2.addActionListener(new ButtonEventListener2());
    //    button3.addActionListener(new ButtonEventListener3());

    }
    class TextEventListener1 implements ActionListener {
        public void actionPerformed (ActionEvent e){
        //    String text = input.getText();
        //    text.append(text + newline);
        //    input.selectAll();

        }
    }

    class ButtonEventListener1 implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            DotComBust game = new DotComBust();
            game.startPlaying();
            String message1 = "";
            message1 += "Игра морской бой стартовала\n";
            message1 += "Сделайте ход\n";
            JOptionPane.showMessageDialog(null, message1, "Output", JOptionPane.PLAIN_MESSAGE);
        }

    }

    class ButtonEventListener2 implements ActionListener {
        public void actionPerformed (ActionEvent e){
            String message1="";
            message1+="Игра морской бой окончена\n";
            message1+="До новых встреч\n";
            JOptionPane.showMessageDialog(null, message1, "ИГРА ОКОНЧЕНА", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }
    }


}
