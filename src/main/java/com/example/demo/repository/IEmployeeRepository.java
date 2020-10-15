package com.example.demo.repository;

import com.example.demo.model.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author nvdat2
 */
@Mapper
@Repository
public interface IEmployeeRepository {
    @Select("select * from employees")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email")})
    List<Employee> findAll();

    @Select("select first_name, last_name, email from employees where id = #{id}")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
            @Result(property = "email", column = "email")})
    Employee findById(@Param("id") Long id);

    @Delete("delete from employees where id = #{id}")
    int deleteById(@Param("id") Long id);

    @Update("update employees set first_name = #{firstName}, last_name = #{lastName}, email = #{email} where id = #{id}")
    int update(Employee employee);

    @Insert("insert into employees(first_name, last_name, email) values (#{firstName}, #{lastName}, #{email})")
    int insert(Employee employee);

}
