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
public class Facade {
    
    public Collection<EmpDTO> obtenerUltimosEmpleados(int n) {
        
        EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
        return empDao.buscarUltimosEmpleados(n);
    }
        
    public Collection<DeptDTO> obtenerDepartamentos() {
        
        DeptDAO deptDao = (DeptDAO) UFactory.getInstancia("DEPT");
        return deptDao.buscarTodos();
    }
    
    public Collection<EmpDTO> obtenerEmpleados(int deptno) {
        EmpDAO empDao = (EmpDAO) UFactory.getInstancia("EMP");
        return empDao.buscarXDept(deptno);
    }
}
