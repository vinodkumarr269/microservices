package com.hcl.java;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface EmployeeDao extends PagingAndSortingRepository<Employ, Integer>{
	@Query("SELECT e FROM Employ e WHERE dept=?1 AND desig=?2")
	List<Employ> findByDeptAndDesign(String dept,String desig);
	@Query("SELECT e FROM Employ e WHERE  dept=?1 AND desig =?2 AND basic<?3")
	List<Employ> findManagerSalary(String dept,String desig,int basic);
	@Query("SELECT e FROM Employ e WHERE basic<?1 AND desig=?2 AND name LIKE'v%'")
	List<Employ> findManagerName(int basic,String desig);
	@Query("SELECT e FROM Employ e WHERE name=?1")
	List<Employ> findName(String name);
	@Query("SELECT e FROM Employ e WHERE desig =?1  order by basic desc")
	List<Employ> findJavaEmp(String desig);
    @Query("SELECT e FROM Employ e WHERE desig=?1 AND basic<?2 AND name LIKE 'S%' order by basic desc ")
    List<Employ> findjavaM(String desig,int basic);
    @Query("SELECT e FROM Employ e WHERE desig=?1 AND basic<?2 AND name LIKE 'S%' ")
    List<Employ> findjavaM1(String desig,int basic);
   
}
