package com.caihao.springboot.controller;

import com.caihao.springboot.dao.DepartmentDao;
import com.caihao.springboot.dao.EmployeeDao;
import com.caihao.springboot.entities.Department;
import com.caihao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

/**
 * @author CaiHao
 * @create 2019-04-14 18:59:39
 */

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;


    //查询所有员工的信息，返回list页面
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> emps = employeeDao.getAll();
        model.addAttribute("emps",emps);
        return "emp/list";
    }



    //来到员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //来到添加页面,查出所有部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }


}
