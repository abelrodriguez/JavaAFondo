/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04;

import java.util.Collection;

/**
 *
 * @author Abel Rodríguez
 */
public class TestDeptDAO {
    
    public static void main(String[] args) {
        //instancio un DTO
        DeptDAO dept = new DeptDAO();
        
        //le pido la coleccion de todos los departamentos
        Collection<DeptDTO> col1 = dept.buscarTodos();
        
        //itero la colección y muestro cada departamento (cada dto)
        for (DeptDTO dto:col1) {
            System.out.println(dto);
        }
    }
}
