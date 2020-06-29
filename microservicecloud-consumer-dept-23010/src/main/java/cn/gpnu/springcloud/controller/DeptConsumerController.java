package cn.gpnu.springcloud.controller;

import cn.gpnu.springcloud.entity.DeptEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

//    private static final String REST_URL_PREFIX = "http://localhost:22010";
    /**
     * 注册再EurekaServer中的微服务名称
     */
    private static final String REST_URL_PREFIX="http://MSC-DEPT";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/consumer/dept/add")
    public boolean add(DeptEntity deptEntity) {
        // 参数：url, requestMap, ResponseBean.class
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/add", deptEntity, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{deptNo}")
    public DeptEntity getById(@PathVariable("deptNo") Long deptNo){
        // 参数：url, requestMap
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + deptNo, DeptEntity.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List list(){
        // 参数：url, requestMap
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

    /**
     * 服务发现
     */
    @RequestMapping(value = "/consumer/dept/discovery")
    public Object discovery(){
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/discovery", Object.class);
    }

}
