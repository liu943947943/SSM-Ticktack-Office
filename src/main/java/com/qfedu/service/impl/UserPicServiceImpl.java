package com.qfedu.service.impl;/**
 * Created by HP on 2019/6/18.
 */

import com.qfedu.dao.UserPicDao;
import com.qfedu.service.UserPicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author HP liuchenglong
 * @create 2019-06-18 9:22
 **/
@Service
public class UserPicServiceImpl implements UserPicService {
    @Autowired
    private UserPicDao userPicDao;

}