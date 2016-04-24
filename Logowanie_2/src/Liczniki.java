
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

@javax.persistence.Entity
public class Liczniki implements Serializable{
   
    @Id
    @GeneratedValue
    private long id;
    private int poprawne;
    private int niepoprawne;
   
    public Liczniki() {
        poprawne=-1;
        niepoprawne=-1;
    }
    public Liczniki(int pierwszy, int drugi)
    {
        poprawne=pierwszy;
        niepoprawne=drugi;
    }

    public int getPoprawne() {
        return poprawne;
    }

    public void setPoprawne(int Poprawne) {
        this.poprawne = Poprawne;
    }

    public int getNiepoprawne() {
        return niepoprawne;
    }

    public void setNiepoprawne(int Niepoprawne) {
        this.niepoprawne = Niepoprawne;
    }
    
    public long getId() {
      return id;
   }
   public void setId( long id ) {
      this.id = id;
   }
   
   @ManyToOne
   public User getUser() { return user; }
   public void setCustomer(User user) { this.user = user; }
   private User user;
}
