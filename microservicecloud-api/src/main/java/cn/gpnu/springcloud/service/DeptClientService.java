package cn.gpnu.springcloud.service;

import cn.gpnu.springcloud.entity.DeptEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "MSC-DEPT", fallbackFactory = DeptClientServiceFallBackFactory.class)
public interface DeptClientService {

    @RequestMapping(value = "/dept/add", method = RequestMethod.POST)
    boolean add(DeptEntity deptEntity);

    @RequestMapping(value = "/dept/get/{deptNo}", method = RequestMethod.GET)
    DeptEntity getById(@PathVariable("deptNo") Long deptNo);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    List<DeptEntity> list();

}
