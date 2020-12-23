object Main{
    import scala.io.Source
    import scala.util.matching.Regex


    def main(args: Array[String]) = 
    {


        var lines = Source.fromFile("input4.txt").getLines.toList

        var passports = splitBySeparator(lines,"")
        var invalid = 0
        var invalid2 = 0

        var checks = scala.collection.mutable.Set[String]("byr","iyr","eyr","hgt","hcl","ecl","pid","cid")
        val coltypes = List("amb","blu","brn","gry","grn", "hzl","oth")




        var masterlist = List()

        for (passport <- passports){

            var valid = true

            var givenCode = scala.collection.mutable.Set[String]()
            var temp = scala.collection.mutable.Set[List[String]]()


            for (entry <- passport){
                var fields = entry.split(" ")
                for (code <-fields){
                    givenCode += code.split(":")(0)
                    temp += code.split(":").toList
                }
            }
            var differ = checks.diff(givenCode).toList

            var givenCode2 = temp.toList

            if (givenCode2.length == 8 | givenCode2.length == 7 ){

                for (value <- givenCode2){

                    if (value(0) == "byr"){
                        if (!(1920 <= value(1).toInt && value(1).toInt <=2002)) {valid = false  
                            }
                    }
                    if (value(0) == "iyr"){
                        if (!(2010 <=  value(1).toInt && value(1).toInt <=2020)) {valid = false  
                            }
                    }
                    if (value(0) == "eyr"){
                        if (!(2020 <=  value(1).toInt && value(1).toInt <=2030)) {valid = false  
                            }
                    }
                     if (value(0) == "hgt"){
                        if (!(value(1).matches("\\d+(cm|in)"))) {valid = false  
                        }
                        var unit = ("cm|in".r findFirstIn(value(1))).mkString
                        var measure = ("\\d".r findAllIn(value(1))).mkString.toInt
                        if (unit == "cm"){
                            if (!(measure >= 150 && measure <= 193)) valid = false  
                            
                            }
                        if (unit == "in"){
                            if (!(59 <= measure && measure <= 76)) valid = false  
                            
                        }
                            
                    }
                    if (value(0) == "hcl"){
                        if (!(value(1).matches("#[0-9a-f]{6}"))) {valid = false  
                            }
                    }
                    if (value(0) == "ecl"){
                        if(!(value(1).matches("amb|blu|brn|gry|grn|hzl|oth"))) {valid = false  
                            }
                    }
                    if (value(0) == "pid"){
                        if (!(value(1).matches("\\d{9}"))){valid = false  
                            }
                    }
                }

                var tempset = scala.collection.mutable.Set[String]()
                for (value <- givenCode2){

                    tempset+= value(0)

                    
                }
                var differ2 = checks.diff(tempset).toList
                if(differ2.length == 1) {
                    if(differ2(0)!= "cid"){
                        valid = false

                    }
                }
            }
            if(givenCode2.length <=6){
                valid = false
            }


            if (valid == false) {invalid2 += 1
                }



            if(differ.length >=2) {
                invalid+=1
            }
            if(differ.length == 1) {
                if(differ(0)!= "cid"){
                    invalid+=1

                } 
            }





            
            
        }
        var valid1 = passports.length - invalid
        var valid2 = passports.length - invalid2
        println(valid1, valid2)
      


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

