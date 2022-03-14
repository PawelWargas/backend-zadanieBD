package zadanie.manager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zadanie.manager.exception.UserNotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employees> getAll(){
      return employeeRepository.findAll();

    }

    public Employees addEmployee(Employees employee){
        return employeeRepository.save(employee);

    }

    public Employees updateEmployee(Employees employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }

    public Optional<Employees> findEmployeeById(Long Id){
        return Optional.ofNullable(employeeRepository.findById(Id).orElseThrow(() -> new UserNotFoundException("Użytkownik o id:" + Id + " nie został znaleziony")));
    }

}
