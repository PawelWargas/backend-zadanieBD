package zadanie.manager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employees> getEmployees(){
        return employeeService.getAll();
    }

    @GetMapping("/find/id={id}")
    public Optional<Employees> getEmployeeById(@PathVariable("id") Long id){return employeeService.findEmployeeById(id);}

    @PostMapping("/add")
    public Employees addEmployee(@RequestBody Employees employee){
        return employeeService.addEmployee(employee);
    }

    @PutMapping("/update")
    public Employees updateEmployee(@RequestBody Employees employee){
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/delete/id={id}")
    public void deleteById(@PathVariable("id") Long id){
        employeeService.deleteEmployee(id);
    }



}
