package com.daydream.platform.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.daydream.platform.crud.ItemCreate;
import com.daydream.platform.crud.ItemModify;
import com.daydream.platform.entity.Item;
import com.daydream.platform.mapper.ItemMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> {

    @Transactional(rollbackFor = Exception.class)
    public boolean create(ItemCreate itemCreate) {
        Item item = new Item();
        item.setUserId(itemCreate.getUserId());
        item.setName(itemCreate.getName());
        item.setPrice(itemCreate.getPrice());
        return save(item);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean deleteById(String id) {
        return removeById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean modify(ItemModify itemModify) {
        Item item = super.getById(itemModify.getId());
        BeanUtils.copyProperties(itemModify, item);
        return updateById(item);
    }

    public IPage<Item> page(int start, int size) {
        QueryWrapper<Item> queryWrapper = new QueryWrapper<>();
        BeanUtils.copyProperties(list(), queryWrapper);
        Page<Item> page = new Page<>(start, size);
        IPage<Item> iPage = page(page, queryWrapper);
        return iPage;
    }
}
