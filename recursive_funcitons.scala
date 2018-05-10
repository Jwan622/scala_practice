def findKth[A](k:Int, l:List[A]):A = {
	try l(k)
	catch {
		case e:IndexOutOfBoundsException => throw new NoSuchElementException
	}
}

(findKth[Int](1, List(2,3,4)))

def findKth1[A](k:Int, l:List[A]):A = (k, l) match {
	case (0, h::_) => h
	case(k, _::tail) if k > 0 => findKth1(k - 1, tail)
	case _ => throw new NoSuchElementException
}

findKth1(2, List(3,4,5,6))


def listAnalysis(list: List[Any]) = list match {
	case Nil => "empty"
	case 'a' :: tail => "starting by 'a'"
	case (head:Int) :: _ if head > 3 => "starting by an int greater than 3"
	case (head:Int) :: _ => "starting by an int"
	case _ => "whatever"
}

listAnalysis(List("a",2,3,4))
4 :: List(1,2,3)
List(1,2,3).::(4)

def length[A](l:List[A]):Int = l.foldLeft(0) {
	(c,d) => println(c)
		println(d)
		c + 1
}
var someList = List("a","b","c","d")
length(someList)

def lastNth[A](n: Int, l:List[A]): A = {
	def length[A](l:List[A]):Int = {
		def lengthN[A](n:Int, l:List[A]):Int = l match {
			case Nil => n
			case _::tail => lengthN(n + 1, tail)
		}
		lengthN(0,l)
	}

	def findKth[A](k:Int, l:List[A]):A = (k,l) match {
		case (0, h::_) => h
		case (k, _::tail) if k > 0 => findKth(k - 1, tail)
		case _ => throw new NoSuchElementException
	}
	val k = length(l) - n
	findKth(k, l)
}
// this algo makes sense
// findKth takes the head once we've wittled down the list starting from the left
var someList = lastNth(2, List("a","b","c","d", "e"))
