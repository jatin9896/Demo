
object Test extends App{

  val str ="100avd345hjg215uio"
  println(conversion(str.toCharArray.toList, List(), List(), '1', 0, ""))


// consumer6 --
// partial -- shard
// shard -- mutilple -- partition > consumer
// kinesis -- shardPrcessor
// offset --
  // shardId-their
  //
// checkpoint --
  // consumerGroups -- 3 -- exactly
// two list 100, 345 avd,hjg, ==> 100,avd,
  def conversion(input:List[Char], output:List[Int], outputStr:List[String],
                 prev:Char, numResult:Int, strResult:String):(List[String],List[Int]) = {
    input match {
      case currentChar::last if currentChar.isDigit && prev.isDigit => conversion(last, output, outputStr, currentChar, numResult*10 + Integer.parseInt("" + currentChar), strResult)
        case currentChar::last if currentChar.isDigit && prev.isLetter =>  conversion(last, numResult::output, outputStr, currentChar, Integer.parseInt("" + currentChar), strResult)
        case currentChar::last if currentChar.isLetter && prev.isLetter => conversion(last,output,outputStr, currentChar, numResult, strResult + currentChar)
        case currentChar::last if currentChar.isLetter && prev.isDigit =>  conversion(last,output,strResult::outputStr, currentChar, numResult, ""+currentChar)
      case Nil => (strResult::outputStr, numResult::output)
    }
  }

val a:Option[Int]=Some(2)
val b:Option[Int]=Some(3)
val c:Option[Int]=None
  //Option[]
  //x2+x+1
  //Some(None)
  //di
  // funtion
  // isDefined == only -- PartialFc
  //Partial Applied sum(a:Int,b:Int) => Int sum(10,_) => function pSum(20) => value
  //currying sum=(a:Int)(b:Int) => a+b -- Tihis will return funtion as  value sum(10)(20) => 30
  //BlackCat extend Cat speak ==("") Dog
  implicit def speak(): Unit = {

  }

  //state ->
  //
  val cat =
  println(a.flatMap(res=> b.map(res1 => res+res1).map(res5=> c.map(res4=> res5+res4))))
}
