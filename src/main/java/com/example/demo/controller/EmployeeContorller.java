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

    //��ѯԱ���б�
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> employees =  employeeDao.getAll();
        model.addAttribute("emps", employees);
        //classpath:templates/xxxx.html
        return "emp/list";
    }

    //Ա�����ҳ��
    @GetMapping("/emp")
    public String toAddPage(Model model){
        //�������Ϊ������ֵ
        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //���Ա������
    //SpringMVC�Զ��������������ζ�������Խ���һһ�󶨣�Ҫ��������������ֺ�javaBean��εĶ�������һһ��Ӧ
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        employeeDao.save(employee);
        //��ӳɹ����ض���Ա���б�ҳ�棬�����·��͡�/emps������
        //��/������ǰ��Ŀ·��
        return "redirect:/emps";
    }

    //Ա���޸�ҳ�棬����·������
    @GetMapping("/emp/{empId}")
    public String toEditPage(@PathVariable("empId") Integer id, Model model){
        Employee employee1 = employeeDao.get(id);
        model.addAttribute("emp", employee1);
        Collection<Department> departments =  departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //�������ҳ��
        return "emp/add";
    }

    //�޸�Ա����������Ҫ����ԭʼ��Ա��id
    @PutMapping("/emp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:emps";
    }

    //ɾ��Ա������
    @DeleteMapping("/emp/{empId}")
    public String deleteEmp(@PathVariable("empId") Integer id, Model model){
            employeeDao.delete(id);
        return "redirect:/emps";
    }

}
