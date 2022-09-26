package com.bm.framework.arraylist;
import java.util.*;
import com.bm.util.*;
/**
 * @author Balamurugan
 *
 */
public class BArrayList {
	
	//returns Size of the Given list
	public int getSize(List<?> list) throws CustomException
	{
		Utilities.VALID.isNull(list);
		return list.size();
	}
	//add object in the given list
	public boolean setValue(List list,Object obj) throws CustomException
	{
		Utilities.VALID.isNull(list);
		return list.add(obj);
	}
	//add Object at the given index
	public void setValue(List list,Object obj,int index) throws CustomException
	{
		if(index > getSize(list))
		{
			throw new CustomException("Index should not be Greater than Size of List");
		}
		list.add(index,obj);
	}
	//returns index of given object true-firstOccurance,false-lastOccurance
	public int indexOfObj(List<?> list,Object obj,boolean first) throws CustomException
	{
		Utilities.VALID.isNull(list);
		if(first)
		{
			return list.indexOf(obj);
		}
		return list.lastIndexOf(obj);
	}
	//returns value at the given index
	public Object getValue(List<?> list,int index) throws CustomException
	{
		Utilities.VALID.isNull(list);
		return list.get(index);
	}
	//returns sublist by taking start,end index.
	public List<?> createSubList(List<?> list,int fromIndex,int toIndex) throws CustomException
	{
		Utilities.VALID.isNumValidRange(getSize(list),fromIndex,toIndex);
		return list.subList(fromIndex, toIndex);
	}
	//removes the given object.
	public void removeElement(List<?> list,Object obj) throws CustomException
	{
		Utilities.VALID.isNull(list);
		list.remove(obj);
	}
	//removes range of elements by creating sublist and clear methods.
	public void removeElements(ArrayList<?> list,int start,int end) throws CustomException
	{
		Utilities.VALID.isNumValidRange(getSize(list),start,end);
		list.subList(start, end).clear();
	}
	//return boolean if the object is present or not
	public boolean isPresent(List<?> list,Object obj) throws CustomException
	{
		Utilities.VALID.isNull(list);
		return list.contains(obj);
	}
	//removes elements in the Sublist and not in sublist by boolean 
	public void removeIfPresent(List<?> list,List<?> subList,boolean present) throws CustomException
	{
		Utilities.VALID.isNull(list);
		if(present)
		{
			list.removeIf(f->(subList.contains(f)));
		}
		else 
		{
			list.removeIf(f->(!subList.contains(f)));
		}
	}
	//removes all the elements in list
	public void removeAll(List<?> list) throws CustomException
	{
		Utilities.VALID.isNull(list);
		list.clear();
	}
}
