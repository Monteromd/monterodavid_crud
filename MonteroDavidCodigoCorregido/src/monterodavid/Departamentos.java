/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterodavid;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Montero
 */
public class Departamentos {

    Connection conexion;
    
    ArrayList<Departamento> listaDepartamentos;
    
    public Departamentos() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            System.out.println("#### ERROR D/Conn ####");
            System.out.println("Por favor, intente conectarse de nuevo más tarde. Si el problema persistiera, contacte "
                    + "con el administrador y suministre el código de error.");
        }
    }
    
    public int Create(Departamento dep) throws SQLException {
        int filas;
        String sql = "INSERT INTO departamentos VALUES ( ?, ?, ? )"; //Este String es la consulta de la base de datos
        PreparedStatement sentencia = conexion.prepareStatement(sql); // preparamos la sentencia k vamos a usar, ya que la tenemos incompleta (tenemos las interrogaciones en vez de datos)
        sentencia.setInt(1, dep.getNumero());
        sentencia.setString(2, dep.getNombre());
        sentencia.setString(3, dep.getLocalizacion());
        filas = sentencia.executeUpdate();
        return filas;
    }
    
    public void Update(int dep_no, Departamento dep) throws SQLException {

        String sql = "UPTADE SET ? FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, (""));
        sentencia.setInt(2, (dep_no));
        sentencia.executeUpdate();
    }

    public Departamento ReadUno(int dnombre) throws SQLException {
        Departamento dep = new Departamento();
        String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dnombre);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep.setNumero(rs.getInt(1));
        dep.setNombre(rs.getString(2));
        dep.setLocalizacion(rs.getString(3));
        return dep;
    }
    public ArrayList <Departamento> ReadTodos() throws SQLException {
        Departamento dep;
        listaDepartamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        while(rs.next()){
        dep = new Departamento();
        dep.setNumero(rs.getInt(1));
        dep.setNombre(rs.getString(2));
        dep.setLocalizacion(rs.getString(3));
        listaDepartamentos.add(dep);
        }
        return listaDepartamentos;
    }

    public int Delete(int dep_no) throws SQLException {
        int filas;
        String sql = "DELETE FROM departamentos WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, (dep_no));
        filas = sentencia.executeUpdate();
        return filas;
    }

    public void Close() throws SQLException {
        conexion.close();
    }
public Departamento busqueda (String dnombre) throws SQLException {
        Departamento dep = new Departamento();
        String sql = "SELECT * FROM departamentos WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dnombre);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        dep.setNumero(rs.getInt(1));
        dep.setNombre(rs.getString(2));
        dep.setLocalizacion(rs.getString(3));
        return dep;
} 

    
}
