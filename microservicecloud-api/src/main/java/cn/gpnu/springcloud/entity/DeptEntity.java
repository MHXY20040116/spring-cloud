package cn.gpnu.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @description 部门实体类
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class DeptEntity implements Serializable {

    /**
     * 部门编码 主键
     */
    private Long deptNo;

    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 数据库名称
     */
    private String dbSource;

}
