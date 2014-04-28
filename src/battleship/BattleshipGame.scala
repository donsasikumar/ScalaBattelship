package battleship

import scala.collection.immutable.Range
import scala.util.Random

object BattleshipGame{
  
	var ocean = new Ocean
	var continueFlag:Char = 'y'
	var row:Int = 0
	var column:Int = 0
	val MIN_ROW = 0
	val MIN_COL = 0
	val MAX_ROW = 9
	val MAX_COL = 9

   def main(args:Array[String]){
	    var count =0;
	    var myArray = ocean.ships
	    ocean.fillShipWithEmptySea
	    
	    println ("Empty Sea")
	    show()
	    
	    
	    println(ocean.placeAllShipsRandomnly)
	    
	    println("Legends : ")
	    println("S 		indicates location of fired at and hit a ship")
	    println("- 		indicates location of fired at and found nothing")
	    println(". 		indicates location never fired at")
	    println("x 		indicates location of a sunken ship")
	    println("a 		indicates location of an Aircraft")
	    println("b 		indicates location of a Battleship")
	    println("s 		indicates location of a Submarine")
	    println("d 		indicates location of a Destroyer")
	    println("p 		indicates location of a Patrol Boat")
		
	    println("\nShips in Sea\n");    
	    show()

	    while(ocean.isGameOver!=true)
	      getUserInput

  }
	
	def show(){
	    println("\n");
	    println("0,0   0     1     2     3     4     5     6     7     8     9")
	    	for(i <- 0 to 9){
	    	  print(i)
		  for(j <- 0 to 9){
		    print("     "+ocean.ships(i)(j))
		  }
	    	  println()
	    	  println()
	    	}	  
	}
	
	def getUserInput() {

		do {
			print("\nEnter row (i.e. a value from 0 to 9):")
		    row = Console.readInt
		} while ((row < MIN_ROW) || (row > MAX_ROW))

		  do {
		    print("\nEnter column (i.e. a value from 0 to 9):")
		    column = Console.readInt
		} while ((column < MIN_COL) || (column > MAX_COL))
	    
	    ocean.isOccupied(row, column) 
	    ocean.shootAt(row, column)
	    show()
	    if(ocean.isGameOver){
	      println("\nALL SHIPS SUNK!!!! GAME OVER")
	      println("\nNo of shots required to sink all ships :"+ocean.shotsFired)
	    }
	      else{
	        print ("\nGame not over! Wish to Continue(y/n)? :")
	        continueFlag = Console.readChar
	        if(continueFlag=='n')
	          System.exit(1)
	      }	        
	}

}