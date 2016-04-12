/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 * @param <<error>>
 * 
 * 
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 * 
 * 
 */
public class Liczniki {
    private int id;
    private int Poprawne;
    private int Niepoprawne;
    
    public Liczniki() {
        Poprawne=-1;
        Niepoprawne=-1;
    }
    public Liczniki(int pierwszy, int drugi)
    {
        Poprawne=pierwszy;
        Niepoprawne=drugi;
    }

    public int getPoprawne() {
        return Poprawne;
    }

    public void setPoprawne(int Poprawne) {
        this.Poprawne = Poprawne;
    }

    public int getNiepoprawne() {
        return Niepoprawne;
    }

    public void setNiepoprawne(int Niepoprawne) {
        this.Niepoprawne = Niepoprawne;
    }
    
    public int getId() {
      return id;
   }
   public void setId( int id ) {
      this.id = id;
   }
    
}
