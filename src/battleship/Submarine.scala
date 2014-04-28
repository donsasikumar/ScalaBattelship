package battleship

class Submarine(bowR:Int, bowCol:Int, hori:Boolean) extends Ship {
	
	var bowRow:Int = bowR
	var bowColumn:Int=bowCol
	var horizontal:Boolean=hori
	var length:Int=3
	var hitArray = new Array[Char](length)

	
	override def getShipType() = "Submarine"
		
	override def toString():String={
		if(isSunk) "x" else "S"  
	}
	
}
  
  