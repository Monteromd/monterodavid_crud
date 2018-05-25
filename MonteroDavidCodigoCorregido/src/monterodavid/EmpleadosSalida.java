/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monterodavid;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Montero
 * 
 * Creamos los diferentes metodos metodos CRUD: Create, Read, Update y Delete
 * Cada metodo tiene sus atributos
 */
public class EmpleadosSalida {
 
    Empleados emp = new Empleados(); //creamos un objeto llamado emp para llamar a a los metodos de Empleados
    Scanner sc = new Scanner(System.in);

    public void listado() throws SQLException {
        Empleado emp2 = new Empleado();
                System.out.println("1- Mostrar 1 empleado. 2- Mostrar todos los empleados.");

        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                System.out.println("dime el numero de empleado");
                  emp2 = emp.ReadUno(Integer.parseInt(sc.nextLine()));
                    System.out.println(emp2.getEmp_no());
                    System.out.println(emp2.getApellido());
                    System.out.println(emp2.getOficio());
                    System.out.println(emp2.getDir());
                    System.out.println(emp2.getFecha_alt());
                    System.out.println(emp2.getSalario());
                    System.out.println(emp2.getComision());
                    System.out.println(emp2.getDept_no());
                break;
            case 2:
                emp.ReadTodos();
                for (int i = 0; i<emp.listaEmpleados.size(); i++){
                    emp2= emp.listaEmpleados.get(i);
                    System.out.println(emp2.getEmp_no());
                    System.out.println(emp2.getApellido());
                    System.out.println(emp2.getOficio());
                    System.out.println(emp2.getDir());
                    System.out.println(emp2.getFecha_alt());
                    System.out.println(emp2.getSalario());
                    System.out.println(emp2.getComision());
                    System.out.println(emp2.getDept_no());
                }
        }
    }
     public void listabusqueda() throws SQLException {
        Empleado emp2 = new Empleado();               /*Creamos un nuevo empleado*/
      
                  emp2 = emp.busqueda(sc.nextLine());
                    System.out.println(emp2.getEmp_no()+" "+emp2.getApellido() + " "+emp2.getOficio()+""+emp2.getDir()+""+emp2.getFecha_alt()+""+emp2.getSalario()+""+emp2.getComision()+""+emp2.getDept_no() );
           
     }
    
        public void todelete() throws SQLException {
            System.out.println("Dime nº del empleado");
        Empleado emp2 = new Empleado();
      
                  
                    System.out.println(emp.Delete(sc.nextInt()));
           
     }
        public void createDpto() throws SQLException{
        Empleado empdo = new Empleado();
        Empleados empdo2 = new Empleados();

        empdo.setEmp_no(Integer.parseInt(sc.nextLine()));
        empdo.setApellido(sc.nextLine());
        empdo.setOficio(sc.nextLine());
        empdo.setDir(sc.nextInt());
        java.sql.Date fecha = java.sql.Date.valueOf(sc.nextLine());
        empdo.setFecha_alt(fecha);
        empdo.setSalario(sc.nextInt());
        empdo.setComision(sc.nextInt());
        empdo.setDept_no(sc.nextInt());


        
        System.out.println(empdo2.Create(empdo));
        

}

    

}
