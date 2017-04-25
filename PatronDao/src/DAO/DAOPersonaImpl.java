
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import ejemplo.Persona;
import interFaces.DAOPersona;
import java.util.List;
import java.util.ArrayList;


public class DAOPersonaImpl extends Conexion implements DAOPersona{
    
    
    @Override
    public void registrar(Persona per) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("INSERT INTO personal(nombre) VALUES (?)");
            st.setString(1, per.getNombre());
            st.executeUpdate();
            
        } catch (Exception e) {
        }
        finally{
            this.cerrar();
        }
    }
    @Override
    public void modificar(Persona per) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("UPDATE personal set nombre = ? where id = ?");
            
            st.setString(1, per.getNombre());
            st.setInt(2, per.getId());
            st.executeUpdate();
            
        } catch (Exception e) {
        }
        finally{
            this.cerrar();
        }
        
    }
    @Override
    public void eliminar(Persona per) throws Exception{
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("DELETE from personal where id = ?");
            st.setInt(1, per.getId());
            st.executeUpdate();
            
        } catch (Exception e) {
        }
        finally{
            this.cerrar();
        }
    }
    @Override
    public List<Persona> listar() throws Exception{
        List<Persona> lista = null;
        try {
            this.conectar();
            PreparedStatement st = this.conexion.prepareStatement("SELECT * FROM Personal");
            
            lista = new ArrayList();
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                Persona per = new Persona();
                per.setId(rs.getInt("id"));
                per.setNombre(rs.getString("nombre"));
                lista.add(per);
            }
            rs.close();
            st.close();
        } catch (Exception e) {
        }
        finally{
            this.cerrar();
        }
        return lista;
    }
    
    
}
