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
	public int getMapSize(Map m) throws CustomException
	{
		Utilities.VALID.isNull(m);
		return m.size();
	}
	public void addEntry(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		map.put(key, value);
	}
	public boolean checkKey(Map map,Object key,boolean value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		if(value)
		{
			return map.containsValue(key);
		}
		return map.containsKey(key);
	}
	public Object getValue(Map map,Object key) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.get(key);
	}
	public Object getValue(Map map,Object key,Object dValue) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.getOrDefault(key,dValue);
	}
	public Object removeKey(Map map,Object key) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.remove(key);
	}
	public Object removeEntry(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.remove(key, value);
	}
	public Object replaceValues(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.replace(key, value);
	}
	public Object replaceValues(Map map,Object key,Object value,Object oldValue) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.replace(key, oldValue, value);
	}
	public void removeAll(Map map) throws CustomException
	{
		Utilities.VALID.isNull(map);
		map.clear();
	}
}
