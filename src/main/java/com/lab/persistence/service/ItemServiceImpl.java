package com.lab.persistence.service;

import com.lab.persistence.mapper.ItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lab.persistence.model.ItemModel;
import java.util.List;


@Service
public class ItemServiceImpl implements ItemService
{

  @Autowired
  ItemMapper iMapper;


  @Override
  public List<ItemModel> itemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = iMapper.itemMapper(obj);

    return x;
  }

}
