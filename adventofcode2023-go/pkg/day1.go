package pkg

import (
	"strings"

	"com.github/lprakashv/adventofcode2023/input"
)

func CalibrationSum1() int {
	sum := 0

	lines := strings.Split(input.Day1Input, "\n")
	for _, line := range lines {
		var digits []int

		for _, ch := range line {
			if ch >= '0' && ch <= '9' {
				digits = append(digits, int(ch-'0'))
			}
		}

		if len(digits) > 0 {
			sum += digits[0]*10 + digits[len(digits)-1]
		}
	}

	return sum
}

func replaceDigitWords(s string) string {
	replacer := strings.NewReplacer(
		"zero", "z0o",
		"one", "o1e",
		"two", "t2o",
		"three", "t3e",
		"four", "f4r",
		"five", "f5e",
		"six", "s6x",
		"seven", "s7n",
		"eight", "e8t",
		"nine", "n9e",
	)
	return replacer.Replace(s)
}

// TODO - fix this! The answer is off by +2
func CalibrationSum2() int {
	sum := 0

	lines := strings.Split(input.Day1Input, "\n")
	for _, line := range lines {
		replaced := replaceDigitWords(line)

		var digits []int

		for _, ch := range replaced {
			if ch >= '0' && ch <= '9' {
				digits = append(digits, int(ch-'0'))
			}
		}

		if len(digits) > 0 {
			sum += digits[0]*10 + digits[len(digits)-1]
		}
	}

	return sum
}
