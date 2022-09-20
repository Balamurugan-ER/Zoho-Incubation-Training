/**
 * 
 */
package framework;
import java.util.*;
/**
 * @author Balamurugan
 *
 */
public class BArrayList {
	
	public void checkNull(Object obj) throws MyException
	{
		if(Objects.isNull(obj))
		{
			throw new MyException("Value should not be Null");
		}
	}
	public boolean isValidRange(int length,int fromIndex,int toIndex) throws MyException
	{
		if(fromIndex > toIndex)
		{
			throw new MyException("From Index Should be Lesser than To Index");
		}
		if(fromIndex > length || toIndex > length)
		{
			throw new MyException("Index Should not be Greater than size of list");
		}
		return true;
	}
	public int getSize(List<?> list) throws MyException
	{
		checkNull(list);
		return list.size();
	}
	//TODO: bug
	public boolean setValue(List list,Object obj) throws MyException
	{
		checkNull(list);
		return list.add(obj);
	}
	public void setValue(List list,Object obj,int index) throws MyException
	{
		if(index > getSize(list))
		{
			throw new MyException("Index should not be Greater than Size of List");
		}
		list.add(index,obj);
	}
	public int indexOfObj(List<?> list,Object obj,boolean first) throws MyException
	{
		checkNull(list);
		if(first)
		{
			return list.indexOf(obj);
		}
		return list.lastIndexOf(obj);
	}
	public Object getValue(List<?> list,int index) throws MyException
	{
		checkNull(list);
		return list.get(index);
	}
	public List<?> createSubList(List<?> list,int fromIndex,int toIndex) throws MyException
	{
		isValidRange(getSize(list),fromIndex,toIndex);
		return list.subList(fromIndex, toIndex);
	}
	public void removeElement(List<?> list,Object obj) throws MyException
	{
		checkNull(list);
		list.remove(obj);
	}
	public void removeElements(ArrayList<?> list,int start,int end) throws MyException
	{
		isValidRange(getSize(list),start,end);
		list.subList(start, end).clear();
	}
	public boolean isPresent(List<?> list,Object obj) throws MyException
	{
		checkNull(list);
		return list.contains(obj);
	}
	public void removeIfPresent(List<?> list,List<?> subList,boolean present) throws MyException
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
	public void removeAll(List<?> list) throws MyException
	{
		checkNull(list);
		list.clear();
	}
}
