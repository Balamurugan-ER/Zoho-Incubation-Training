/**
 * 
 */
package com.bm.framework.hashmap;
import java.util.*;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class BeginnerHashMap 
{
	public void checkNull(Object obj) throws CustomException
	{
		if(obj == null)
		{
			throw new CustomException("Value should not be Null");
		}
	}
	public int getMapSize(Map m) throws CustomException
	{
		checkNull(m);
		return m.size();
	}
	public void addEntry(Map map,Object key,Object value) throws CustomException
	{
		checkNull(map);
		map.put(key, value);
	}
	public boolean checkKey(Map map,Object key,boolean value) throws CustomException
	{
		checkNull(map);
		if(value)
		{
			return map.containsValue(key);
		}
		return map.containsKey(key);
	}
	public Object getValue(Map map,Object key) throws CustomException
	{
		checkNull(map);
		return map.get(key);
	}
	public Object getValue(Map map,Object key,Object dValue) throws CustomException
	{
		checkNull(map);
		return map.getOrDefault(key,dValue);
	}
	public Object removeKey(Map map,Object key) throws CustomException
	{
		checkNull(map);
		return map.remove(key);
	}
	public Object removeEntry(Map map,Object key,Object value) throws CustomException
	{
		checkNull(map);
		return map.remove(key, value);
	}
	public Object replaceValues(Map map,Object key,Object value) throws CustomException
	{
		checkNull(map);
		return map.replace(key, value);
	}
	public Object replaceValues(Map map,Object key,Object value,Object oldValue) throws CustomException
	{
		checkNull(map);
		return map.replace(key, oldValue, value);
	}
	public void removeAll(Map map) throws CustomException
	{
		checkNull(map);
		map.clear();
	}
}
