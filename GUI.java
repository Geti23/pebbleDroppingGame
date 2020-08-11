import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class GUI extends JFrame implements ActionListener
{       
    ModeliLojes m = new ModeliLojes();
    JButton[] b=new JButton[6];
    
    public GUI()
    {
        Container c=getContentPane();
        c.setLayout(new GridLayout(1,6));

        for(int i=0;i<6;i++)
        {
            b[i]=new JButton(""+(i+1));
            c.add(b[i]);
            b[i].addActionListener(this);
        }
        
        pack();
        setTitle("Pebble Drop");
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        new Renditesi(m.lojtari);
    }
    public void actionPerformed(ActionEvent ae)
    {
        for(int i=0;i<6;i++)
        {
            if(ae.getSource()==b[i]) 
            {
                try
            {
                m.vendoseShenjen(i);
            }
            catch(ArrayIndexOutOfBoundsException a)
            {
                JOptionPane.showMessageDialog(null, "Kolona "+(i+1)+" eshte e mbushur!\nProvo diku tjeter");
            }
            
            System.out.println(m.vizatimi());
            new Renditesi(m.lojtari);
            m.shfaqFituesin();
            }
        }
    }
}