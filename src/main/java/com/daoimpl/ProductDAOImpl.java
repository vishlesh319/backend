package com.daoimpl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dao.ProductDAO;
import com.model.Product;

@SuppressWarnings("deprecation")
@Repository
public class ProductDAOImpl implements ProductDAO
{
public  ProductDAOImpl(){}
	
	Logger log=LoggerFactory.getLogger(ProductDAOImpl.class);
	
	
	
	@Autowired
	SessionFactory sessionFactory;

	public ProductDAOImpl(SessionFactory sessionFactory) {
		
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public boolean saveProduct(Product product) {
		
		log.info("Persisting Product object started.........", product.getName());
		sessionFactory.getCurrentSession().saveOrUpdate(product);
		log.info("Product has been saved successfully....", product.getName());
		
		return true;
	}

	@SuppressWarnings({ "unchecked" })
	@Transactional
	public List<Product> list() {
		List<Product> product = sessionFactory.getCurrentSession().createCriteria(Product.class).list();
		return product;
	}

	@Transactional
	public Product getProductById(int product_id) {
		String hql = "from" + " Product" + " where id=" + product_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		@SuppressWarnings("unchecked")
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return listProduct.get(0);
		}

		return null;
	}

	@Transactional
	public Product removeProducyById(int product_id) {
		Product ProductToDelete = new Product();
		ProductToDelete.setPid(product_id);
		sessionFactory.getCurrentSession().delete(ProductToDelete);
		return ProductToDelete;
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Product> getProductByCategory(int category_id) {
		String hql = "from" + " Product" + " where id=" +category_id;
		@SuppressWarnings("rawtypes")
		Query query = sessionFactory.getCurrentSession().createQuery(hql);

		
		List<Product> listProduct = (List<Product>) query.list();

		if (listProduct != null && !listProduct.isEmpty()) {
			return (List<Product>) listProduct.get(0);
		}


		return null;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional
	public List<Product> getProductByCategoryID(int category_id) {
		
		String hql = "from Product where category_id= "+category_id;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Product> catproducts = (List<Product>) query.list();
		return catproducts;
	}

}