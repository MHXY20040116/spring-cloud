package cn.gpnu.springcloud.controller;

import cn.gpnu.springcloud.entity.DeptEntity;
import cn.gpnu.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity deptEntity) {
        return deptClientService.add(deptEntity);
    }

    @RequestMapping("/consumer/dept/get/{deptNo}")
    public DeptEntity getById(@PathVariable("deptNo") Long deptNo) {
        return deptClientService.getById(deptNo);
    }

    @RequestMapping("/consumer/dept/list")
    public List<DeptEntity> list() {
        return deptClientService.list();
    }

}
