# Collections API Lab Discussion

### Charles Turpin (cht16), Russell Barton (rnb23), Woonggyu Jin (wj61), Aloye Oshotse (ajo24)

### Team 3

## In your experience using these collections, are they hard or easy to use?

* Always found them easy and convenient but only for case specific applications

## In your experience using these collections, do you feel mistakes are easy to avoid?

* In my experience, it is easy to avoid mistakes. If you understand logically what each method does,
  it should be relatively easy. Also, there are documentations that explain what every Collections
  method does.

## What methods are common to all collections (except Maps)?

* Add, addAll, clear, contains, containsAll, equals, hashCode, isEmpty, iterator, parallelStream,
  remove, removeAll, removeIf, retainAll, size, spliterator, stream, toArray

## What methods are common to all Deques?

* popFront, popBack, begin, end, pushFront, pushBack, size

## What is the purpose of each interface implemented by LinkedList?

* The list interface is obviously needed to implement the linked list as a List
* The Deque interface is used to allow for adding and removing elements at both ends
* The Queue interface is implemented to allow for FIFO adding and subtracting
* The Clonable interface is used to allow for cloning
* The serializable interface is used to allow serialization of its objects

## How many different implementations are there for a Set?

* AbstractSet, ConcurrentHashMap.KeySetView, ConcurrentSkipListSet, CopyOnWriteArraySet, EnumSet,
  HashSet, JobStateReasons, LinkedHashSet, TreeSet

## What is the purpose of each superclass of PriorityQueue?

* AbstractQueue- access elements, remove them, and add them
* Iterator- iterate over each member of the queue given an iterator, throws exceptions
* Collection- check if members are present, equality, remove all members, allows the use of streams
  with queue
* Object- multithreading capability, create copies of object, get class info of object
* AbstractCollection- similar to collection, also has toString functionality, does not have stream
  functionality

## What is the purpose of the Collections utility class?

* The purpose of this class is to provide a set of methods for performing common operations on
  collections, such as sorting, searching, shuffling, and manipulating collections.

## API Characterics applied to Collections API

* Easy to learn
    * This might not be as true because there are so many methods and implementations of the
      Collections class, so it might be hard to learn all of it from the beginning.


* Encourages extension
    * May be true because users are able to choose exactly what type of collection they want to
      implement the features of.

* Leads to readable code
    * It absolutely leads to more readable code. This is because it allows you to say something in
      one line rather than writing a method. That line is also generalized and predictable

* Hard to misuse
    * Every polymorphism of the Collections class can use any methods from the parent class. This
      includes the methods that are against what the subclass was supposed to be used for. For
      example, the Stack class has access to all the methods, even though the design specified
      certain methods that should be unique to Stacks.


 
 