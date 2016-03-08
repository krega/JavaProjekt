
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamil
 */
public interface IPobierzPytanie {
    LinkedList PobierzPytanie(Kategoria kategoria)throws FileNotFoundException;
     
    
}

