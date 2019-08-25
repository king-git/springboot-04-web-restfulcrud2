package com.caihao.springboot.controller;

import com.caihao.springboot.dao.DepartmentDao;
import com.caihao.springboot.dao.EmployeeDao;
import com.caihao.springboot.entities.Department;
import com.caihao.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

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


    //员工添加操作


    @PostMapping("/emp")
    public String addEmp(Employee employee) {

        System.err.println("emp====="+employee);

        //保存员工
        employeeDao.save(employee);

        //添加完成后，返回员工添加页面
        //redirect:表示重定向到一个地址, / : 代表当前项目路径
        //forward：表示转发到一个地址
        return "redirect:/emps";
    }


    //来到修改页面，回显修改的员工的信息
    @GetMapping("/emp/{id}")
    public String editEmp(@PathVariable(value = "id",required = true) Integer id,
                          Model model){
        //查询员工信息
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        //查询部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        //回到修改页面，（add是一个添加修改二合一的页面）
        return "emp/add";
    }

    //员工修改
    @PutMapping("/emp")
    public String updEmp(Employee employee){

        System.err.println("修改的emp====="+employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }








}
