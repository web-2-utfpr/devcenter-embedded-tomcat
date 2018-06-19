/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import java.util.List;
import model.bean.ImageBean;
import model.service.ImagemService;
/**
 *
 * @author rafae
 */
public class Query implements GraphQLQueryResolver {
    
    public List<ImageBean> allPhotos (int page) {
        database.Database.Open();
        return ImagemService.RESTgetAllPhotos(page);
    }
}
