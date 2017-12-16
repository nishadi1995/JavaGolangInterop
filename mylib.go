package main

import "C"

import (
	"encoding/base64"
	"math"
)

//export Add
func Add(a, b int) int {
	return a + b
}

//export Cos
func Cos(x float64) float64 {
	return math.Cos(x)
}

//export Base64
func Base64(str string) *C.char {
	x := base64.StdEncoding.EncodeToString([]byte(str))
	return C.CString(x)
}

//export Sum
func Sum(numbers []int) int {
	total := 0
	for _, num := range numbers {
		total += num
	}
	return total
}

func main() {}
