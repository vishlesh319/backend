package com.daoimpl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.CategoryDAO;
import com.model.Category;

@SuppressWarnings("deprecation")
@Repository
public class CategoryDAOImpl implements CategoryDAO
{public  CategoryDAOImpl(){}
@Autowired
SessionFactory sessionFactory;

public CategoryDAOImpl(SessionFactory sessionFactory) {
	
	this.sessionFactory = sessionFactory;
}





@Transactional
public boolean saveCategory(Category category) {
	
	 sessionFactory.getCurrentSession().saveOrUpdate(category);
	
	
	
	 return true;
}



@Transactional
public List<Category> list() {
	@SuppressWarnings("unchecked")
	List<Category> listCategory = (List<Category>) sessionFactory.getCurrentSession()
			.createCriteria(Category.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();

	return listCategory;
}




@Transactional
public Category getCategoryById(int category_id) {
	String hql = "from"+" Category"+" where id=" + category_id;
	@SuppressWarnings("rawtypes")
	Query query = sessionFactory.getCurrentSession().createQuery(hql);
	
	@SuppressWarnings("unchecked")
	List<Category> listCategory = (List<Category>) query.list();
	
	if (listCategory != null && !listCategory.isEmpty()) {
		return listCategory.get(0);
	}
	
	return null;
}



@Transactional
public Category removeCategoryById(int category_id) {
	Category CategoryToDelete = new Category();
	CategoryToDelete.setCid(category_id);
	sessionFactory.getCurrentSession().delete(CategoryToDelete);
	return CategoryToDelete;
}


}