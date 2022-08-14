package com.felixwc.store.computer.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * in order to learn java!
 * created at 2022/7/16 22:16
 *
 * @author felixwc
 */
@Table(name = "person")
@Entity
public class Person {
    @Id
    private Long id;

}
