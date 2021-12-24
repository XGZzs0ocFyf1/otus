val a = 2

val x = 5
val customFunction = ( f: Int => Int) => (a: Int, b: Int) => if (f(a) > f(b)) a else b

val t = customFunction( x => x)(5, 5)
Set
