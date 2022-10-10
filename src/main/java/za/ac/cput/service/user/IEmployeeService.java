package za.ac.cput.service.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.service.IService;

public interface IEmployeeService extends IService<Employee, Long> {
    boolean existsById(Long id);
}
