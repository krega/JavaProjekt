
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Kamil
 */
public interface ICredentialHandler {

    HashMap Odczyt() throws IOException;
    Long zapisNowegoUzytkownika(Credentials Cr1) throws IOException;
    void zapiszWynik(Long EmployeeID, Map mapa ) throws IOException;
   
   
    
}
