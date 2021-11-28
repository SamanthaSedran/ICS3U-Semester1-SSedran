package Week10;

/******************************************************************************
 * A DoubleArraySequence is a collection of double numbers. The sequence can
 * have a special "current element," which is specified and accessed through
 * four methods that are not available in the sequence class (start, getCurrent,
 * advance and isCurrent).
 *
 * @note (1) The capacity of one a sequence can change after it's created, but
 *       the maximum capacity is limited by the amount of free memory on the
 *       machine. The constructor, addAfter, addBefore, clone, and concatenation
 *       will result in an OutOfMemoryError when free memory is exhausted.
 *       <p>
 *       (2) A sequence's capacity cannot exceed the maximum integer
 *       2,147,483,647 (Integer.MAX_VALUE). Any attempt to create a larger
 *       capacity results in a failure due to an arithmetic overflow.
 *
 * @note This file contains only blank implementations ("stubs") because this is
 *       a Programming Project for my students.
 *
 *
 ******************************************************************************/
public class DoubleArraySequence {
   private static final int DEFAULT_CAPACITY = 10;
   // Invariant of the DoubleArraySequence class:
   // 1. The number of elements in the sequences is in the instance variable
   // manyItems.
   // 2. For an empty sequence (with no elements), we do not care what is
   // stored in any of data; for a non-empty sequence, the elements of the
   // sequence are stored in data[0] through data[manyItems-1], and we
   // don't care what's in the rest of data.
   // Sequence, part of an array that you are using
   // 3. If there is a current element, then it lies in data[currentIndex];
   // if there is no current element, then currentIndex equals manyItems.
   private double[] data;
   private int manyItems;
   private int currentIndex;

   /**
    * Initialize an empty sequence with an initial capacity of 10. Note that the
    * addAfter and addBefore methods work efficiently (without needing more memory)
    * until this capacity is reached.
    * 
    * @param - none
    * @postcondition This sequence is empty and has an initial capacity of 10.
    * @exception OutOfMemoryError Indicates insufficient memory for: new
    *                             double[10].
    **/
   // Created DoubleArraySequence
   /*public static void main(String[] args) {
      int score = 0;
      DoubleArraySequence d1 = new DoubleArraySequence();
      DoubleArraySequence d2 = new DoubleArraySequence(5);
      DoubleArraySequence d3 = new DoubleArraySequence(d2);

      if (d1.size() == 0)
         score++;

      

      d2.addAfter(1.0);
      
      d2.addAfter(2.0);
      d2.addAfter(3.0);
      d2.addAfter(4.0);
   }*/
   public DoubleArraySequence() {
      manyItems = 0;
      currentIndex = 0;
      data = new double[DEFAULT_CAPACITY];
   }

   /**
    * Initialize an empty sequence with a specified initial capacity. Note that the
    * addAfter and addBefore methods work efficiently (without needing more memory)
    * until this capacity is reached.
    * 
    * @param initialCapacity the initial capacity of this sequence
    * @precondition initialCapacity is non-negative.
    * @postcondition This sequence is empty and has the given initial capacity.
    * @exception IllegalArgumentException Indicates that initialCapacity is
    *                                     negative.
    * @exception OutOfMemoryError         Indicates insufficient memory for: new
    *                                     double[initialCapacity].
    **/
   // Get empty sequence with a specified Capacity
   public DoubleArraySequence(int initialCapacity) {
      if (initialCapacity < 0)
         throw new IllegalArgumentException("Initial Capacity must be non-negative.");

      manyItems = 0;
      currentIndex = 0;
      data = new double[initialCapacity];
   }

   /**
    * Initialize a sequence as a copy of an existing sequence.
    * 
    * @param src an existing sequence
    * @precondition src is not null.
    * @postcondition This sequence is a copy of the sequence src.
    **/
   // The new double array sequence is a copy of the DoubleArraySequence src.
   public DoubleArraySequence(DoubleArraySequence src) {
      this.manyItems = src.manyItems;
      this.currentIndex = src.currentIndex;
      data = new double[src.getCapacity()];
      for(int i=0; i<src.getCapacity(); i++){
         data[i] = src.data[i];
      }

      // copy src.data into this.data
   }

