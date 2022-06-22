import com.denik.vy.dao.UserDao;
import com.denik.vy.dao.UserDaoHibernate;
import com.denik.vy.models.User;
import static org.junit.Assert.*;

import com.denik.vy.services.UserService;
import com.denik.vy.services.UserServiceImp;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class UserDaoHibernateTest {

    User user1 = new User("Join1", "JoinLast1", (byte)10);
    User user2 = new User("Join2", "JoinLast2", (byte)20);
    User user3 = new User("Join3", "JoinLast3", (byte)30);
    UserService dao = new UserServiceImp();
    @Test
    public void hibernateTest(){
        try{

            dao.dropTable();
            dao.createTable();
            dao.addUser(user1);
            dao.addUser(user2);
            dao.addUser(user3);
            List<User> users = dao.getAllUsers();
            User user = users.get(0);
            assertEquals(user, user1);
            dao.removeUser(1);

            List<User> users1 = dao.getAllUsers();
            assertEquals(2, users1.size());
            dao.cleanTable();
            users = dao.getAllUsers();
            assertEquals(0, users.size());
            dao.dropTable();
        }catch (SQLException e){
            fail("Ошибка " + e.getMessage());
        }
    }
    @Test
    public void createRemove(){
        try {
            dao.dropTable();
            dao.createTable();
            dao.addUser(user1);
            dao.addUser(user2);
            dao.addUser(user3);
            dao.removeUser(1);
            dao.dropTable();
        }catch (Exception e){
            fail("sa: " + e.getMessage());
        }
    }
    @Test
    public void EqualsUser(){
        User user1 = new User("Join1", "JoinLast1", (byte)10);
        User user2 = new User("Join1", "JoinLast1", (byte)10);
        User user3 = new User("Join3", "JoinLast3", (byte)30);
        assertEquals(user1, user2);
        assertEquals(user2, user1);
        assertNotEquals(user1, user3);
        assertNotEquals(null, user1);
    }
}
