package com.stu.com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Calculator extends JFrame implements ActionListener {
    //这里我把JFrame写成Frame，这个错误找了好久

    JFrame frame;
    JMenuItem copy, paste, s, t, help, about, me;
    JRadioButton sixteen, ten, eight, two;
    JButton backspace, ce, c, num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
    Container cp;
    JTextField text;
    String copycontent = "";
    boolean clickable = true, clear = true;
    int all = 0;
    double qian;
    String fuhao;
    int jin = 10, first = 1;
    private final JButton jia = new JButton("+");
    private final JButton jian = new JButton("-");
    private final JButton cheng = new JButton("*");
    private final JButton chu = new JButton("/");
    private final JButton qiuyi = new JButton("%");
    private final JButton deng = new JButton("=");
    private final JButton fu = new JButton("+/-");
    private final JButton dian = new JButton(".");
    private final JButton kai = new JButton("sqrt");
    private final JButton diao = new JButton("1/x");
    private final JButton aa = new JButton("A");
    private final JButton bb = new JButton("B");
    private final JButton cc = new JButton("C");
    private final JButton dd = new JButton("D");
    private final JButton ee = new JButton("E");
    private final JButton ff = new JButton("F");
    private final TextField k1 = new TextField();
    private final objConversion convert = new objConversion();

    public Calculator() {
        setTitle("计算器");

        setSize(400, 300);

        setLocation(250, 200);

        text = new JTextField(25);

// text.setEnabled(false);

        text.setText("0.");

        text.setHorizontalAlignment(JTextField.RIGHT);//从右到左

        JPanel cp1 = new JPanel();

        JPanel cp2 = new JPanel();

        JPanel cp3 = new JPanel();

        cp = getContentPane();

        cp.add(cp1, "North");

        cp.add(cp2, "Center");

        cp.add(cp3, "South");

        cp1.setLayout(new GridLayout(1, 6));

        cp2.setLayout(new GridLayout(2, 4));

        cp3.setLayout(new GridLayout(6, 6));

        sixteen = new JRadioButton("十六进制");

        sixteen.setVisible(false);

        ten = new JRadioButton("十进制", true);

        ten.setVisible(false);

        eight = new JRadioButton("八进制");

        eight.setVisible(false);

        two = new JRadioButton("二进制");

        two.setVisible(false);

        sixteen.addActionListener(this);

        ten.addActionListener(this);

        eight.addActionListener(this);

        two.addActionListener(this);

        ButtonGroup btg = new ButtonGroup();

        btg.add(sixteen);

        btg.add(ten);

        btg.add(eight);

        btg.add(two);

        JTextField t3 = new JTextField(25);

        cp1.add(text);

// text.setEnabled(false);

        text.setEditable(false);

        text.setBackground(new Color(255, 255, 255));

        cp2.add(sixteen);

        cp2.add(ten);

        cp2.add(eight);

        cp2.add(two);

        backspace = new JButton("Backspace");

        backspace.setForeground(new Color(255, 0, 0));

        backspace.addActionListener(this);

        ce = new JButton("CE");

        ce.setForeground(new Color(255, 0, 0));

        ce.addActionListener(this);

        c = new JButton("C");

        c.setForeground(new Color(255, 0, 0));

        c.addActionListener(this);

        k1.setVisible(false);

        cp2.add(k1);

        cp2.add(backspace);

        cp2.add(ce);

        cp2.add(c);

        num0 = new JButton("0");

        num1 = new JButton("1");

        num2 = new JButton("2");

        num3 = new JButton("3");

        num4 = new JButton("4");

        num5 = new JButton("5");

        num6 = new JButton("6");

        num7 = new JButton("7");

        num8 = new JButton("8");

        num9 = new JButton("9");

        cp3.add(num7);

        num7.addActionListener(this);

        cp3.add(num8);

        num8.addActionListener(this);

        cp3.add(num9);

        num9.addActionListener(this);

        cp3.add(chu);

        chu.setForeground(new Color(255, 0, 0));

        chu.addActionListener(this);

        cp3.add(kai);

        kai.addActionListener(this);

        cp3.add(num4);

        num4.addActionListener(this);

        cp3.add(num5);

        num5.addActionListener(this);

        cp3.add(num6);

        num6.addActionListener(this);

        cp3.add(cheng);

        cheng.setForeground(new Color(255, 0, 0));

        cheng.addActionListener(this);

        cp3.add(qiuyi);

        qiuyi.addActionListener(this);

        cp3.add(num1);

        num1.addActionListener(this);

        cp3.add(num2);

        num2.addActionListener(this);

        cp3.add(num3);

        num3.addActionListener(this);

        cp3.add(jian);

        jian.setForeground(new Color(255, 0, 0));

        jian.addActionListener(this);

        cp3.add(diao);

        diao.addActionListener(this);

        cp3.add(num0);

        num0.addActionListener(this);

        cp3.add(fu);

        fu.addActionListener(this);

        cp3.add(dian);

        dian.addActionListener(this);

        cp3.add(jia);

        jia.setForeground(new Color(255, 0, 0));

        jia.addActionListener(this);

        cp3.add(deng);

        deng.setForeground(new Color(255, 0, 0));

        deng.addActionListener(this);

        cp3.add(aa);

        aa.addActionListener(this);

        cp3.add(bb);

        bb.addActionListener(this);

        cp3.add(cc);

        cc.addActionListener(this);

        cp3.add(dd);

        dd.addActionListener(this);

        cp3.add(ee);

        ee.addActionListener(this);

        cp3.add(ff);

        ff.addActionListener(this);

        aa.setVisible(false);

        bb.setVisible(false);

        cc.setVisible(false);

        dd.setVisible(false);

        ee.setVisible(false);

        ff.setVisible(false);

        JMenuBar mainMenu = new JMenuBar();

        setJMenuBar(mainMenu);

        JMenu editMenu = new JMenu("编辑");

        JMenu viewMenu = new JMenu("查看");

        JMenu helpMenu = new JMenu("帮助");

        mainMenu.add(editMenu);

        mainMenu.add(viewMenu);

        mainMenu.add(helpMenu);

        copy = new JMenuItem(" 复制");

        paste = new JMenuItem(" 粘贴");

        KeyStroke copyks = KeyStroke.getKeyStroke(KeyEvent.VK_C, Event.CTRL_MASK);

        copy.setAccelerator(copyks);//设置退出菜单选项加上快捷键

        KeyStroke pasteks = KeyStroke.getKeyStroke(KeyEvent.VK_V, Event.CTRL_MASK);

        paste.setAccelerator(pasteks);//设置退出菜单选项加上快捷键

        editMenu.add(copy);

        editMenu.add(paste);

        copy.addActionListener(this);

        paste.addActionListener(this);

        t = new JMenuItem("●标准型");

        s = new JMenuItem("   科学型");

        viewMenu.add(t);

        viewMenu.add(s);

        t.addActionListener(this);

        s.addActionListener(this);

        help = new JMenuItem(" 帮助主题");

        about = new JMenuItem(" 关于计算器");

        me = new JMenuItem(" 作者主页");

        helpMenu.add(help);

        helpMenu.add(about);

        helpMenu.add(me);

        help.addActionListener(this);

        about.addActionListener(this);

        me.addActionListener(this);

        addWindowListener(new WindowDestroyer());//结束窗口

    }

    public static void main(String[] arg)//产生窗口

    {
        Calculator win = new Calculator();

        win.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {//响应动作代码

        if (first == 1)

            text.setText("");

        first = 0;//第一次把文本框0.清空

        Object temp = e.getSource();

        if (temp == copy) {
            copycontent = text.getText();

        }

        if (temp == paste) {
            text.setText(text.getText() + copycontent);

        }

        if (temp == t) {//标准

            sixteen.setVisible(false);

            ten.setVisible(false);

            eight.setVisible(false);

            two.setVisible(false);

            t.setText("●标准型");

            s.setText("    科学型");

            aa.setVisible(false);

            bb.setVisible(false);

            cc.setVisible(false);

            dd.setVisible(false);

            ee.setVisible(false);

            ff.setVisible(false);

        }

        if (temp == s) {//科学

            sixteen.setVisible(true);

            ten.setVisible(true);

            eight.setVisible(true);

            two.setVisible(true);

            t.setText("   标准型");

            s.setText("●科学型");

            aa.setVisible(true);

            bb.setVisible(true);

            cc.setVisible(true);

            dd.setVisible(true);

            ee.setVisible(true);

            ff.setVisible(true);

            aa.setEnabled(false);

            bb.setEnabled(false);

            cc.setEnabled(false);

            dd.setEnabled(false);

            ee.setEnabled(false);

            ff.setEnabled(false);

        }

        if (temp == help) { //打开系统帮助文件 要查资料

            try {
                String filePath = "C:/WINDOWS/Help/calc.chm";

                Runtime.getRuntime().exec("cmd.exe /c " + filePath);

            } catch (Exception eeee) {
                System.out.println("打开系统的计算器出错");

            }

        }

        if (temp == about) {
            JOptionPane.showMessageDialog(frame, "Java计算器", "关于计算器", JOptionPane.INFORMATION_MESSAGE);

        }

        if (temp == me) {
            try {
                Process p = Runtime.getRuntime().exec("explorer http://blog.sina.com.cn/m/yangcai");

            } catch (Exception eeee) {
                System.out.println("打开指定网页出错");

            }

        }

        try {
            if (temp == sixteen) {
                String hex = text.getText();

                int inthex = Integer.parseInt(hex, jin);//先把数变为10进制

                text.setText(convert.decHex(inthex));

                jin = 16;

                aa.setEnabled(true);

                bb.setEnabled(true);

                cc.setEnabled(true);

                dd.setEnabled(true);

                ee.setEnabled(true);

                ff.setEnabled(true);

                num2.setEnabled(true);

                num3.setEnabled(true);

                num4.setEnabled(true);

                num5.setEnabled(true);

                num6.setEnabled(true);

                num7.setEnabled(true);

                num8.setEnabled(true);

                num9.setEnabled(true);

            }

            if (temp == eight) {
                String oct = text.getText();

                int intoct = Integer.parseInt(oct, jin);

                text.setText(convert.decOct(intoct));

                jin = 8;

                aa.setEnabled(false);

                bb.setEnabled(false);

                cc.setEnabled(false);

                dd.setEnabled(false);

                ee.setEnabled(false);

                ff.setEnabled(false);

                num2.setEnabled(true);

                num3.setEnabled(true);

                num4.setEnabled(true);

                num5.setEnabled(true);

                num6.setEnabled(true);

                num7.setEnabled(true);

                num8.setEnabled(false);

                num9.setEnabled(false);

            }

            if (temp == two) {
                String bin = text.getText();

                int intbin = Integer.parseInt(bin, jin);

                text.setText(convert.decBin(intbin));

                jin = 2;

                aa.setEnabled(false);

                bb.setEnabled(false);

                cc.setEnabled(false);

                dd.setEnabled(false);

                ee.setEnabled(false);

                ff.setEnabled(false);

                num2.setEnabled(false);

                num3.setEnabled(false);

                num4.setEnabled(false);

                num5.setEnabled(false);

                num6.setEnabled(false);

                num7.setEnabled(false);

                num8.setEnabled(false);

                num9.setEnabled(false);

            }

            if (temp == ten) {
                String dec = text.getText();

                int intdec = Integer.parseInt(dec, jin);

// text.setText(convert.decDec(intdec));  //本句会把123变成321

                text.setText(intdec + "");

                jin = 10;

                aa.setEnabled(false);

                bb.setEnabled(false);

                cc.setEnabled(false);

                dd.setEnabled(false);

                ee.setEnabled(false);

                ff.setEnabled(false);

                num2.setEnabled(true);

                num3.setEnabled(true);

                num4.setEnabled(true);

                num5.setEnabled(true);

                num6.setEnabled(true);

                num7.setEnabled(true);

                num8.setEnabled(true);

                num9.setEnabled(true);

            }

        } catch (Exception ee) {
            System.out.println("转换出错,可能你没有输入任何字符");

            text.setText("转换出错");

            clear = false;

        }

        if (temp == backspace) {//退格

            String s = text.getText();

            text.setText("");

            for (int i = 0; i < s.length() - 1; i++) {
                char a = s.charAt(i);

                text.setText(text.getText() + a);

            }

        }

        if (temp == ce) {
            text.setText("0.");

            clear = true;

            first = 1;

        }

        if (temp == c) {
            text.setText("0.");

            clear = true;

            first = 1;

        }

        if (temp == num0) {
            if (clear == false)//判断是否点击了符号位

                text.setText("");

            text.setText(text.getText() + "0");

        }

        if (temp == num1) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "1");

            clear = true;//第二次不在清空(前二句)

        }

        if (temp == num2) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "2");

            clear = true;

        }

        if (temp == num3) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "3");

            clear = true;

        }

        if (temp == num4) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "4");

            clear = true;

        }

        if (temp == num5) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "5");

            clear = true;

        }

        if (temp == num6) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "6");

            clear = true;

        }

        if (temp == num7) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "7");

            clear = true;

        }

        if (temp == num8) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "8");

            clear = true;

        }

        if (temp == num9) {
            if (clear == false)

                text.setText("");

            text.setText(text.getText() + "9");

            clear = true;

        }

        if (temp == aa) {
            text.setText(text.getText() + "A");

        }

        if (temp == bb) {
            text.setText(text.getText() + "B");

        }

        if (temp == cc) {
            text.setText(text.getText() + "C");

        }

        if (temp == dd) {
            text.setText(text.getText() + "D");

        }

        if (temp == ee) {
            text.setText(text.getText() + "E");

        }

        if (temp == ff) {
            text.setText(text.getText() + "F");

        }

        if (temp == dian) {
            clickable = true;

            for (int i = 0; i < text.getText().length(); i++)

                if ('.' == text.getText().charAt(i)) {
                    clickable = false;

                    break;

                } //第一层判断是否里面含有小数点;

            if (clickable == true)//第二坛判断

                text.setText(text.getText() + ".");

        }

        try {
            if (temp == jia) {//加法

                qian = Double.parseDouble(text.getText());

                fuhao = "+";

                clear = false;

            }

            if (temp == jian) {
                qian = Double.parseDouble(text.getText());

                fuhao = "-";

                clear = false;

            }

            if (temp == cheng) {
                qian = Double.parseDouble(text.getText());

                fuhao = "*";

                clear = false;

            }

            if (temp == chu) {
                qian = Double.parseDouble(text.getText());

                fuhao = "/";

                clear = false;

            }

            if (temp == deng) {
                double ss = Double.parseDouble(text.getText());

                text.setText("");

                if (fuhao == "+")

                    text.setText(qian + ss + "");

                if (fuhao == "-")

                    text.setText(qian - ss + "");

                if (fuhao == "*")

                    text.setText(qian * ss + "");

                if (fuhao == "/")

                    text.setText(qian / ss + "");

                clear = false;//要清空前一次的数据

            }

            if (temp == kai) {
                String s = text.getText();

                if (s.charAt(0) == '-') {
                    text.setText("负数不能开根号");

                } else

                    text.setText(Double.toString(java.lang.Math.sqrt(Double.parseDouble(text.getText()))));

                clear = false;

            }

            if (temp == diao) {
                if (text.getText().charAt(0) == '0' && text.getText().length() == 1) {
                    text.setText("除数不能为零");

                } else {
                    boolean isDec = true;

                    int i, j, k;

                    String s = Double.toString(1 / Double.parseDouble(text.getText()));

                    for (i = 0; i < s.length(); i++)

                        if (s.charAt(i) == '.')

                            break;

                    for (j = i + 1; j < s.length(); j++)

                        if (s.charAt(j) != '0') {
                            isDec = false;

                            break;

                        }

                    if (isDec == true) {
                        String stemp = "";

                        for (k = 0; k < i; k++)

                            stemp += s.charAt(k);

                        text.setText(stemp);

                    } else

                        text.setText(s);

                }

                clear = false;

            }

            if (temp == qiuyi) {
                text.setText("0");

                clear = false;

            }

            if (temp == fu) { //导师，此方法参考书中例子

                boolean isNumber = true;

                String s = text.getText();

                for (int i = 0; i < s.length(); i++)

                    if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9' || s.charAt(i) == '.' ||

                            s.charAt(i) == '-')) {
                        isNumber = false;

                        break;

                    }

                if (isNumber == true) {
//如果当前字符串首字母有'-'号,代表现在是个负数,再按下时,则将首符号去掉

                    if (s.charAt(0) == '-') {
                        text.setText("");

                        for (int i = 1; i < s.length(); i++) {
                            char a = s.charAt(i);

                            text.setText(text.getText() + a);

                        }

                    }

//如果当前字符串第一个字符不是符号，则添加一个符号在首字母处

                    else

                        text.setText('-' + s);

                }

            }

        } catch (Exception eee) {
            System.out.println("运算时,首先输入数字或字符");

            text.setText("运算出错");

            clear = false;

        }

    }

    class WindowDestroyer extends WindowAdapter {//退出窗口动作

        public void windowClosing(WindowEvent e) {
            System.exit(0);

        }

    }

    class objConversion {//导师,本进制类参考了CSMD类转换例子

        public void objConversion() {
        }

        public String decDec(int decNum) {//10

            String strDecNum = Integer.toString(decNum);

            for (int i = strDecNum.length(); i < 3; i++) {
                strDecNum = "0" + strDecNum;

            }

// return strDecNum;

            return invert(strDecNum, 5);

        }

        public String decHex(int decNum) {//10 to 16

            String strHexNum = "";

            int currentNum = 0;

            while (decNum != 0) {
                if (decNum > 15) {
                    currentNum = decNum % 16;

                    decNum /= 16;

                } else {
                    currentNum = decNum;

                    decNum = 0;

                }

                switch (currentNum) {
                    case 15:
                        strHexNum += "F";

                        break;

                    case 14:
                        strHexNum += "E";

                        break;

                    case 13:
                        strHexNum += "D";

                        break;

                    case 12:
                        strHexNum += "C";

                        break;

                    case 11:
                        strHexNum += "B";

                        break;

                    case 10:
                        strHexNum += "A";

                        break;

                    default:
                        strHexNum += Integer.toString(currentNum);

                        break;

                }

            }

            return invert(strHexNum, 2);

        }

        public String decOct(int decNum) {//10 to 8

            String strOctNum = "";

            while (decNum != 0) {
                if (decNum > 7) {
                    strOctNum += Integer.toString(decNum % 8);

                    decNum /= 8;

                } else {
                    strOctNum += Integer.toString(decNum);

                    decNum = 0;

                }

            }

            return invert(strOctNum, 3);

        }

        public String decBin(int decNum) {//10 to 2

            String strBinNum = "";

            while (decNum != 0) {
                if (decNum > 1) {
                    strBinNum += Integer.toString(decNum % 2);

                    decNum /= 2;

                } else {
                    strBinNum += Integer.toString(decNum);

                    decNum = 0;

                }

            }

            return invert(strBinNum, 8);

        }

        private String invert(String strNum, int minLength) //转换长度

        {
            String answer = "";

            int length = strNum.length();

            if (length < minLength) {
                for (int padding = (minLength - length); padding > 0; padding--) {
                    answer += "0";

                }

            }

            for (int i = length; i > 0; i--) {
                answer += strNum.charAt(i - 1);

            }

            return answer;

        }

    }

}