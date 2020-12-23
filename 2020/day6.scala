object Main{
    import scala.io.Source
    import scala.util.matching.Regex
    import scala.util.control.Breaks._
    def main(args: Array[String]) = 
    {
        val lines = Source.fromFile("input6.txt").getLines.toList

        val group = splitBySeparator(lines,"")

        var numQuestions = 0
        var numQuestions2 = 0

        var numpeople = 0
        var count = 0

        for (response <-group)
        {
            var qs = response.mkString.toSet
            numQuestions += qs.size
            var responseStr = response.mkString
            numpeople = response.length

            for (chr <- qs)
            {
                count = responseStr.count(_ == chr)
                if (count == numpeople) numQuestions2+=1

            }


        }
        println(numQuestions, numQuestions2)

        


    }



    def splitBySeparator[T](list: List[T], sep: T): List[List[T]] = 
    {
        list.foldRight(List(List[T]()))((s, l) => 
        {
            if (sep == s) 
            {
                List() :: l
            } 
            else 
            {
                (s :: l.head) :: l.tail
            }
            
        }).filter(_.nonEmpty)
    }

}
