package vo.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;

public class UtilCollection {

	
	public static <D extends Object> int[] getIndices(SortedSet<D> set, Collection<D> values){
		
		int[] indices = new int[values.size()];;
		int i =0;
		for ( D value : values)
		{
			indices[i] = getIndice(set, value);
			i++;
		}
			
		return indices;
	}
	
	/**
	 * 
	 * @param set SortedSet à rechercher.
	 * @param value Valeur à rechercher.
	 * @return indice de la valeur dans le SortedSet
	 */
	public static <D extends Object> int getIndice(SortedSet<D> set, D value){
		
		List<D> listValue = new ArrayList<D>();
		listValue.addAll(set);
		return listValue.indexOf(value);

	}
	
	
	
}
