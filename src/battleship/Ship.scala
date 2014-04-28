package battleship

trait Ship{
	
	var bowRow:Int
	var bowColumn:Int
	var horizontal:Boolean
	var length:Int
	var sunkFlag = false
	var hitArray:Array[Char]
	val MAX_ROW:Int = 10
	val MAX_COL:Int = 10
	
	def getLength:Int = length

	def getBowRow = bowRow
	
	def getBowColumn = bowColumn
	
	def isHorizontal: Boolean = horizontal
	
	def setBowRow(row: Int) = { this.bowRow = row }
	
	def setBowColumn(column: Int) = { this.bowColumn = column }
	
	def setHorizontal(horizontal: Boolean) = { this.horizontal = horizontal }
	
	def getShipType()
	
	def okToPlaceShipAt(row: Int, column: Int, hori: Boolean, ocean: Ocean): Boolean = {
		
		var blnRowResult:Boolean = false
		var blnColResult:Boolean = false
		
		var count:Int = 0

		for(i <- 0 until this.length) { 
			//returns true if the ship can be positioned at this position.
		    if ((row + i) < MAX_ROW) {
		      println("checkingA.."+(ocean.ships(row+i)(column)=='.'))
		      println("checkingH.."+hori)
		      println("checkingR.."+row)
		      println("checkingC.."+column)
		      println("checkingL.."+length)
				if((ocean.ships(row+i)(column)=='.') && (hori)) { 
					count += 1
					if (count == length) blnRowResult = true
				}
			}
		      println("checkingA.."+(ocean.ships(row+i)(column)=='.'))
		      println("checkingH.."+hori)
		      println("checkingR.."+row)
		      println("checkingC.."+column)
		      println("checkingL.."+length)
		    if ((column + i) < MAX_COL) {
				if((ocean.ships(row)(column+i)=='.') && (!hori)) {
					count += 1
					if (count == length) blnColResult = true
				}
		    }
		}
		return blnRowResult && blnColResult
	}
	
	def placeShipAt(row: Int, column: Int, horizontal: Boolean, ocean: Ocean) = {
		
		this.setBowRow(row)
		this.setBowColumn(column)
		this.setHorizontal(horizontal)
		println("***"+row)
		println("***"+column)
		println("***"+horizontal)
		println("***"+length)
		for(i <- 0 until (length)){
			if (horizontal) {
				ocean.ships(row+i)(column)='a'//PLEASE CHECK THE char 'a'
			}else{
				ocean.ships(row)(column+i)='a'//PLEASE CHECK THE char 'a'
			}
		} 
	}
	
	def shootAt(row: Int, column: Int, ocean: Ocean): Boolean = {
		if (ocean.ships(row)(column)=='a'){
			if (!isSunk){
				//hitArray[] = ocean.myArray(row)(column)
				return true
			}
		}
		return false
	}
	
	def isSunk(): Boolean={ 
			sunkFlag
	}

}