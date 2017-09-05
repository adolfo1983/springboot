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

  public static boolean isNumeric(String str) {
        return (str.matches("[+-]?\\d*(\\.\\d+)?") && str.equals("")==false);
    }

  @Override
  public List<ItemModel> itemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = null;
    if (isNumeric(obj.getNombre()))
            {
                x = iMapper.PesoItemMapper(obj);
            } else 
                {
                    x = iMapper.itemMapper(obj);
                }
    
    

    return x;
  }
  
  @Override
  public List<ItemModel> getItemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = iMapper.getItemMapper(obj);

    return x;
  }

}
