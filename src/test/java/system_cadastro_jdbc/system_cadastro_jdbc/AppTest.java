package system_cadastro_jdbc.system_cadastro_jdbc;

import static org.junit.Assert.assertTrue;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserDao;
import model.Users;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
    
    
    @Test
    public void initCadastro() {
    	Users users = new Users();
    	UserDao userDao = new UserDao();
    	
    	users.setName("Ricardo R");
    	users.setEmail("exemple@exemple.com.br");
    	users.setCelular("(00) 00000-0000 ");
    	
    	userDao.save(users);
    }
    
    
    @Test
    public void initUpdateUser() {
    	
    	Users users = new Users();
    	UserDao userDao = new UserDao();
    	
    	try {
			users = userDao.loadById(4);
			
			users.setName("Ricardo Teste Update");
	    	users.setCelular("(00) 00000-0001 ");
	    	
	    	userDao.updateUser(users);
		} 
    	catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    
    @Test
    public void initDelete() {
    	UserDao userDao = new UserDao();
    	userDao.delete(3);
    }
    
   
    @Test
    public void initListUsers() {
    	UserDao userDao = new UserDao();
    	
    	List<Users> list = userDao.listUsers();
    	
    	for(Users users : list) {
    		System.out.println(users);
    		System.out.println("-------------");
    	}
    }
}
