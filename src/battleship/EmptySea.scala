package battleship
  class EmptySea(bowR:Int, bowCol:Int, hori:Boolean) extends Ship {
	
	var bowRow:Int = bowR
	var bowColumn:Int=bowCol
	var horizontal:Boolean=hori
	var length:Int=1
	var hitArray = new Array[Char](length)
	
	override def getShipType() = "EmptySea"
	
	override def shootAt(row:Int, column:Int, ocean:Ocean): Boolean = false
	
	override def isSunk(): Boolean = false
	
	override def toString():String={
		if(isSunk) "x" else "S"  
	}	
}