   /**
    * Add a new element to this sequence, after the current element. If the new
    * element would take this sequence beyond its current capacity, then the
    * capacity is increased before adding the new element.
    * 
    * @param d the new element that is being added
    * @postcondition A new copy of the element has been added to this sequence. If
    *                there was a current element, then the new element is placed
    *                after the current element. If there was no current element,
    *                then the new element is placed at the end of the sequence. In
    *                all cases, the new element becomes the new current element of
    *                this sequence.
    * @exception OutOfMemoryError Indicates insufficient memory for increasing the
    *                             sequence's capacity.
    * @note An attempt to increase the capacity beyond Integer.MAX_VALUE will cause
    *       the sequence to fail with an arithmetic overflow.
    **/
   public void addAfter(double d){
      if(this.isCurrent()&&this.manyItems<this.data.length){
         for(int i = manyItems; i>currentIndex; i--){
            this.data[i]=this.data[i-1];
         }
         this.data[currentIndex+1]=d;
         
         this.manyItems++;
         this.currentIndex++;
      }else if(this.isCurrent()&&this.manyItems>=this.data.length){
         DoubleArraySequence arr = new DoubleArraySequence(this.manyItems*2);
         for(int i = this.manyItems; i>this.currentIndex; i--){
            arr.data[i]=this.data[i-1];
         }
         arr.data[this.currentIndex+1]=d;
         for(int i = this.currentIndex; i>=0; i--){
            arr.data[i]=this.data[i];
         }
         this.currentIndex++;
         this.manyItems++;
         this.data = arr.data;
      }else if(!this.isCurrent()&&this.manyItems<this.data.length){
         this.data[this.manyItems] = d;
         this.currentIndex = this.manyItems;
         this.manyItems++;
      }else if(!this.isCurrent()&&this.manyItems>=this.data.length){
         DoubleArraySequence arr = new DoubleArraySequence(this.manyItems*2);
         for(int i=0; i<this.manyItems; i++){
            arr.data[i] = this.data[i];
         }
         arr.data[this.manyItems] = d;
         this.currentIndex = this.manyItems;
         this.data = arr.data;
      }

   }

   /**
    * Add a new element to this sequence, before the current element. If the new
    * element would take this sequence beyond its current capacity, then the
    * capacity is increased before adding the new element.
    * 
    * @param element the new element that is being added
    * @postcondition A new copy of the element has been added to this sequence. If
    *                there was a current element, then the new element is placed
    *                before the current element. If there was no current element,
    *                then the new element is placed at the start of the sequence.
    *                In all cases, the new element becomes the new current element
    *                of this sequence.
    * @exception OutOfMemoryError Indicates insufficient memory for increasing the
    *                             sequence's capacity.
    * @note An attempt to increase the capacity beyond Integer.MAX_VALUE will cause
    *       the sequence to fail with an arithmetic overflow.
    **/
   public void addBefore(double element) {
      if(this.isCurrent()&&this.manyItems<this.data.length){
         for(int i = this.manyItems; i>this.currentIndex; i--){
            this.data[i]=this.data[i-1];
         }
         this.data[currentIndex]=element;
         this.manyItems++;
      }else if(this.isCurrent()&&this.manyItems>=this.data.length){
         DoubleArraySequence arr = new DoubleArraySequence(this.manyItems*2);
         for(int i = this.manyItems; i>this.currentIndex; i--){
            arr.data[i]=this.data[i-1];
         }
         arr.data[currentIndex]=element;
         if(this.currentIndex>0){
            for(int i = this.currentIndex-1; i>=0; i--){
               arr.data[i]=this.data[i];
            }
         }
         this.manyItems++;
         this.data = arr.data;
      }else if(!this.isCurrent()&&this.manyItems<this.data.length){
         for(int i = this.manyItems; i>0; i--){
            this.data[i]=this.data[i-1];
         }
         this.data[0]=element;
         this.currentIndex=0;
         this.manyItems++;
      }else if(!this.isCurrent()&&this.manyItems>=this.data.length){
         DoubleArraySequence arr = new DoubleArraySequence(this.manyItems*2);
         for(int i = this.manyItems; i>0; i--){
            arr.data[i]=this.data[i-1];
         }
         this.manyItems++;
         this.data[0]=element;
         this.data = arr.data;
      }
   }

