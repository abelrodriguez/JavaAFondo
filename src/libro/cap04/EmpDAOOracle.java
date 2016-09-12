/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04;


/**
 *
 * @author Abel Rodríguez
 */
public class EmpDAOOracle extends EmpDAO {

    @Override
    public String queryBuscarUltimosEmpleados() {
        String sql = "";
        sql += "SELECT empno, ename, hiredate, deptno, ROWNUM AS rn ";
        sql += "FROM  (SELECT empno, ename, hiredate, deptno ";
        sql += "       FROM emp ";
        sql += "       ORDER BY hiredate DESC) ";
        sql += "WHERE rn <= ?";
            
        return sql;
    }
}
