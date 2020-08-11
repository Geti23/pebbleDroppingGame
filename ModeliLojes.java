import javax.swing.JOptionPane;// perdoret per GUI-input/output...

class ModeliLojes
{
    public static final int X = 1, O = -1;
    public static final int BOSH = 0;
      
    public int lojtari = 1;
    private final int[][] tabela = new int[6][6];
    public boolean eshteBOSH = false;
      
    /* E vendose nje X ose O ne pozicionin i,j. */
    public void vendoseShenjen(int y)
    {
        int x=5;

        for(int i=0;i<6;i++)
        {
            if(tabela[i][y] != BOSH)
            {
                x-=1;
            }
        }
        
        tabela[x][y] = lojtari;   // vendose shenjen per lojtarin aktual
        lojtari = -lojtari;       // nderro lojtarin (perdorim faktin se O = -X)        
    }
      
    /* Kontrollon nese konfiguracioni aktual i tabeles eshte nje fitore per lojtarin aktual. */ 
    public boolean eshteFitues(int lojtari)
    {
        var b=false;
        for(int i=0;i<6;i++)
        {
                 if((tabela[0][i]+tabela[1][i]+tabela[2][i]+tabela[3][i]+tabela[4][i]+tabela[5][i]==lojtari*6)||
                    (tabela[i][0]+tabela[i][1]+tabela[i][2]+tabela[i][3]+tabela[i][4]+tabela[i][5]==lojtari*6)||
                    (tabela[0][0]+tabela[1][1]+tabela[2][2]+tabela[3][3]+tabela[4][4]+tabela[5][5]==lojtari*6)||
                    (tabela[5][0]+tabela[4][1]+tabela[3][2]+tabela[2][3]+tabela[1][4]+tabela[0][5]==lojtari*6))
                     
                     b=true;
        }
        return b;
    }
      
    /* Shfaq lojtarin fitues ose nje barazim (loje e paperfunduar).*/
    public void shfaqFituesin()
    {
        if(eshteFitues(X))
        {
            JOptionPane.showMessageDialog(null, "\t>Fiton X...!!");
            eshteBOSH=false;
            System.exit(0);
        }
        
        else if(eshteFitues(O))
        {
            JOptionPane.showMessageDialog(null, "\t>Fiton O...!!");
            eshteBOSH=false;
            System.exit(0);
        }
        
        else
        {
            if(!eshteBOSH)
            {
                JOptionPane.showMessageDialog(null, "\t>S'ka fitues!");
                System.exit(0);
            }  
        }
    }
    
    /* E vizaton tabelen 6x6 */
    public String vizatimi()
    {
        StringBuilder s = new StringBuilder();
        eshteBOSH = false;
        
        for(int i=0;i<6;i++)
        {
            for(int j=0;j<6;j++)
            {   
                s.append("|");
                switch(tabela[i][j])
                {
                case X:
                    s.append(" X ");
                    break;
                case O:
                    s.append(" O ");
                    break;
                case BOSH:
                    s.append("   ");
                    eshteBOSH=true;
                    break;
                } 
            }
            
            if(i<5)
            {
                s.append("|\n");
            }
        }
        s.append("|\n");
        s.append("^^1^^^2^^^3^^^4^^^5^^^6^^");
        return s.toString();
    }
}