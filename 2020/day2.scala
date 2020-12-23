object Main{
    import scala.io.Source

    def main(args: Array[String]) = {


        val lines = Source.fromFile("input2.txt").getLines.toVector
        var valid1 = 0
        var valid2 = 0

        for (line <- lines){

            var temp = line.toString().split(" ")

            var nums = temp(0).split("-")

            var min = nums(0).toInt
            var max = nums(1).toInt


            var letter = temp(1).split(":")(0)

            var inputstr = temp(2)

            var minchar=  inputstr.charAt(min-1).toString
            var maxchar= inputstr.charAt(max-1).toString


            var count = inputstr.count(_.toString == letter)

            if (count <= max && count >= min) valid1+=1

            if (minchar == letter && maxchar != letter){
                valid2 +=1
            }
            else if (minchar != letter && maxchar == letter){
                valid2 +=1
            }

    

        }
        println(valid1, valid2)



        

        





    }
    


    


}

