Java 9 History
--------------
https://www.oracle.com/technetwork/java/javase/downloads/index.html
https://stackoverflow.com/questions/50332634/why-oracle-jdk-9-download-ends-so-early
https://www.infoworld.com/article/3284164/oracle-now-requires-a-subscription-to-use-java-se.html
https://stackoverflow.com/questions/22358071/differences-between-oracle-jdk-and-openjdk

Advances/Improvements
----------------------
New Version-String
https://www.javatpoint.com/java-9-new-version-string-scheme

Interface Private Methods
https://www.deadcoderising.com/java-9-cleaning-up-your-default-methods-using-private-interface-methods/

Try-With Resources
https://dzone.com/articles/try-with-resources-enhancement-in-java-9

Diamond Operator for Anonymous Inner Class
//Eclipse

@SafeVarargs Annotation
//Eclipse
https://www.baeldung.com/java-safevarargs
https://beginnersbook.com/2018/05/java-9-safevarargs-annotation/

Factory Methods for Immutable List, Set, Map and Map.Entry
https://docs.oracle.com/javase/9/core/creating-immutable-lists-sets-and-maps.htm#JSCOR-GUID-DD066F67-9C9B-444E-A3CB-820503735951
https://www.journaldev.com/12942/javase9-factory-methods-immutable-list
https://www.journaldev.com/13057/javase9-factory-methods-immutable-map

Limiting Stream with takeWhile() and dropWhile() methods
takeWhile/dropWhile
https://blog.indrek.io/articles/whats-new-in-java-9-streams/



Stream API Improvement
-- Are we using multi core machine
-- java.util.concurrent + ThreadpoolExecutors
-- External Vs Internal iteration : Word Doc
   Remove boilerplate code
   It’s also hard to write a parallel version of this for loop
   doesn’t fluently convey the intent of the programmer

```
   public Set<String> findLongTracks(List<Album> albums) {
         Set<String> trackNames = new HashSet<>();
         for(Album album : albums) {
               for (Track track : album.getTrackList()) {
                          if (track.getLength() > 60) {
                               String name = track.getName();
                               trackNames.add(name);
                           }
               }
         }
         return trackNames;
   }



   public Set<String> findLongTracks(List<Album> albums) {
   return albums.parallelStream()
                    .flatMap(Object :: methodName)
                    .filter(track -> track.getLength() > 60)
                    .map(track -> track.getName())
                    .collect(toSet());
   }
```   

-- Needs executable functions
-- Object Oriented Vs Functional programming
   Function can exist on its own and it is first class, it can assignable to variable
   Object Oriented gives importance to state/properties, need to instantiate object to use.


FunctionInterface func = function (){

}

-- Lambda Expression : a method without name
    button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent event) {
                    System.out.println("button clicked");
                }
        }
    );

    TO
    button.addActionListener(event -> System.out.println("button clicked"));


    Implicit return:
    BinaryOperator<Long> addExplicit = (Long x, Long y) -> x + y;


var l = String();



-- Lambda Expression is not anonymous inner class :: BloatedClass: InvokeDynamic:Function pointers
-- Functional Interface :: Why it is needed
    -- Needed for type checking
    -- Statically typing Vs Dynamic Typing
    -- Why it has only one method
       -- Type Inference -> target type | return type | type of arguments
       Method reference can't be used for any method. They can only be used to replace a single-method lambda expression.

       public  int number = 10;
       Consumer<String> c = s -> {System.out.println(number); number = 12};
       c.accept("Hello World");



       InvokeDynamic :: Pointer to reference a method
    -- closures with effectively final
    -- Should have single responsibility

    Class A {
       public int number = 10;
       public void method() {

       }
    }

    -- Stream :: is lazy or eager? (limit | findFirst)
     for(Sex s : List<Sex>) {

     }

-- Lambda expression should be cute
-- Method Reference


        Callee Impl with functional interface api call
        Caller call
             1)
             Consumer<String> c = s -> System.out.println(s);
             c.accept("Hello World");

             Consumer<String> c = System.out::println;

             2)
             Needs BiFunction at called Impl to accept two args
             (obj, arg1) -> obj.instanceMethod(arg1)

             3) Context reference
              Obj obj = new Obj();
              (arg1) -> obj.instanceMethod(arg1) //obj referenced within lambda


            4) Supplier<List<String>> s = ArrayList::new;
              List<String> l = s.get();


   https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
   
-- Exception handling
    https://dzone.com/articles/how-to-handle-checked-exception-in-lambda-expressi
-- Data parallelism Vs Task parallelism (Same operation over collection)

-- Will parallel stream creates thread pool every time?
    https://dzone.com/articles/common-fork-join-pool-and-streams
    
ForkJoinPool commonpool
-- parallel stream is thread safe? interference -> ConcurrentModificationException.
https://stackoverflow.com/questions/39093178/java-8-parallelstream-fill-arraylist
https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html#interference

-- The five main factors influencing performance are the data size, the source data structure, whether the values are packed, the number of available cores, and how much processing time is spent on each element.

-- Is it parallel stream thread safe?
https://www.techiedelight.com/remove-elements-list-satisfies-predicate-java/

-- Beware of non-deterministic stateful lambda
https://www.codesd.com/item/what-is-the-difference-between-a-stateful-and-stateless-lambda-expression.html
https://docs.oracle.com/javase/tutorial/collections/streams/parallelism.html#stateful_lambda_expressions

-- Benefits of Lambda

      1)
      Logger logger = new Logger();
      if (logger.isDebugEnabled()) {
          logger.debug("Look at this: " + expensiveOperation());
      }

      Logger logger = new Logger();
      logger.debug(() -> "Look at this: " + expensiveOperation());

      public void debug(Supplier<String> message) {
              if (isDebugEnabled()) {
                  debug(message.get());
              }
      }


ifPresentOrElse({->}, {->})

Optional Class Improvements
https://www.baeldung.com/java-optional
https://www.mkyong.com/java8/java-8-optional-in-depth/
.orElse();
ifPresentOrElse()
isPresent
https://www.youtube.com/watch?v=Yacu1yUktjY&t=5092s  -> 38:00


CompletableFuture
https://www.callicoder.com/java-8-completablefuture-tutorial/


Java 9 - Additions
-------------------
https://www.pluralsight.com/blog/software-development/java-9-new-features
Platform Module System (Project Jigsaw)
jlink: The Java Linker
Multi-Resolution Image API
JShell: The Java Shell (REPL)
Process API Improvement
A New HTTP2 Client
Java 9 Control Panel
Remove the Jhat Tool
Validate JVM Command-Line Flag Arguments
Reactive Streams







