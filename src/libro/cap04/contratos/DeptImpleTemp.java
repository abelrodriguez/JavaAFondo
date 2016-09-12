/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04.contratos;

import java.util.ArrayList;
import java.util.Collection;
import libro.cap04.DeptDTO;

/**
 *
 * @author Abel Rodríguez
 */
public class DeptImpleTemp implements Dept {
    
    @Override
    public Collection<DeptDTO> buscarTodos() {
        
        DeptDTO d1 = new DeptDTO();
        d1.setDeptno(1);
        d1.setDname("Ventas");
        d1.setLoc("Capital");
        
        DeptDTO d2 = new DeptDTO();
        d2.setDeptno(2);
        d2.setDname("Compras");
        d2.setLoc("Capital");
        
        DeptDTO d3 = new DeptDTO();
        d3.setDeptno(3);
        d3.setDname("RRHH");
        d3.setLoc("Buenos Aires");
        
        ArrayList<DeptDTO> ret = new ArrayList<DeptDTO>();
        ret.add(d1);
        ret.add(d2);
        ret.add(d3);
        
        return ret;
    }
}
