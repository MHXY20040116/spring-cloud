package cn.gpnu.springcloud.controller;

import cn.gpnu.springcloud.entity.DeptEntity;
import cn.gpnu.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
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
    @HystrixCommand(fallbackMethod = "processHystrix_GET")
    public DeptEntity getById(@PathVariable("deptNo") Long deptNo) {
        DeptEntity deptEntity = deptService.getById(deptNo);
        if (deptEntity == null) throw new RuntimeException("NONE");
        return deptEntity;
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<DeptEntity> listAll() {
        return deptService.listAll();
    }

    /**
     * 增加自己服务描述的接口
     *
     * @return
     */
    @RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> list = discoveryClient.getServices();
        System.out.println("总共有 " + list.size() + " 个微服务:" + list);

        // 查询 MSC-DEPT22010-Hystrix 服务
        List<ServiceInstance> instances = discoveryClient.getInstances("MSC-DEPT22010-Hystrix");

        // 打印 MSC-DEPT22010-Hystrix 服务信息
        for (ServiceInstance element : instances) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t" + element.getUri());
        }

        return this.discoveryClient;
    }

    public DeptEntity processHystrix_GET(@PathVariable("deptNo") Long deptNo){
        return new DeptEntity().setDeptNo(deptNo).setDeptName("没有对应信息").setDbSource("No Database in MySQL");
    }
}
