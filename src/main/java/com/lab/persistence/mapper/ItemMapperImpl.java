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
    public List<ItemModel> ItemMapper(ItemModel obj) throws Exception {

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
            articulo.setNombre(rs.getString("url"));
            
            x.add(articulo);
        }

    /**
     * DESCONECTANDO A LA BBDD.
     */
    db.desconecta ();

    return x ;
}
}
