import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CalFrame extends JFrame {
   
    private JButton buttonZero = new JButton("0");
    private JButton buttonOne = new JButton("1");
    private JButton buttonTwo = new JButton("2");
    private JButton buttonThree = new JButton("3");
    private JButton buttonFour = new JButton("4");
    private JButton buttonFive = new JButton("5");
    private JButton buttonSix = new JButton("6");
    private JButton buttonSeven = new JButton("7");
    private JButton buttonEight = new JButton("8");
    private JButton buttonNine = new JButton("9");
	

    private JButton buttonDecimal = new JButton(".");
    private JButton buttonPlus = new JButton("+");
    private JButton buttonReduce = new JButton("-");
    private JButton buttonRide = new JButton("*");
    private JButton buttonExcept = new JButton("/");
    private JButton buttonEqual = new JButton("=");

    private JButton buttonLeft = new JButton("(");
    private JButton buttonRight = new JButton(")");
    private JButton buttonClear = new JButton("C");
    private JButton buttonDelete = new JButton("R");
    
    private JLabel equationLabel = new JLabel("运算式:");
    private JLabel lable = new JLabel ("<html><br/><br/><br/><br/></html>");
    private JLabel resultLabel = new JLabel("运算结果:");
    private JTextArea equation = new JTextArea(2,30);
    private JTextArea result = new JTextArea(1,30);

    private JPanel jpanelOne = new JPanel();
    private JPanel jpanelTwo = new JPanel();

    public CalFrame () {

        equation.setEditable(false);
        result.setEditable(false);
        
        
        actionSettings();
        
        
        positionSettings();
        
        
        setLayout( new GridLayout(2,1));
        add(jpanelOne);
        add(jpanelTwo);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setTitle("计算器");
        setSize(400, 250);
        setLocation(200, 200);
        setVisible(true);
        
    }
    
    private void actionSettings () {
        
        buttonZero.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "0");
            }
        });
        buttonOne.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "1");
            }
        });
        buttonTwo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "2");
            }
        });
        buttonThree.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "3");
            }
        });
        buttonFour.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "4");
            }
        });
        buttonFive.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "5");
            }
        });
        buttonSix.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "6");
            }
        });
        buttonSeven.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "7");
            }
        });
        buttonEight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "8");
            }
        });
        buttonNine.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "9");
            }
        });
        buttonDecimal.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + ".");
            }
        });
        buttonPlus.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "+");
            }
        });
        buttonReduce.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "-");
            }
        });
        buttonRide.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "*");
            }
        });
        buttonExcept.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "/");
            }
        });
        buttonLeft.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + "(");
            }
        });
        buttonRight.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText(equation.getText() + ")");
            }
        });
        buttonEqual.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String cmd = equation.getText();
                Calculate cl = new Calculate();
                
                String resultMsg = cl.calResult(cmd);
                if ( resultMsg.equals("运算格式错误") || resultMsg.equals("错误,除数不能为0") ) {
                    //JOptionPane.showMessageDialog(null, resultMsg, "错误", JOptionPane.WARNING_MESSAGE);
				result.setText(resultMsg);
                }
                else {
                    result.setText(resultMsg);
                }

            }
        });
        buttonClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                equation.setText("");
                result.setText("");
            }
        });
	
        buttonDelete.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if( !( equation.getText().equals("")) ) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append(equation.getText());
                    stringBuffer.delete(stringBuffer.length()-1 , stringBuffer.length());
                    equation.setText(stringBuffer.toString());
                }
            }
        });
        
    }
    
    private void positionSettings () {
        
        jpanelOne.add(equationLabel);
        jpanelOne.add(lable);
        jpanelOne.add(equation);
        jpanelOne.add(resultLabel);
        jpanelOne.add(result);
        equationLabel.setBounds(0, 0, 50, 30);
        equationLabel.setLocation(0, 0);
        equation.setBounds(50, 0, 150, 30);
        equation.setLocation(50, 0);
        resultLabel.setBounds(0, 30, 50, 30);
        resultLabel.setLocation(0, 30);
        result.setBounds(50, 30, 150, 30);
        result.setLocation(50, 30);

        jpanelTwo.setLayout(new GridLayout(4, 5));
        
        jpanelTwo.add(buttonSeven);
        jpanelTwo.add(buttonEight);
        jpanelTwo.add(buttonNine);
        jpanelTwo.add(buttonPlus);
        jpanelTwo.add(buttonLeft);
        
        jpanelTwo.add(buttonFour);
        jpanelTwo.add(buttonFive);
        jpanelTwo.add(buttonSix);
        jpanelTwo.add(buttonReduce);
        jpanelTwo.add(buttonRight);
      
        jpanelTwo.add(buttonOne);
        jpanelTwo.add(buttonTwo);
        jpanelTwo.add(buttonThree);
        jpanelTwo.add(buttonRide);
        jpanelTwo.add(buttonClear);

        
        jpanelTwo.add(buttonZero);
        jpanelTwo.add(buttonDecimal);
        jpanelTwo.add(buttonEqual);
        jpanelTwo.add(buttonExcept);
        jpanelTwo.add(buttonDelete);
       
 
        jpanelOne.setLocation(0, 100);
        jpanelOne.setVisible(true);
        jpanelTwo.setLocation(0, 100);
        jpanelTwo.setVisible(true);
        
    }
    
}
