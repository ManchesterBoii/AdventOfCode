object Main{
    import scala.io.Source
    import scala.util.matching.Regex
    import scala.util.control.Breaks._
    def main(args: Array[String]) = 
    {
        var lines = Source.fromFile("input5.txt").getLines.toList
        var maxId = 0
        var seatId = 0
        var rowrange = List(0,127)
        var rowchar = List('F','B')
        var colrange = List(0,7)
        var colchar = List('L','R')
        var seatIdlst :List[Int]= List()
        for (codes <- lines)
        {
            var rowcodes =  ("F|B".r findAllIn(codes)).mkString.toList
            var colcodes = ("L|R".r findAllIn(codes)).mkString.toList
            var row = findrow(rowcodes,rowrange,rowchar)
            var col = findrow(colcodes,colrange,colchar)
            seatId = (row*8) + col
            if (seatId > maxId) maxId = seatId
            seatIdlst = seatId :: seatIdlst
        }
        breakable(
            for (seat <- seatIdlst.sorted)
            {
                if (!(seatIdlst contains(seat+1)))
                {
                    println(seat+1)
                    break
    
                } 
            }
        )
        println(maxId)
    }
    def findrow(inputRows: List[Char], range: List[Int], commands: List[Char]): Int = 
    {
        var diff: Double = (range(1)-range(0)).asInstanceOf[Double] / 2
        var temp: List[Int] = List(0,0)
        var ranges = range
        for (command <- inputRows)
        {
            if (command == commands(0))
            {
                temp = List( ranges(0).asInstanceOf[Int], (ranges(1) - diff).floor.asInstanceOf[Int])
            }
            else if (command == commands(1))
            {
                temp = List( (ranges(0)+diff).ceil.asInstanceOf[Int], ranges(1).asInstanceOf[Int] )
            }
            ranges = temp
            diff = (ranges(1)-ranges(0)).asInstanceOf[Double] / 2
        }
        ranges(0)
    }
}
