package cn.gpnu.springcloud.controller;

import cn.gpnu.springcloud.entity.DeptEntity;
import cn.gpnu.springcloud.service.DeptService;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DeptProviderController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    /**
     * 增加自己服务描述的接口
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有 " + list.size() + " 个微服务:" + list);

        // 查询 MSC-DEPT8001 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("MSC-DEPT8001");

        // 打印 MSC-DEPT8001 服务信息
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }

        return this.discoveryClient;
    }

}
