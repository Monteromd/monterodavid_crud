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
public class Empleados {
    

    Connection conexion;
    
    ArrayList<Empleado> listaEmpleados;
    
    public Empleados() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
        } catch (SQLException ex) {
            System.out.println("#### ERROR D/Conn ####");
            System.out.println("Por favor, intente conectarse de nuevo más tarde. Si el problema persistiera, contacte "
                    + "con el administrador y suministre el código de error.");
        }
    }
    
    public int Create(Empleado emp) throws SQLException {
        int filas;
        String sql = "INSERT INTO empleados VALUES ( ?, ?, ?, ?, ?, ?, ?, ? )"; //Este String es la consulta de la base de datos
        PreparedStatement sentencia = conexion.prepareStatement(sql); // preparamos la sentencia k vamos a usar, ya que la tenemos incompleta (tenemos las interrogaciones en vez de datos)
        sentencia.setInt(1, emp.getEmp_no());
        sentencia.setString(2, emp.getApellido());
        sentencia.setString(3, emp.getOficio());
        sentencia.setInt(4, emp.getDir());
        sentencia.setDate(5, emp.getFecha_alt());
        sentencia.setInt(6, emp.getSalario());
        sentencia.setInt(7, emp.getComision());
        sentencia.setInt(8, emp.getDept_no());
        filas = sentencia.executeUpdate();
        return filas;
    }
    
    public void Update(int emp_no, Empleado emp) throws SQLException {

        String sql = "UPTADE SET ? FROM departamentos WHERE emp_no = ?";// hacemos la sentencia del programa en cada metodo, y obtenemos un resultado
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, (""));
        sentencia.setInt(2, emp_no);
        sentencia.executeUpdate();
    }

    public Empleado ReadUno(int dnombre) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleados WHERE emp_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, dnombre);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDir(rs.getInt(4));
        emp.setFecha_alt(rs.getDate(5));
        emp.setSalario(rs.getInt(6));
        emp.setComision(rs.getInt(7));
        emp.setDept_no(rs.getInt(8));
        return emp;
    }
    public ArrayList <Empleado> ReadTodos() throws SQLException {
        Empleado emp;
        listaEmpleados = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
        while(rs.next()){
            emp = new Empleado();
        emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDir(rs.getInt(4));
        emp.setFecha_alt(rs.getDate(5));
        emp.setSalario(rs.getInt(6));
        emp.setComision(rs.getInt(7));
        emp.setDept_no(rs.getInt(8));
        listaEmpleados.add(emp);
        }
        return listaEmpleados;
    }

    public int Delete(int emp_no) throws SQLException {
        int filas;
        String sql = "DELETE FROM empleados WHERE dept_no = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setInt(1, (emp_no));
        filas = sentencia.executeUpdate();
        return filas;
    }

    public void Close() throws SQLException {
        conexion.close();
    }
public Empleado busqueda (String dnombre) throws SQLException {
        Empleado emp = new Empleado();
        String sql = "SELECT * FROM empleados WHERE dnombre = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, dnombre);
        ResultSet rs = sentencia.executeQuery();
        rs.first();
         emp.setEmp_no(rs.getInt(1));
        emp.setApellido(rs.getString(2));
        emp.setOficio(rs.getString(3));
        emp.setDir(rs.getInt(4));
        emp.setFecha_alt(rs.getDate(5));
        emp.setSalario(rs.getInt(6));
        emp.setComision(rs.getInt(7));
        emp.setDept_no(rs.getInt(8));

        return emp;
} 

    
}
