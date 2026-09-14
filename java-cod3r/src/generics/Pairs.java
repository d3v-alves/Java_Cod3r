package generics;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

public class Pairs<C extends Number, V> {
	
	private final Set<Pair<C, V >> itens = new LinkedHashSet<>();
	
	public void add(C key, V value) {
		if(key == null) return;
		
		Pair<C, V> newPair = new Pair<C , V>(key, value);
		
		if(itens.contains(newPair)) {
			itens.remove(newPair);
		}
		
		itens.add(newPair);
		
	}	
	
	public V getValue(C key) {
		if(key == null) return null;
		
		Optional<Pair<C, V>> pairOptional = itens.stream().filter(pair -> key.equals(pair.getKey())).findFirst();
		
		return pairOptional.isPresent() ? pairOptional.get().getValue() : null;
	}
}