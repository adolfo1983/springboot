package com.lab.persistence.service;

import com.lab.persistence.model.ItemModel;
import java.util.List;


public interface ItemService
{
  public List<ItemModel> itemService(ItemModel obj) throws Exception;
  
   public List<ItemModel> getItemService(ItemModel obj) throws Exception;
}