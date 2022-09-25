package com.bm.framework.arraylist;
import java.util.*;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class BArrayList {
	
	public void checkNull(Object obj) throws CustomException
	{
		if(Objects.isNull(obj))
		{
			throw new CustomException("Value should not be Null");
		}
	}
	public boolean isValidRange(int length,int fromIndex,int toIndex) throws CustomException
	{
		if(fromIndex > toIndex)
		{
			throw new CustomException("From Index Should be Lesser than To Index");
		}
		if(fromIndex > length || toIndex > length)
		{
			throw new CustomException("Index Should not be Greater than size of list");
		}
		return true;
	}
	public int getSize(List<?> list) throws CustomException
	{
		checkNull(list);
		return list.size();
	}
	//TODO: bug
	public boolean setValue(List list,Object obj) throws CustomException
	{
		checkNull(list);
		return list.add(obj);
	}
	public void setValue(List list,Object obj,int index) throws CustomException
	{
		if(index > getSize(list))
		{
			throw new CustomException("Index should not be Greater than Size of List");
		}
		list.add(index,obj);
	}
	public int indexOfObj(List<?> list,Object obj,boolean first) throws CustomException
	{
		checkNull(list);
		if(first)
		{
			return list.indexOf(obj);
		}
		return list.lastIndexOf(obj);
	}
	public Object getValue(List<?> list,int index) throws CustomException
	{
		checkNull(list);
		return list.get(index);
	}
	public List<?> createSubList(List<?> list,int fromIndex,int toIndex) throws CustomException
	{
		isValidRange(getSize(list),fromIndex,toIndex);
		return list.subList(fromIndex, toIndex);
	}
	public void removeElement(List<?> list,Object obj) throws CustomException
	{
		checkNull(list);
		list.remove(obj);
	}
	public void removeElements(ArrayList<?> list,int start,int end) throws CustomException
	{
		isValidRange(getSize(list),start,end);
		list.subList(start, end).clear();
	}
	public boolean isPresent(List<?> list,Object obj) throws CustomException
	{
		checkNull(list);
		return list.contains(obj);
	}
	public void removeIfPresent(List<?> list,List<?> subList,boolean present) throws CustomException
	{
		checkNull(list);
		if(present)
		{
			list.removeIf(f->(subList.contains(f)));
		}
		else 
		{
			list.removeIf(f->(!subList.contains(f)));
		}
	}
	public void removeAll(List<?> list) throws CustomException
	{
		checkNull(list);
		list.clear();
	}
}
