package com.xd.ums.dao;

import com.xd.ums.domain.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface DepartMapper {

    @Select("SELECT * FROM ums_department")
    List<Department> findAllDepart();

}
