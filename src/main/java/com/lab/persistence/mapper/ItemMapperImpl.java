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

        List<ItemModel> x = new ArrayList<>();

        /**
         * CONECTANDO A LA BBDD.
         */
        db.conecta();
        
        
        String sql = "SELECT * from items where (nombre like '%" + obj.getNombre() + "%')" ;

        ResultSet rs = db.consulta(sql);
        while (rs.next()) {
            ItemModel articulo = new ItemModel();
            
            articulo.setId(rs.getInt("id"));
            articulo.setNombre(rs.getString("nombre"));
            articulo.setDescripcion(rs.getString("descripcion"));
            articulo.setUrl(rs.getString("url"));
            
            System.out.println(articulo.getNombre());
            System.out.println(articulo.getDescripcion());
            
            
            x.add(articulo);
        }

    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta ();

    return x ;
}
    
    @Override
    public List<ItemModel> getItemMapper(ItemModel obj) throws Exception {

        List<ItemModel> lista = new ArrayList<>();
        
        db.conecta();
        
        
        String sql2 = "SELECT * from items" ;
        
        ResultSet rs2 = db.consulta(sql2);
        while (rs2.next()) {
            ItemModel articulo2 = new ItemModel();
            
            articulo2.setId(rs2.getInt("id"));
            articulo2.setNombre(rs2.getString("nombre"));
            articulo2.setDescripcion(rs2.getString("descripcion"));
            articulo2.setUrl(rs2.getString("url"));
            
            System.out.println(articulo2.getNombre());
            System.out.println(articulo2.getDescripcion());
            
            
            lista.add(articulo2);
            
        }
        db.desconecta ();

        return lista ;
    }
        
}