   /**
    * Place the contents of another sequence at the end of this sequence.
    * 
    * @param addend a sequence whose contents will be placed at the end of this
    *               sequence
    * @precondition The parameter, addend, is not null.
    * @postcondition The elements from addend have been placed at the end of this
    *                sequence. The current element of this sequence remains where
    *                it was, and the addend is also unchanged.
    * @exception NullPointerException Indicates that addend is null.
    * @exception OutOfMemoryError     Indicates insufficient memory to increase the
    *                                 size of this sequence.
    * @note An attempt to increase the capacity beyond Integer.MAX_VALUE will cause
    *       an arithmetic overflow that will cause the sequence to fail.
    **/
   public void addAll(DoubleArraySequence addend) {
      if(addend==null){
         throw new NullPointerException("addend cannot be null.");
      }else{
         if(this.getCapacity()>this.manyItems+addend.manyItems){
            DoubleArraySequence arr = new DoubleArraySequence(this.getCapacity());
            for(int i=0; i<this.manyItems; i++){
               arr.data[i] = this.data[i];
            }
            for(int i=this.manyItems; i<addend.manyItems+this.manyItems; i++){
               arr.data[i] = addend.data[i-this.manyItems];
            }
            this.manyItems+=addend.manyItems;
            this.data = arr.data;
         }else{
            DoubleArraySequence arr = new DoubleArraySequence(this.manyItems+addend.manyItems);
            for(int i=0; i<this.manyItems; i++){
               arr.data[i] = this.data[i];
            }
            for(int i=this.manyItems; i<addend.manyItems+this.manyItems; i++){
               arr.data[i] = addend.data[i-this.manyItems];
            }
            this.manyItems+=addend.manyItems;
            this.data = arr.data;
         }
      }
      
      /*else{
         DoubleArraySequence arr = new DoubleArraySequence(this.manyItems+addend.manyItems);
         for(int i=0; i<this.manyItems; i++){
            arr.data[i] = this.data[i];
         }
         for(int j=0; j<addend.manyItems; j++){
            arr.data[j+this.manyItems] = addend.data[j];
         }
         this.data = arr.data;
      }  */
   }

   /**
    * Move forward, so that the current element is now the next element in this
    * sequence.
    * 
    * @param - none
    * @precondition isCurrent() returns true.
    * @postcondition If the current element was already the end element of this
    *                sequence (with nothing after it), then there is no longer any
    *                current element. Otherwise, the new element is the element
    *                immediately after the original current element.
    * @exception IllegalStateException Indicates that there is no current element,
    *                                  so advance may not be called.
    **/
   public void advance() {
      if (!isCurrent())
         throw new IllegalStateException("No Current Element!");

      currentIndex++;
   }

   /**
    * Create a new sequence that contains all the elements from one sequence
    * followed by another.
    * 
    * @param s1 the first of two sequences
    * @param s2 the second of two sequences
    * @precondition Neither s1 nor s2 is null.
    * @return a new sequence that has the elements of s1 followed by the elements
    *         of s2 (with no current element)
    * @exception NullPointerException. Indicates that one of the arguments is null.
    * @exception OutOfMemoryError      Indicates insufficient memory for the new
    *                                  sequence.
    * @note An attempt to create a sequence with a capacity beyond
    *       Integer.MAX_VALUE will cause an arithmetic overflow that will cause the
    *       sequence to fail.
    **/
   public static DoubleArraySequence catenation(DoubleArraySequence s1, DoubleArraySequence s2) {
      if(s1==null||s2==null){
         throw new NullPointerException("s1 and s2 cannot be null.");
      }else{
         DoubleArraySequence arr = new DoubleArraySequence(s1);
         arr.addAll(s2);
         arr.trimToSize();
         arr.currentIndex = arr.manyItems;
         return arr;
      }

   }

