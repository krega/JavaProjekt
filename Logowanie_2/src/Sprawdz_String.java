
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public class Sprawdz_String {
   
    private Matcher stringDoSprawdzenia;
    private String patternString ="([0-9])?(@)+([A-Z1-9])";
//  private String patternStr="[A-Z]";
  // String patternStr=[A-Z];
  private Pattern pattern= Pattern.compile(patternString);
    
    public Sprawdz_String(String str)
    {
       stringDoSprawdzenia=pattern.matcher(str);
    }
    public boolean sprawdzString()
    {
        boolean match = stringDoSprawdzenia.find();
         if(match==true)
         {
               JOptionPane.showMessageDialog(null,"Poprawne haslo");
         }
         else {  JOptionPane.showMessageDialog(null,"Haslo powinno zawierac co najmniej jedna duza litere, co najmniej jedna cyfre i znak '@'");
         
         }
         
         return match;
    }
}
