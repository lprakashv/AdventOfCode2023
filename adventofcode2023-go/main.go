package main

import (
	"fmt"

	"com.github/lprakashv/adventofcode2023/problems"
)

func main() {
	fmt.Printf(`
	Solutions:
		day1-1 => %v
		day1-2 => %v
	`,
		problems.CalibrationSum1(),
		problems.CalibrationSum2(),
	)
}
