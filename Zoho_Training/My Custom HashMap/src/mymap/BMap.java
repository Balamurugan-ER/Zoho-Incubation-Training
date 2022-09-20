/**
 * 
 */
package mymap;
/**
 * @author Balamurugan
 */
public class BMap<K,V>{
	private int hashCode;
	private K key;
	private V value;
	private BMap<K,V> next;
	public BMap(K key,V value)
	{
		this.key = key;
		this.value = value;
		this.next = null;
		hashCode();
	}
	
	public int hashCode()
	{
		return this.hashCode = ((String) key).charAt(0)*(16)+25;
	}
	public K getKey() {
		return key;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public BMap<K, V> getNext() {
		return next;
	}
	public void setNext(BMap<K,V> next) {
		this.next = next;
	}
	public int getHashCode() {
		return this.hashCode;
	}	
	public String toString()
	{
		String value = getKey()+","+getValue();
		return value;
	}

}
