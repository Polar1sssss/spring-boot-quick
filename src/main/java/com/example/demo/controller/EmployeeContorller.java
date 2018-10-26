package com.example.demo.controller;

/**
 * @author hujtb
 * @create on 2018-10-23-10:30
 */

import com.example.demo.dao.DepartmentDao;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.entities.Department;
import com.example.demo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeContorller {

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询员工列表
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees =  employeeDao.getAll();
        model.addAttribute("emps", employees);
        //classpath:templates/xxxx.html
        return "emp/list";
    }

    //员工添加页面
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出部门为下拉框赋值
        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工操作
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定，要求请求参数的名字和javaBean入参的对象属性一一对应
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        employeeDao.save(employee);
        //添加成功后，重定向到员工列表页面，即重新发送“/emps”请求
        //“/”代表当前项目路径
        return "redirect:/emps";
    }

    //员工修改页面，传入路径变量
    @GetMapping("/emp/{empId}")
    public String toEditPage(@PathVariable("empId") Integer id, Model model){
        Employee employee1 = employeeDao.get(id);
        model.addAttribute("emp", employee1);
        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //重用添加页面
        return "emp/add";
    }

    //修改员工操作：需要传回原始的员工id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:emps";
    }

    //删除员工操作
    @DeleteMapping("/emp/{empId}")
    public String deleteEmp(@PathVariable("empId") Integer id, Model model){
            employeeDao.delete(id);
        return "redirect:/emps";
    }

}
