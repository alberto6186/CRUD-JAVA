
package Logica;


import Modelo.Persona;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class PersonaService {
    
    private Conexion mysql = new Conexion();
    private Connection cn = mysql.conectar();
    private String query = "";
    public Integer totalregistros;
    
    public DefaultTableModel mostrar(String buscar){
        DefaultTableModel modelo;
        
        String [] titulos = {"ID", "TIPO IDENT", "NUMERO IDENT", "NOMBRE", "1° APELLIDO", "2° APELLIDO"};
        String[] registro = new String [6];
        
        totalregistros = 0;
        modelo = new DefaultTableModel(null, titulos);
        
        query = "SELECT * FROM persona WHERE numero_identificacion like '%"+buscar+"%' order by id_persona";
        
        try{
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next()){
                registro[0] = rs.getString("id_persona");
                registro[1] = rs.getString("tipo_identificacion");
                registro[2] = rs.getString("numero_identificacion");
                registro[3] = rs.getString("nombre");
                registro[4] = rs.getString("primer_apellido");
                registro[5] = rs.getString("segundo_apellido");
                
                totalregistros = totalregistros + 1;
                modelo.addRow(registro);
                
            }
            
            return modelo;
            
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }
    
    public boolean insertar(Persona dts){
        query = "INSERT INTO persona (tipo_identificacion, numero_identificacion, nombre, primer_apellido, segundo_apellido)"+
                "VALUES(?,?,?,?,?)";
        try{
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getTipo_identificacion());
            pst.setString(2, dts.getNumero_identificacion());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getPrimer_apellido());
            pst.setString(5, dts.getSegundo_apellido());
            
            int n = pst.executeUpdate();
            if(n != 0){
                return true;
            }else{
                return false;
            }
            
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
    
    public boolean editar(Persona dts){
        query = "UPDATE persona SET tipo_identificacion=?, numero_identificacion=?, nombre=?, primer_apellido=?, segundo_apellido=?"+
                "WHERE id_persona =?";
        try{
            PreparedStatement pst = cn.prepareStatement(query);
            pst.setString(1, dts.getTipo_identificacion());
            pst.setString(2, dts.getNumero_identificacion());
            pst.setString(3, dts.getNombre());
            pst.setString(4, dts.getPrimer_apellido());
            pst.setString(5, dts.getSegundo_apellido());
            pst.setInt(6, dts.getId_persona());
            
            int n = pst.executeUpdate();
            
            return n !=0;
           
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
        
    }
    
    public boolean eliminar(Persona dts){
        query = "DELETE from persona WHERE id_persona =?";
        try{
            PreparedStatement pst = cn.prepareStatement(query);
            
            pst.setInt(1, dts.getId_persona());
            
            int n = pst.executeUpdate();
            
            return n !=0;
            
        }catch(SQLException e){
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
        
    }
    
}
