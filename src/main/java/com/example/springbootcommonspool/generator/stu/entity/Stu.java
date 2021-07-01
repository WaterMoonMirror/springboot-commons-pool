package com.example.springbootcommonspool.generator.stu.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author kenx
 * @since 2021-07-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Stu implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    private Integer age;


}
