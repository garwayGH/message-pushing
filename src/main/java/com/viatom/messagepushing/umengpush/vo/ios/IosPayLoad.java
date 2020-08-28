package com.viatom.messagepushing.umengpush.vo.ios;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.viatom.messagepushing.umengpush.vo.PayLoad;
import lombok.Data;

/**
 * 具体消息内容(iOS最大为2012B)
 * @author qiujiawei
 * @description IOSPayLoad
 * @date 2020/8/19 16:45
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class IosPayLoad implements PayLoad {

    private Aps aps;

}
