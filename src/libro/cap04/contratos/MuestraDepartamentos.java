/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04.contratos;

import java.util.Collection;
import libro.cap04.DeptDTO;
import libro.cap04.UFactory;

/**
 *
 * @author Abel Rodríguez
 */
public class MuestraDepartamentos {
    
    public static void main(String[] args) {
        Dept d = (Dept) UFactory.getInstancia("DEPT");
        Collection<DeptDTO> coll = d.buscarTodos();
        
        for (DeptDTO dto:coll) {
            System.out.println(dto);
        }
    }
}