   /**
    * Change the current capacity of this sequence.
    * 
    * @param minimumCapacity the new capacity for this sequence
    * @postcondition This sequence's capacity has been changed to at least
    *                minimumCapacity. If the capacity was already at or greater
    *                than minimumCapacity, then the capacity is left unchanged.
    * @exception OutOfMemoryError Indicates insufficient memory for: new
    *                             int[minimumCapacity].
    **/
   public void ensureCapacity(int minimumCapacity) {
      if(this.getCapacity()<minimumCapacity){
         DoubleArraySequence arr = new DoubleArraySequence(minimumCapacity);
         for(int i=0; i<this.manyItems; i++){
            arr.data[i]=this.data[i];
         }
         this.data = arr.data;
      }

   }

   /**
    * Accessor method to get the current capacity of this sequence. The add method
    * works efficiently (without needing more memory) until this capacity is
    * reached.
    * 
    * @param - none
    * @return the current capacity of this sequence
    **/
   public int getCapacity() {
      return data.length;
   }

   /**
    * Accessor method to get the current element of this sequence.
    * 
    * @param - none
    * @precondition isCurrent() returns true.
    * @return the current element of this sequence
    * @exception IllegalStateException Indicates that there is no current element,
    *                                  so getCurrent may not be called.
    **/
   public double getCurrent() {
      if (!isCurrent())
         throw new IllegalStateException("No Current Element");
      return data[currentIndex];
   }

   /**
    * Accessor method to determine whether this sequence has a specified current
    * element that can be retrieved with the getCurrent method.
    * 
    * @param - none
    * @return true (there is a current element) or false (there is no current
    *         element at the moment)
    **/
   public boolean isCurrent() { // see if sequence has a specified current element

      return currentIndex != manyItems;
   }

   /**
    * Remove the current element from this sequence.
    * 
    * @param - none
    * @precondition isCurrent() returns true.
    * @postcondition The current element has been removed from this sequence, and
    *                the following element (if there is one) is now the new current
    *                element. If there was no following element, then there is now
    *                no current element.
    * @exception IllegalStateException Indicates that there is no current element,
    *                                  so removeCurrent may not be called.
    **/
   public void removeCurrent() {
      if (!isCurrent()){
         throw new IllegalStateException("No Current Element!");
      }else{
         if(currentIndex==manyItems-1){
            data[currentIndex]=0.0;
            currentIndex=0;
            manyItems--;
         }else{
            for(int i=currentIndex; i<manyItems; i++){
               data[i]=data[i+1];
            }
            manyItems--;
         }
      }
   }

   /**
    * Determine the number of elements in this sequence.
    * 
    * @param - none
    * @return the number of elements in this sequence
    **/
   public int size() { // Determine the number of elements in this sequence.

      return manyItems;
   }

   /**
    * Set the current element at the front of this sequence.
    * 
    * @param - none
    * @postcondition The front element of this sequence is now the current element
    *                (but if this sequence has no elements at all, then there is no
    *                current element).
    **/
   public void start() {
      currentIndex = 0;
   }

   /**
    * Reduce the current capacity of this sequence to its actual size (i.e., the
    * number of elements it contains).
    * 
    * @param - none
    * @postcondition This sequence's capacity has been changed to its current size.
    * @exception OutOfMemoryError Indicates insufficient memory for altering the
    *                             capacity.
    **/
   public void trimToSize() {
      DoubleArraySequence arr = new DoubleArraySequence(this.manyItems);
      for(int i=0; i<arr.getCapacity(); i++){
         arr.data[i]=this.data[i];
      }
      this.data=arr.data;
   }

   public int getCurrentIndex() {
      return currentIndex;
   }

   public void setCurrentIndex(int currentIndex) {
      this.currentIndex = currentIndex;
   }

}
