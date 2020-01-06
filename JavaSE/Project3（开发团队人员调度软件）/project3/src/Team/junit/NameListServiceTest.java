package Team.junit;

import Team.domain.Employee;
import Team.service.NameListService;
import org.junit.Test;

public class NameListServiceTest {
    @Test
    public void testGetAllEmployees(){
        NameListService service=new NameListService();
        Employee[] allEmployees = service.getAllEmployees();
        for(Employee e:allEmployees){
            System.out.println(e);
        }
    }
}
