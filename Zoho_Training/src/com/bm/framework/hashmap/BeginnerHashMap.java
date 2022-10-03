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
	// returns the map size
	public int getMapSize(Map m) throws CustomException
	{
		Utilities.VALID.isNull(m);
		return m.size();
	}
	// add an key and value pair
	public void addEntry(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		map.put(key, value);
	}
	// returns boolean that given key is found or not.
	public boolean checkKey(Map map,Object key,boolean value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		if(value)
		{
			return map.containsValue(key);
		}
		return map.containsKey(key);
	}
	// returns object that matches the given key.
	public Object getValue(Map map,Object key) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.get(key);
	}
	// returns object that matches the given key or return the default value.
	public Object getValue(Map map,Object key,Object dValue) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.getOrDefault(key,dValue);
	}
	// removes the key and value and returns the previous value.
	public Object removeKey(Map map,Object key) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.remove(key);
	}
	// removes the key with matched value.
	public Object removeEntry(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.remove(key, value);
	}
	// replace key with given value
	public Object replaceValues(Map map,Object key,Object value) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.replace(key, value);
	}
	// replace given value if the key and value found.
	public Object replaceValues(Map map,Object key,Object value,Object oldValue) throws CustomException
	{
		Utilities.VALID.isNull(map);
		return map.replace(key, oldValue, value);
	}
	// clears all the map entries.
	public void removeAll(Map map) throws CustomException
	{
		Utilities.VALID.isNull(map);
		map.clear();
	}
}
