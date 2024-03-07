package e1.utils;

import java.util.Iterator;

public interface InitialPositions extends Iterator<Pair<Integer, Integer>> {
    
    /**
     * @return whether there is one more empty position available.
     */
    boolean hasNext();

    /**
     * @return the next available position.
     */
    Pair<Integer, Integer> next();
}
