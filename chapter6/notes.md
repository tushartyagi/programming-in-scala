# Functional Objects

* Objects which don't mutate
* Class definition can take parameters in Scala and the code which is
outside the method definition and field becomes the part of the
primary constructor.
* While the primary constructor is free, we can define "auxillary
constructor". The first step of any auxillary constructor is to call
another constructor of the class; this can be either primary or another
auxillary.
* Only the primary constructor can call the superclass constructor.


