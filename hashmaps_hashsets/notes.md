## HashMap
- A basic implementation of a Map which is a collection of key-value pairs
- Items are accessed using a key of specified type
- Inserting an existing key, overrides the existing value
- A null key can be stored as well, but there should be only one null key
- There is no guarantee as to the other of the items in the collection

### Operations:
- Constructors
- Adding elements (put):Internally the key is hashed 
- Changing an element : put
- Removing an element
- Traversal 
- containsValue: O(n)
- containsKey: O(1)

### Key notes
- The key must be known to access a value
- It is called HashMap because it uses a technique called Hashing (Which helps in indexing and faster searches)
- Doesn’t allow duplicate keys but allows duplicate values. 

## HashSet
A collection of type Set backed internally by a hash map
- Duplicate values are not allowed
- offers constant time performance for the basic operations like add, remove, contains, and size
- Order of items is not guaranteed 
- Null element is allowed

### Operations
- Constructor
- Adding elements: add; Duplicate elements are ignored; If an element was added, the method returns true, otherwise – false.
- Removing an element
- Iteration
- Contains
- Clear
- Size

## Use cases:
* Uniqueness 
* Performance

## Hashing
Hashing is the process of transforming any given key or a string of characters into another value. This is usually represented by a shorter, fixed-length value or key that represents and makes it easier to find or employ the original string.
The most popular use for hashing is the implementation of hash tables. A hash table stores key and value pairs in a list that is accessible through its index. Because key and value pairs are unlimited, the hash function will map the keys to the table size. A hash value then becomes the index for a specific element.

Hashing is relevant to -- but not limited to -- data indexing and retrieval, digital signatures, cybersecurity and cryptography. 

￼

