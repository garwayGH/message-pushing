package com.viatom.messagepushing.mapper.iwown;

import com.viatom.messagepushing.pojo.iwown.ClientInfo;
import org.springframework.stereotype.Repository;

/**
 * @author qiujiawei
 * @description ClientInfoMapper
 * @date 2020/11/27 16:41
 */
@Repository
public interface ClientInfoMapper {

    /**
     * 获取最新的版本号
     * @return
     */
    ClientInfo getLastAppVersion();

}
