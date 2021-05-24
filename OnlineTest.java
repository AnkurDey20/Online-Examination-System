import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
    JLabel l;
    JRadioButton[] jb = new JRadioButton[5];
    JButton b1, b2;
    ButtonGroup bg;
    int count=0, current=0, x=1, now=0;
    int[] m = new int[10];

    OnlineTest(String s)
    {
        super(s);
        l = new JLabel();
        add(l);
        bg = new ButtonGroup();

        for(int i=0; i<5; i++)
        {
            jb[i] = new JRadioButton();
            add(jb[i]);
            bg.add(jb[i]);
        }

        b1 = new JButton("Next");
        b2 = new JButton("Mark For Review");
        b1.addActionListener(this);
        b2.addActionListener(this);


        add(b1);
        add(b2);

        setQuestions();

        l.setBounds(30,40,450,20);
        jb[0].setBounds(50,80,100,20);
        jb[1].setBounds(50,110,100,20);
        jb[2].setBounds(50,140,100,20);
        jb[3].setBounds(50,170,100,20);
        b1.setBounds(100,240,100,30);
        b2.setBounds(270,240,130,30);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(750, 350);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == b1)
        {
            if(checkForAns())
                count += 1;

            current++;
            setQuestions();

            if(current == 9)
            {
                b1.setEnabled(false);
                b2.setText("Show Result");
            }
        }

        if(e.getActionCommand().equals("Mark For Review"))
        {
            JButton bk = new JButton("Mark For Review " + x);
            bk.setBackground(Color.lightGray);
            bk.setBounds(480,20+30*x,200,30);
            add(bk);
            bk.addActionListener(this);
            m[x] = current;
            x++;
            current++;
            setQuestions();

            if(current==9)
                b2.setText("Show Result");

            setVisible(false);
            setVisible(true);
        }

        for(int i=0, y=1; i<x; i++, y++)
        {
            if(e.getActionCommand().equals("Mark For Review " + y))
            {
                if(checkForAns())
                    count += 1;

                now = current;
                current = m[y];
                setQuestions();
                ((JButton)e.getSource()).setEnabled(false);
                current = now;
            }
        }

        if(e.getActionCommand().equals("Show Result"))
        {
            if(checkForAns())
                count += 1;

            current++;
            JOptionPane.showMessageDialog(this,"Correct Answers = " + count);
            System.exit(0);
        }
    }

    void setQuestions()
    {
        jb[4].setSelected(true);
        if(current == 0)
        {
            l.setText("Q 1 - The world famous monument ‘Pyramid’ is located in ________ .");
            jb[0].setText("Russia");
            jb[1].setText("Iraq");
            jb[2].setText("Egypt");
            jb[3].setText("Greece");
        }
        if(current == 1)
        {
            l.setText("Q 2 - Which among the following planets has rings?");
            jb[0].setText("Saturn");
            jb[1].setText("Venus");
            jb[2].setText("Jupiter");
            jb[3].setText("Earth");
        }
        if(current == 2)
        {
            l.setText("Q 3 - Indian tribe is a tribe of _________ .");
            jb[0].setText("Congo Basin");
            jb[1].setText("Amazon Basin");
            jb[2].setText("Nile Basin");
            jb[3].setText("Godavari River Basin");
        }
        if(current == 3)
        {
            l.setText("Q 4 - September 16 is celebrated as __________ .");
            jb[0].setText("World Environment Day");
            jb[1].setText("World Ocean Day");
            jb[2].setText("World Ozone Day");
            jb[3].setText("World Red Cross Day");
        }
        if(current == 4)
        {
            l.setText("Q 5 - National Emblem of Australia is __________ .");
            jb[0].setText("Kangaroo");
            jb[1].setText("White Lily");
            jb[2].setText("Rose");
            jb[3].setText("Lily");
        }
        if(current == 5)
        {
            l.setText("Q 6 - The Intelligence Department belongs to __________ .");
            jb[0].setText("Korea");
            jb[1].setText("Pakistan");
            jb[2].setText("Spain");
            jb[3].setText("Bangladesh");
        }
        if(current == 6)
        {
            l.setText("Q 7 - Which among the following stadiums is known for Cricket?");
            jb[0].setText("Jawaharlal Nehru Stadium");
            jb[1].setText("Arun Jaitley Stadium");
            jb[2].setText("Shivaji Stadium");
            jb[3].setText("Ambedkar Stadium");
        }
        if(current == 7)
        {
            l.setText("Q 8 - The great Mauryan Empire Bindusara was the son of __________ .");
            jb[0].setText("Chandragupta");
            jb[1].setText("Ashoka");
            jb[2].setText("Bimbisara");
            jb[3].setText("Devavarman");
        }
        if(current == 8)
        {
            l.setText("Q 9 - The playing area of Ice Hockey is known as ___________ .");
            jb[0].setText("Rink");
            jb[1].setText("Track");
            jb[2].setText("Ring");
            jb[3].setText("Pool");
        }
        if(current == 9)
        {
            l.setText("Q 10 - Malabar Hill is located in ___________ .");
            jb[0].setText("Karnataka");
            jb[1].setText("Rajasthan");
            jb[2].setText("Maharashtra");
            jb[3].setText("Tamil Nadu");
        }

        l.setBounds(30,40,450,20);

        for(int i=0, j=0; i<=90; i+=30, j++)
            jb[j].setBounds(50,80+i,200,20);
    }

    boolean checkForAns()
    {
        if(current == 0)
            return(jb[2].isSelected());
        if(current == 1)
            return(jb[0].isSelected());
        if(current == 2)
            return(jb[1].isSelected());
        if(current == 3)
            return(jb[2].isSelected());
        if(current == 4)
            return(jb[0].isSelected());
        if(current == 5)
            return(jb[1].isSelected());
        if(current == 6)
            return(jb[1].isSelected());
        if(current == 7)
            return(jb[0].isSelected());
        if(current == 8)
            return(jb[0].isSelected());
        if(current == 9)
            return(jb[2].isSelected());

        return false;
    }

    public static void main(String[] args)
    {
        new OnlineTest("Online Test For General Knowledge");
    }
}