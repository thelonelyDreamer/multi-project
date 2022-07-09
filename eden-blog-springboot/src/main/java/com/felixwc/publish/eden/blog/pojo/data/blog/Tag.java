package com.felixwc.publish.eden.blog.pojo.data.blog;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * in order to learn java!
 * created at 2022/7/4 23:03
 *
 * @author felixwc
 */
@Data
@ApiModel
public class Tag {
    @ApiModelProperty(name = "tag_id")
    private Long tagId;
    private String tagName;
    /* 每个表的六个字段 */
    private Boolean deletedFlag;
    private Long version;
    private Date createdTime;
    private String createdUser;
    private Date updatingTime;
    private String updatingUser;
}
