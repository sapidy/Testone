
package com.stu.com;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator3{
    //初始化
    static JFrame jf = new JFrame("计算器");
    static JPanel jpTotal = new JPanel();	//存在总面板
    static JPanel jpText = new JPanel();	//存储文本框
    static JPanel jpButton = new JPanel();	//存储按钮
    static JTextField jt = new JTextField();
    static final String[] jbFunction = {"7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "×²", "0", ".", "+", "☕", "CE", "C", "="};
    static JButton[] jb = new JButton[jbFunction.length];
    static double numberOne;
    static double numberTwo;
    static int count;

    //菜单栏
    static JMenuBar bar = new JMenuBar();
    static JMenu[] menus = {new JMenu("≡"), new JMenu("设置")};

    //子菜单
    static String[] wordColors = {"红色","黄色","蓝色","绿色","青色","紫色","黑色","白色","灰色"};
    static String[] colors = {"红色","黄色","蓝色","绿色","青色","紫色","黑色","白色","灰色"};
    static JRadioButtonMenuItem[] colorItems, panelColorItems;		//单选项菜单类
    static ButtonGroup group = new ButtonGroup();

    //用于删除字符串，存储新的字符串
    static String str = "";
    static String s = "";
    static String st;
    static int result;
    //整个面板
    public static void demo() {

        //设置窗体logo
        Toolkit tk = Toolkit.getDefaultToolkit();
//        Image im = tk.getImage(jf.getClass().getResource("logo.png"));
//        jf.setIconImage(im);

        //窗体不能拖动大小
        jf.setResizable(false);

        //设置窗体大小位置
        jf.setBounds(500, 200, 400, 400);

        //面板设置
        jpTotal.setBorder(new EmptyBorder(5,5,4,4));	//设置总面板边框
        jpTotal.setLayout(new BorderLayout(0,0));
        jpTotal.add(jpText, BorderLayout.NORTH); //将面板放置在边界布局的北部
        jf.add(jpTotal);

        //添加文本框
        jt.setHorizontalAlignment(SwingConstants.RIGHT);
        jt.setFont(new Font("楷体", Font.BOLD, 25));
        jt.setColumns(27);
        jpText.add(jt);

        //添加按钮
        jpButton.setLayout(new GridLayout(5,5,4,4));
        for(int i = 0; i < jb.length; i++) {
            jb[i] = new JButton(jbFunction[i]);
            jpButton.add(jb[i]);
            jb[i].addActionListener(new MyAction());
            jb[i].setBackground(Color.lightGray);
            jb[i].setContentAreaFilled(true);
            jb[i].setToolTipText("I'm " + jb[i].getText());
            jb[i].setFont(new Font(null, Font.BOLD,18));
        }
        jpTotal.add(jpButton, BorderLayout.CENTER);

        //添加菜单栏一级和二级菜单
        for(int i = 0; i < menus.length; i++) {
            bar.add(menus[i]);
        }
        JMenuItem item1 = new JMenuItem("关于");
        item1.addActionListener(new MyColors());
        menus[0].add(item1);

        JMenu item2 = new JMenu("字体颜色");
        menus[1].add(item2);

        JMenu item3 = new JMenu("按钮边框颜色");
        menus[1].add(item3);

        //添加三级菜单
        //字体颜色菜单
        colorItems = new JRadioButtonMenuItem[wordColors.length];
        for(int i = 0; i < wordColors.length; i++) {
            colorItems[i] = new JRadioButtonMenuItem(wordColors[i]);
            group.add(colorItems[i]);
            item2.add(colorItems[i]);
            colorItems[i].addActionListener(new MyColors());
        }
        //colorItems[8].setSelected(true);  //初始化默认值

        //面板颜色菜单
        panelColorItems = new JRadioButtonMenuItem[colors.length];
        for(int i = 0; i < colors.length; i++) {
            panelColorItems[i] = new JRadioButtonMenuItem(colors[i]);
            group.add(panelColorItems[i]);
            item3.add(panelColorItems[i]);
            panelColorItems[i].addActionListener(new MyPanelColors());
        }
        //panelColorItems[8].setSelected(true);

        jf.setJMenuBar(bar);

        //窗体显示和关闭
        jf.setVisible(true);
        jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
    }

    //字体颜色
    static class MyColors implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < jb.length; i++) {
                if("红色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.red);
                    jt.setForeground(Color.red);
                }else if("黄色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.yellow);
                    jt.setForeground(Color.yellow);
                }else if("蓝色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.blue);
                    jt.setForeground(Color.blue);
                }else if("绿色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.green);
                    jt.setForeground(Color.green);
                }else if("青色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.cyan);
                    jt.setForeground(Color.cyan);
                }else if("紫色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.MAGENTA);
                    jt.setForeground(Color.MAGENTA);
                }else if("黑色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.black);
                    jt.setForeground(Color.black);
                }else if("白色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.white);
                    jt.setForeground(Color.white);
                }else if("灰色".equals(e.getActionCommand())) {
                    jb[i].setForeground(Color.gray);
                    jt.setForeground(Color.gray);
                }else if("关于".equals(e.getActionCommand())) {
                    JOptionPane.showMessageDialog(null, "仅供学习使用!", "天道酬勤",JOptionPane.DEFAULT_OPTION);
                    break;		//跳出循环，实现跳出弹框关闭效果
                }
            }
        }
    }

    //面板颜色
    static class MyPanelColors implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < jb.length; i++) {
                if("红色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.red);
                }else if("黄色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.yellow);
                }else if("蓝色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.blue);
                }else if("绿色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.green);
                }else if("青色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.cyan);
                }else if("紫色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.MAGENTA);
                }else if("黑色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.black);
                }else if("白色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.white);
                }else if("灰色".equals(e.getActionCommand())) {
                    jb[i].setBackground(Color.gray);
                }
            }
        }
    }

    //运算类
    static class MyAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String str;
            try {
                if("C".equals(e.getActionCommand())) {
                    jt.setText("");
                    jt.setBackground(null);
                }else if("CE".equals(e.getActionCommand())) {
                    if(jt.getText().length() >= 0) {
                        str = jt.getText();
                        str = str.substring(0,str.length()-1);
                        jt.setText(str);
                    }
                }else if("+".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberOne = Double.parseDouble(str);
                    jt.setText("");
                    count = 0;
                }else if("-".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberOne = Double.parseDouble(str);
                    jt.setText("");
                    count = 1;
                }else if("×".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberOne = Double.parseDouble(str);
                    jt.setText("");
                    count = 2;
                }else if("÷".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberOne = Double.parseDouble(str);
                    jt.setText("");
                    count = 3;
                }else if("×²".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberOne = Double.parseDouble(str);
                    jt.setText("" + (numberOne * numberOne));
                    result = 1;
                }else if("☕".equals(e.getActionCommand())) {
                    st = JOptionPane.showInputDialog(null,"输入想说的话：\n",e.getActionCommand(),JOptionPane.PLAIN_MESSAGE);
                    jt.setText(st);
                }else if(".".equals(e.getActionCommand())){
                    if(jt.getText().trim().indexOf('.')!=-1){

                    }else{
                        s = jt.getText();
                        s = s + e.getActionCommand();
                        jt.setText(s);
                    }
                }else if("=".equals(e.getActionCommand())) {
                    str = jt.getText();
                    numberTwo = Double.parseDouble(str);
                    jt.setText("");
                    switch(count) {
                        case 0 : jt.setText("" + (numberOne + numberTwo));result = 1;break;
                        case 1 : jt.setText("" + (numberOne - numberTwo));result = 1;break;
                        case 2 : jt.setText("" + (numberOne * numberTwo));result = 1;break;
                        case 3 : if(numberOne == 0 && numberTwo == 0) {
                            jt.setText("零不能相除!");
                            break;
                        }else{
                            jt.setText("" + (numberOne / numberTwo));
                            result = 1;
                            break;
                        }
                    }

                }else {
                    if("输入有误!按C键重新输入".equals(jt.getText()) || jt.getText().equals(st)) {
                        jt.setText("");
                    }else if(result ==  1) {		//实现得到结果后在点击，结果清空，有结果为1没结果为0
                        jt.setText("");
                        result = 0;
                    }else if(result == 0) {
                        String s = jt.getText();
                        s = s + e.getActionCommand();
                        jt.setText(s);
                    }
                }
            }catch(Exception e1) {
                jt.setText("输入有误!按C键重新输入");
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
        String lookAndFeel = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";		//更换主题
        UIManager.setLookAndFeel(lookAndFeel);
        demo();
    }
}
