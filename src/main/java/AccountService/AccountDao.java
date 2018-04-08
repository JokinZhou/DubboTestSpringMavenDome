/**
 * 
 */
package AccountService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

/**
 * @author lenovo
 *
 */
public class AccountDao extends NamedParameterJdbcDaoSupport { 
    public void saveAccount(Account account) { 
        String sql = "insert into tbl_account(id,name,age,sex) " + 
               "values(:id,:name,:age,:sex)"; 
        Map paramMap = new HashMap(); 
        paramMap.put("id", account.getId()); 
        paramMap.put("name", account.getName()); 
        paramMap.put("age", account.getAge()); 
        paramMap.put("sex",account.getSex()); 
        getNamedParameterJdbcTemplate().update(sql, paramMap); 
    } 
    
    public Account getAccountById(int id) { 
        String sql = "select id,name,age,sex from tbl_account where id=:id"; 
        Map paramMap = new HashMap(); 
        paramMap.put("id", id); 
        List<Account> matches = (List<Account>) getNamedParameterJdbcTemplate().query(sql, 
        paramMap,new ResultSetExtractor<Account>() { 
                    public Account mapRow(ResultSet rs, int rowNum) 
                            throws SQLException { 
                        Account a = new Account(); 
                        a.setId(rs.getInt(1)); 
                        a.setName(rs.getString(2)); 
                        a.setAge(rs.getInt(3)); 
                        a.setSex(rs.getString(4)); 
                        return a; 
                    }

					public Account extractData(ResultSet arg0) throws SQLException, DataAccessException {
						// TODO Auto-generated method stub
						return null;
					} 
            
        } );
        
        return matches.size()>0?matches.get(0):null; 
    } 
    
}