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
 */
public class MonteroDavid {

    
    /*Aqui pondremos parte de la informacion que vera el usuario por pantalla, con la opciones a elegir, lo ponemos bonito para que se vea mejor presentado*/
    public static void main(String[] args) throws SQLException {
        
        DepartamentosSalida DepSal = new DepartamentosSalida();
        Scanner sc = new Scanner(System.in);
        
        EmpleadosSalida EmpSal = new EmpleadosSalida();
               

        
        System.out.println("½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½"); 
        System.out.println("½"+ "                                    "+"½"); 
        System.out.println("½"+ "         ELIGE UNA OPCION           "+"½"); 
        System.out.println("½"+ "                                    "+"½");       
        System.out.println("½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½");         
        System.out.println("½"+ " « 1 »   Listar Departamentos       "+"½"); 
        System.out.println("½"+ " « 2 »   Buscar Departamento        "+"½"); 
        System.out.println("½"+ " « 3 »   Crear Departamentos        "+"½"); 
        System.out.println("½"+ " « 4 »   Borrar Departamentos       "+"½"); 
        System.out.println("½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½");         
        System.out.println("½"+ " « 5 »   Listar Empleados           "+"½"); 
        System.out.println("½"+ " « 6 »   Buscar Empleado            "+"½"); 
        System.out.println("½"+ " « 7 »   Crear  Empleados           "+"½"); 
        System.out.println("½"+ " « 8 »   Borrar Empleados           "+"½");
        System.out.println("½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½");         
        System.out.println("½"+ "                                    "+"½"); 
        System.out.println("½"+ "           INFORMACIÓN:             "+"½"); 
        System.out.println("½"+ "                                    "+"½"); 
        System.out.println("½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½½");         

        
        /*Ponemos los casos que tenemos*/
        switch(Integer.parseInt(sc.nextLine()))
        {
            case 1:
                    DepSal.listado();
                break;
            case 2:
                DepSal.busquedaDepartamento();
                break;
            case 3:
                DepSal.createDpto();
                break;
            case 4:
                DepSal.todelete();
                break;
               case 5:
                    EmpSal.listado();
                break;
            case 6:
                EmpSal.listabusqueda();
                break;
            case 7:
                EmpSal.createDpto();
                break;
            case 8:
                EmpSal.todelete();
                break; 
        }
        
    }
    
}
