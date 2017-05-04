
package com.zjw.blog.base;

import java.io.Serializable;

/**
 * @author belldog
 * 
 * @CreateDate 2015-7-24 上午10:03:00
 */
public interface BaseRepository<E extends Serializable, PK extends Serializable> {

	E get(PK id);

	void update(E entity);

	void save(E entity);

	void delete(E entity);
	
	void deleteById(PK id);

}
