
public class ST<Key, Value>{

        ST() {}  // create a symbol table
        void put(Key key, Value val){} // put key-value pair into the table (remove key from table if value is null)
        Value get(Key key){return null;}  // value paired with key (null if key is absent)
        void delete(Key key){} // remove key (and its value) from table
        boolean contains(Key key){return false;} // is there a value paired with key?
        boolean isEmpty(){return false;} // is the table empty?
        int size(){return 0;} // number of key-value pairs in the table
        Iterable<Key> keys(){ return null;} // all the keys in the table
}
