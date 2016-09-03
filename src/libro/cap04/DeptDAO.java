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
 * @author abelr
 */
public class DeptDAO {
    
    public Collection<DeptDTO> buscarTodos() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;
        
        try {
            con = UConnection.getConnection();
            String sql = "Select deptno, dname, loc from dept";
            
            pstm = con.prepareStatement(sql);
            rs = pstm.executeQuery();
            
            ArrayList<DeptDTO> ret = new ArrayList<DeptDTO>();
            DeptDTO dto = null;
            
            while(rs.next()) {
                dto = new DeptDTO();
                dto.setDeptno(rs.getInt("deptno"));
                dto.setDname(rs.getString("dname"));
                dto.setLoc(rs.getString("loc"));
                ret.add(dto);
            }
            
            return ret;
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
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
