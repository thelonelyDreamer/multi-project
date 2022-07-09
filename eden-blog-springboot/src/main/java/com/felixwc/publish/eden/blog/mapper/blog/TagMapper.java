package com.felixwc.publish.eden.blog.mapper.blog;

import com.felixwc.publish.eden.blog.pojo.data.blog.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.Set;

/**
 * in order to learn java!
 * created at 2022/7/4 23:36
 *
 * @author felixwc
 */
@Mapper
public interface TagMapper {
    Set<Tag> getAllTag();

    Tag obtainTagById(Long id);
}
