package com.daydream.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daydream.platform.crud.UserCreate;
import com.daydream.platform.crud.UserModify;
import com.daydream.platform.entity.User;
import com.daydream.platform.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Transactional(rollbackFor = Exception.class)
    public boolean create(UserCreate userCreate) {
        User user = new User();
        user.setName(userCreate.getName());
        user.setAge(userCreate.getAge());
        return save(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean modify(UserModify userModify) {
        User user = super.getById(userModify.getId());
        BeanUtils.copyProperties(userModify, user);
        return updateById(user);
    }

//    public boolean getById(String id) {
//        return getById(id);
//    }

    public IPage<User> page(int start, int size) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        BeanUtils.copyProperties(list(), queryWrapper);
        Page<User> page = new Page<>(start,size);
        IPage<User> iPage = page(page, queryWrapper);
        return iPage;
    }
}
