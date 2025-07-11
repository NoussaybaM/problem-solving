//package functionalproginscalabook
//
//import scala.annotation.tailrec
//
//sealed trait List[+A]
//
//case object Nil extends List[Nothing]
//
//case class Cons[+A](head: A, tail: List[A]) extends List[A]
//
//object List {
//  def sum(ints: List[Int]): Int = ints match {
//    case Nil => 0
//    case Cons(x, xs) => x + sum(xs)
//  }
//
//  def product(ints: List[Int]): Int = ints match {
//    case Nil => 1
//    case Cons(x, xs) => x * product(xs)
//  }
//
//  def apply[A](as: A*): List[A] =
//    if (as.isEmpty) Nil
//    else Cons(as.head, apply(as.tail: _*))
//
//  def tail[A](l: List[A]): List[A] = {
//    l match {
//      case Nil => Nil
//      case Cons(_, xs) => xs
//    }
//  }
//
//  def drop[A](l: List[A], n: Int): List[A] = {
//    @tailrec
//    def loop(xs: List[A], count: Int): List[A] = xs match {
//      case _ if count <= 0 => xs // done dropping
//      case Nil => Nil // drop from empty list = Nil
//      case Cons(_, t) => loop(t, count - 1) // drop head, recurse
//    }
//
//    loop(l, n)
//  }
//
//  def dropWhilee[A](l: List[A], f: A => Boolean): List[A] = {
//    l match {
//      case Nil => Nil
//      case Cons(x, xs) if f(x) => dropWhilee(xs, f)
//      case _ => _
//    }
//  }
//
//  def init[A](l: List[A]): List[A] = l match {
//    case Nil => sys.error("init of empty list")
//    case Cons(_, Nil) => Nil // drop the last element
//    case Cons(h, t) => Cons(h, init(t)) // recursively build list
//  }
//  //  val x = Vector.iterate("A",5)(_=>toString)
//
//  def foldRight[A, B](as: List[A], z: B)(f: (A, B) => B): B = {
//    as match {
//      case Nil => z
//      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
//    }
//  }
//
//  def sum2(ns: List[Int]): Int = foldRight(ns, 0)((x, y) => x + y)
//
//  def product2(ns: List[Int]): Int = {
//    foldRight(ns, 1)(_ * _)
//  }
//
//  def length[A](as: List[A]): Int = {
//    foldRight(as, 0)((_, y) => y + 1)
//  }
//
//  def foldleft[A, B](l: List[A], z: B)(f: (B, A) => B): B = {
//    def loop(acc: B, list: List[A]): B = list match {
//      case Nil => acc
//      case Cons(x, xs) => loop(f(acc, x), xs)
//    }
//
//    loop(z, l)
//  }
//
//  def sum3(l: List[Int]): Int = {
//    foldleft(l, 0)(_ + _)
//  }
//
//  def product3(l: List[Int]): Int = foldleft(l, 1)(_ * _)
//
//  def length3(l: List[Int]): Int = foldleft(l, 0)((x, _) => x + 1)
//
//  def reverse(l: List[Int]): List[Int] = {
//    foldRight(l, Nil: List[Int])((x, y) => Cons(x, y))
//  }
//
//  def transformint(l: List[Int]): List[Int] = {
//    l match {
//      case Nil => Nil
//      case _ => foldleft(l, Nil: List[Int])((x, y) => Cons(y + 1, x))
//    }
//  }
//}