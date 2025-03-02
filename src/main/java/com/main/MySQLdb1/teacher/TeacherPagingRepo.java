package com.main.MySQLdb1.teacher;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface TeacherPagingRepo extends PagingAndSortingRepository<Teacher, Integer> {

}
//
//public Slice<EmployeeEntity> findByFirstName(String firstName, Pageable pageable);
//Slice<EmployeeEntity> slicedResult = repository.findByFirstName("alex", paging); 
//
//List<EmployeeEntity> employeeList = slicedResult.getContent();
//Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by("email").ascending()); 
//
//Page<EmployeeEntity> pagedResult = repository.findAll(paging);
//@GetMapping
//public ResponseEntity<List<EmployeeEntity>> getAllEmployees(
//                    @RequestParam(defaultValue = "0") Integer pageNo,
//                    @RequestParam(defaultValue = "10") Integer pageSize,
//                    @RequestParam(defaultValue = "id") String sortBy)
//{
//    List<EmployeeEntity> list = service.getAllEmployees(pageNo, pageSize, sortBy);
//
//    return new ResponseEntity<List<EmployeeEntity>>(list, new HttpHeaders(), HttpStatus.OK);
//}