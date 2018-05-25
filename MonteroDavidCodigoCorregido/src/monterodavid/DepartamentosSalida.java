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
public class DepartamentosSalida {

    Departamentos dep = new Departamentos(); //creamos un objeto llamado dep para llamar a a los metodos de Departamentos
    Scanner sc = new Scanner(System.in);

    public void listado() throws SQLException {
        Departamento dep2;
        System.out.println("1- Mostrar 1 departamento. 2- Mostrar todos los departamentos.");
        switch (Integer.parseInt(sc.nextLine())) {
            case 1:
                  
                  System.out.println("dime el numero de departamento");
                  dep2 = dep.ReadUno(Integer.parseInt(sc.nextLine()));
                    System.out.println(dep2.getNumero());
                    System.out.println(dep2.getNombre());
                    System.out.println(dep2.getLocalizacion());
                break;
            case 2:
                dep.ReadTodos();
                for (int i = 0; i< dep.listaDepartamentos.size(); i++){
                    dep2 = dep.listaDepartamentos.get(i);     
                    System.out.println(dep2.getNumero());
                    System.out.println(dep2.getNombre());
                    System.out.println(dep2.getLocalizacion());
                }
        }
    }
     public void busquedaDepartamento() throws SQLException {
        Departamento dep2 = new Departamento();
      
                  dep2 = dep.busqueda(sc.nextLine());
                    System.out.println(dep2.getNombre()+" "+dep2.getNumero() + " "+dep2.getLocalizacion() );
           
     }
    
        public void todelete() throws SQLException {
            System.out.println("Dime nº del departamento");
                  
                    dep.Delete(Integer.parseInt(sc.nextLine()));
           
     }
        public void createDpto() throws SQLException{
        Departamento dpto = new Departamento();
        Departamentos dpto2 = new Departamentos();

        dpto.setNombre(sc.nextLine());
        dpto.setNumero(Integer.parseInt(sc.nextLine()));
        dpto.setLocalizacion(sc.nextLine());
        
        
        System.out.println(dpto2.Create(dpto));
        

}

    


}
