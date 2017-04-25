
package ejemplo;

import DAO.DAOPersonaImpl;
import interFaces.DAOPersona;


public class Prueba {
    
    public static void main(String[] args) {
        Persona per = new Persona();
        per.setId(1);
        per.setNombre("Andrea");
        
        try {
            DAOPersona dao = new DAOPersonaImpl();
            dao.modificar(per);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
}
