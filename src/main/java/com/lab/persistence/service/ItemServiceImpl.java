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
    List<ItemModel> lista = this.replace(obj,x);
    return lista;
  }
  
  @Override
  public List<ItemModel> pesoItemService(ItemModel obj) throws Exception
  {
    
    List<ItemModel> x = iMapper.pesoItemMapper(obj);
    
      List<ItemModel> lista = this.replace(obj,x);
    return lista;
  }
  
  @Override
  public List<ItemModel> getItemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = iMapper.getItemMapper(obj);

    return x;
  }

    private List<ItemModel> replace(ItemModel obj, List<ItemModel> x) {
        for (int i = 0; i < x.size(); i++) {
           x.get(i).setNombre( x.get(i).getNombre().replace(obj.getNombre(), "<span class=\"resalto\" >" + obj.getNombre() + "</span>"));
           x.get(i).setDescripcion(x.get(i).getDescripcion().replace(obj.getNombre(), "<span class=\"resalto\" >" + obj.getNombre() + "</span>"));
            
        }
        
        return x;
    }

}
