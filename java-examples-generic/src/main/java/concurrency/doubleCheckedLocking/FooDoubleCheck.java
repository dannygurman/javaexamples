package concurrency.doubleCheckedLocking;

//Broken multithreaded version
//"Double-Checked Locking" idiom
public class FooDoubleCheck {
	private Helper helper;
	public Helper getHelper() {
		if (helper == null) {
			synchronized(this) {
				if (helper == null) {
					helper = new Helper();
				}
			}
		}
		return helper;
	}

	// other functions and members...
}
/*
Intuitively, this algorithm seems like an efficient solution to the problem. 
However, this technique has many subtle problems and should usually be avoided.
 For example, consider the following sequence of events:
 1.
Thread A notices that the value is not initialized, so it obtains the lock and begins to initialize the value.
2.
Due to the semantics of some programming languages, 
the code generated by the compiler is allowed to update the shared variable to point to a partially constructed object 
before A has finished performing the initialization. For example,
in Java if a call to a constructor has been inlined then the shared variable may immediately
be updated once the storage has been allocated but before the inlined constructor initializes the object.[4]
  
  
Thread B notices that the shared variable has been initialized (or so it appears), and returns its value.
Because thread B believes the value is already initialized, it does not acquire the lock.
If B uses the object before all of the initialization done by A is seen by B (either because A has not finished initializing it
or because some of the initialized values in the object have not yet percolated to the memory B uses (cache coherence)),
the program will likely crash.*/