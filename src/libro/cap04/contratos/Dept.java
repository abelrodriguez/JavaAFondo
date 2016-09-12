/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04.contratos;

import java.util.Collection;
import libro.cap04.DeptDTO;

/**
 *
 * @author Abel Rodríguez
 */
public interface Dept {
    
    public Collection<DeptDTO> buscarTodos();
}
