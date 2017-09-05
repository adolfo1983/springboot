package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ItemMapperImpl implements ItemMapper {

    @Autowired
    BBDD db;

    @Override
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception {

        return this.addItemModel("SELECT * "
                                 + "FROM items "
                                 + "where (nombre like '%" + obj.getNombre() + "%')"
                                 + "OR (descripcion like '%" + obj.getNombre() + "%')");
}
    
    @Override
    public List<ItemModel> PesoItemMapper(ItemModel obj) throws Exception {

        return this.addItemModel("SELECT * "
                                 + "FROM items "
                                 + "JOIN pesoitems"
                                 + "ON items.id = pesoitems.iditem"
                                 + "where peso = " + obj.getNombre());
                                 
}
    
    @Override
    public List<ItemModel> getItemMapper(ItemModel obj) throws Exception {

        return this.addItemModel("SELECT * from items");
    }
     
    
    private List<ItemModel> addItemModel(String sql) throws Exception
  {
    List<ItemModel> listaItems = new ArrayList<>();

    db.conecta();

    ResultSet rs = db.consulta(sql);
    while (rs.next())
    {
      ItemModel item = new ItemModel();

      item.setId(rs.getInt("id"));
      item.setNombre(rs.getString("nombre"));
      item.setDescripcion(rs.getString("descripcion"));
      item.setUrl(rs.getString("url"));

      listaItems.add(item);
    }

    db.desconecta();

    return listaItems;
  }

}
