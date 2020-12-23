object Main{
    import scala.io.Source

    def main(args: Array[String]) = {


        var lines = Source.fromFile("input3.txt").getLines.toList
        var currloc1 = 0
        var currloc2 = 0
        var currloc3 = 0
        var currloc4 = 0
        var currloc5 = 0

        var treecount1: Long  = 0
        var treecount2: Long  = 0
        var treecount3: Long  = 0
        var treecount4: Long  = 0
        var treecount5: Long  = 0


        

        lines = lines

        for ((line,i) <- lines.zipWithIndex){

            if (i !=0){

            

                var treeline = line.toString()
                currloc1 +=3
                currloc2 +=1
                currloc3 +=5
                currloc4 +=7
                

                var char1 = treeline.charAt(currloc1%treeline.length())
                var char2 = treeline.charAt(currloc2%treeline.length())
                var char3 = treeline.charAt(currloc3%treeline.length())
                var char4 = treeline.charAt(currloc4%treeline.length())

                if (char1 == '#') treecount1+=1
                if (char2 == '#') treecount2+=1
                if (char3 == '#') treecount3+=1
                if (char4 == '#') treecount4+=1
            

                if ((i)%2 == 0){

                    currloc5 +=1
                    var char5 = treeline.charAt(currloc5%treeline.length())

                    if (char5 == '#') treecount5+=1

                }

            }
            



        }
        println(treecount2,treecount1,treecount3,treecount4,treecount5)
        println(treecount1*treecount2*treecount3*treecount4*treecount5)

        


    }



}