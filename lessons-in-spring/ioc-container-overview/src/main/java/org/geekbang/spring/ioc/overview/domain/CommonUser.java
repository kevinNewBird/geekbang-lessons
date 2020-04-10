package org.geekbang.spring.ioc.overview.domain;

import lombok.Data;
import lombok.ToString;
import org.geekbang.spring.ioc.overview.annotation.Super;

/**
 * Description: TODO <BR>
 *
 * @Author: zhao.song
 * @Date: 2020/4/10 17:47
 * @Version: 1.0
 */
@Super
@Data
@ToString(callSuper = true)
public class CommonUser extends User {

    private String phoneNum;

}
