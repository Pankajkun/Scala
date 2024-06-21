object GameOfLife2 {
  case class Cell(x: Int, y: Int)

  def neighbors(cell: Cell): Set[Cell] = {
    val dx = List(-1, 0, 1)
    val dy = List(-1, 0, 1)
    (for {
      nx <- dx
      ny <- dy
      if !(nx == 0 && ny == 0)
    } yield Cell(cell.x + nx, cell.y + ny)).toSet
  }

  // the next generation
  def nextGeneration(liveCells: Set[Cell]): Set[Cell] = {
    val allNeighbors = liveCells.flatMap(neighbors)
    allNeighbors.filter { cell =>
      val liveNeighborCount = neighbors(cell).count(liveCells.contains)
      liveCells.contains(cell) && (liveNeighborCount == 2 || liveNeighborCount == 3) ||
        !liveCells.contains(cell) && liveNeighborCount == 3
    }
  }

  def printGrid(grid: Set[Cell]): Unit = {
    val (minX, minY, maxX, maxY) = (
      grid.map(_.x).min, grid.map(_.y).min,
      grid.map(_.x).max, grid.map(_.y).max
    )

    for (y <- minY to maxY) {
      for (x <- minX to maxX) {
        if (grid.contains(Cell(x, y))) print("* ") else print("  ")
      }
      println()
    }
  }

  def main(args: Array[String]): Unit = {
    // * pattern
    val blinker = Set(Cell(1, 0), Cell(2, 0), Cell(3, 0), Cell(1, 1), Cell(1, 2), Cell(0, 3), Cell(2, 1), Cell(1, 3))
    val generations = Iterator.iterate(blinker)(nextGeneration)
    generations.take(5).foreach(printGrid)
  }
}
