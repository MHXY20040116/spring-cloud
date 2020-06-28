package cn.gpnu.springcloud.controller;

import cn.gpnu.springcloud.entity.DeptEntity;
import cn.gpnu.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptProviderController {

    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    public boolean addDept(@RequestBody DeptEntity deptEntity) {
        return deptService.addDept(deptEntity);
    }

    @RequestMapping(value = "/dept/get/{deptNo}", method = RequestMethod.GET)
    public DeptEntity findById(@PathVariable("deptNo") Long deptNo) {
        return deptService.getById(deptNo);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<DeptEntity> listAll() {
        return deptService.listAll();
    }

}
