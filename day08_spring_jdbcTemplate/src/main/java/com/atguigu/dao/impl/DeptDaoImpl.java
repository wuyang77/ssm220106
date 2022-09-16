package com.atguigu.dao.impl;

import com.atguigu.dao.DeptDao;
import com.atguigu.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository("deptDao")
public class DeptDaoImpl implements DeptDao {

    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Dept> selectAllDepts() {
        String sql = "select dept_id,dept_name from tbl_dept";
        RowMapper<Dept> rowMapper = new BeanPropertyRowMapper<>(Dept.class);
        return jdbcTemplate.query(sql,rowMapper);
    }
}
