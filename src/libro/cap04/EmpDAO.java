/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libro.cap04;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import libro.cap03.UConnection;

/**
 *
 * @author Abel Rodríguez
 */
public abstract class EmpDAO {
    
    // metodo abstracto, debe ser resuelto en las subclases
    public abstract String queryBuscarUltimosEmpleados();
    
    // este metodo ya no necesita ser abstracto porque puede obtener el query
    // invocando al metodo abstracto queryBuscarUltimosEmpleados
    public Collection<EmpDTO> buscarUltimosEmpleados(int n) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            con = UConnection.getConnection();
            String sql = queryBuscarUltimosEmpleados();
            
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, n);
            rs = pstm.executeQuery();
            
            ArrayList<EmpDTO> ret = new ArrayList<EmpDTO>();
            EmpDTO dto = null;
            
            while (rs.next()) {
                dto = new EmpDTO();
                dto.setEmpno(rs.getInt("empno"));
                dto.setEname(rs.getString("ename"));
                dto.setHiredate(rs.getDate("hiredate"));
                dto.setDeptno(rs.getInt("deptno"));
                
                ret.add(dto);
            }
            
            return ret;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        finally {
            try {
                if( rs != null) rs.close();
                if( pstm != null) pstm.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
    
    // este metodo es comun a todas las bases de datos por lo tanto
    // podemos resolverlo aquí y no necesita ser declarado abstracto
    public Collection<EmpDTO> buscarXDept(int deptno) {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            con = UConnection.getConnection();
            String sql = "";
            sql += "SELECT empno, ename, hiredate, deptno ";
            sql += "FROM  emp ";
            sql += "WHERE deptno = ?";
            
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, deptno);
            rs = pstm.executeQuery();
            
            ArrayList<EmpDTO> ret = new ArrayList<EmpDTO>();
            EmpDTO dto = null;
            
            while (rs.next()) {
                dto = new EmpDTO();
                dto.setEmpno(rs.getInt("empno"));
                dto.setEname(rs.getString("ename"));
                dto.setHiredate(rs.getDate("hiredate"));
                dto.setDeptno(rs.getInt("deptno"));
                
                ret.add(dto);
            }
            
            return ret;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } 
        finally {
            try {
                if( rs != null) rs.close();
                if( pstm != null) pstm.close();
            } 
            catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}
