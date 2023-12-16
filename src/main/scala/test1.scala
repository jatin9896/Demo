
object test1 extends  App {

  val input = List(List("a", "b"), List("a", "b"))
  // list("a",b,a,b)

  input.map(x=> x.map(y=> y.toUpperCase))
  input.flatMap(x=> x.map(y=> y.toUpperCase))
  val fun = (a:Int,b:Int) => a+b


}
/*def operation(f=>f , x:Int, y:Int) ={

}*/
