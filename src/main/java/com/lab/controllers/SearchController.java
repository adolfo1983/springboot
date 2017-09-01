package com.lab.controllers;


import com.lab.persistence.model.ItemModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.lab.persistence.service.ItemService;
import java.util.List;


@Controller
public class SearchController
{

  @Autowired
  ItemService iService;


  @ResponseBody
  @RequestMapping(value = "/searchItem",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemModel> test(@RequestBody ItemModel obj) throws Exception
  {   
    List<ItemModel> x = iService.itemService(obj);
    

    return x;
  }

  @ResponseBody
  @RequestMapping(value = "/getItem",
                  method = RequestMethod.POST,
                  produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ItemModel> get(@RequestBody ItemModel obj) throws Exception
  {   
    List<ItemModel> x = iService.getItemService(obj);
    

    return x;
  }
}
